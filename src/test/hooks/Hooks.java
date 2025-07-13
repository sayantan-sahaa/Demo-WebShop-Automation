package hooks;

import java.io.IOException;
import java.util.Set;
import java.awt.Desktop;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.reflections.Reflections;
import org.testng.annotations.*;

import base.*;
import listeners.Listener;
import pages.HomePage;
import pages.LoginPage;
import reporting.ExtentReportUtil;
import static utils.Asserts.*;

public class Hooks {

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void main(String[] args) {
        
    }
    
    @BeforeSuite
    public static void setUp() {
        try {
            System.out.println("Initializing Extent Report...");
            // Initialize ExtentReport first
            ExtentReportUtil.initializeReport();
            System.out.println("Extent Report initialized successfully");
            
            System.out.println("Setting up WebDriver with listeners...");
            
            DriverManagerFactory driverManager = new DriverManagerFactory();
            driverManager.setdriverMap(Base.class, "firefox");
            
            if (driver.get() == null) {
                DriverManagerFactory driverManagerFactory = new DriverManagerFactory();
                DriverManager dm = driverManagerFactory.getDriverManager("firefox");
                WebDriver rawWebDriver = dm.createDriver();
                
                // Set the raw WebDriver in ThreadLocal FIRST
                driver.set(rawWebDriver);
                
                // Create the WebDriver listener
                Listener webDriverListener = new Listener();
                
                // Wrap the WebDriver with EventFiringDecorator to attach listeners
                WebDriver decoratedWebDriver = new EventFiringDecorator<>(webDriverListener)
                    .decorate(rawWebDriver);
                
                // Update the ThreadLocal with decorated WebDriver
                driver.set(decoratedWebDriver);
                
                // Configure the decorated WebDriver
                decoratedWebDriver.manage().window().maximize();
                decoratedWebDriver.manage().deleteAllCookies();
                decoratedWebDriver.get("https://demowebshop.tricentis.com/");
                
                System.out.println("WebDriver setup completed with listeners attached");
                System.out.println("Current URL: " + decoratedWebDriver.getCurrentUrl());
                
                // Log setup completion to ExtentReport
                ExtentReportUtil.createTest("Test Suite Setup")
                    .info("WebDriver initialized successfully")
                    .info("Browser: Firefox")
                    .info("Application URL: https://demowebshop.tricentis.com/")
                    .info("Current URL: " + decoratedWebDriver.getCurrentUrl());
            }
        } catch (Exception e) {
            System.err.println("Failed to setup WebDriver: " + e.getMessage());
            e.printStackTrace();
            
            // Log error to ExtentReport if initialized
            try {
                ExtentReportUtil.createTest("Test Suite Setup - FAILED")
                    .fail("WebDriver initialization failed: " + e.getMessage())
                    .fail(e);
            } catch (Exception reportException) {
                System.err.println("Failed to log error to Extent Report: " + reportException.getMessage());
            }
            
            throw new RuntimeException("WebDriver initialization failed", e);
        }
    }
    
    public static WebDriver getDr() {
        WebDriver webDriver = driver.get();
        if (webDriver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Call setUp() first.");
        }
        return webDriver;
    }

    @BeforeMethod
    public void initPageElements() {
        System.out.println("Initializing page elements...");
        try {
            WebDriver driver = getDr();
            PageFactory.initElements(driver, HomePage.class);
            PageFactory.initElements(driver, LoginPage.class);
            System.out.println("Page elements initialized successfully");
            
            // Log page element initialization to ExtentReport
            ExtentReportUtil.createTest("Page Elements Initialization")
                .info("HomePage elements initialized")
                .info("LoginPage elements initialized")
                .pass("Page factory initialization completed successfully");
                
        } catch (Exception e) {
            System.err.println("Failed to initialize page elements: " + e.getMessage());
            e.printStackTrace();
            
            // Log error to ExtentReport
            try {
                ExtentReportUtil.createTest("Page Elements Initialization - FAILED")
                    .fail("Failed to initialize page elements: " + e.getMessage())
                    .fail(e);
            } catch (Exception reportException) {
                System.err.println("Failed to log error to Extent Report: " + reportException.getMessage());
            }
        }
    }

    @AfterSuite
    public static void tearDown() {
        try {
            System.out.println("Starting test suite teardown...");
            
            // Handle soft assertions if available
            if (softAssert != null) {
                try {
                    softAssert.assertAll();
                    ExtentReportUtil.createTest("Soft Assertions Validation")
                        .pass("All soft assertions passed successfully");
                } catch (AssertionError e) {
                    System.err.println("Soft assertion failures: " + e.getMessage());
                    
                    // Log to Extent Report
                    ExtentReportUtil.createTest("Soft Assertions Validation - FAILED")
                        .fail("Soft assertion(s) failed: " + e.getMessage())
                        .fail(e);
                    
                    throw e;
                }
            }
        } catch (AssertionError e) {
            System.err.println("Soft assertion failures: " + e.getMessage());
            throw e;
        } finally {
            // Close WebDriver
            WebDriver webDriver = driver.get();
            if (webDriver != null) {
                try {
                    webDriver.quit();
                    System.out.println("WebDriver closed successfully");
                    
                    // Log WebDriver closure to ExtentReport
                    ExtentReportUtil.createTest("Test Suite Teardown")
                        .info("WebDriver closed successfully")
                        .pass("Test suite teardown completed");
                        
                } catch (Exception e) {
                    System.err.println("Error closing WebDriver: " + e.getMessage());
                    
                    // Log error to ExtentReport
                    ExtentReportUtil.createTest("Test Suite Teardown - WebDriver Error")
                        .fail("Error closing WebDriver: " + e.getMessage())
                        .fail(e);
                }
                driver.remove();
            }

            // Clear static fields
            clearStaticFields();
            
            // Flush ExtentReport and open it with enhanced browser opening
            try {
                System.out.println("Flushing Extent Report...");
                ExtentReportUtil.flushReport();
                System.out.println("Extent Report flushed successfully");
                
                File reportFile = new File("target/ExtentReport.html");
                if (reportFile.exists()) {
                    openReportInBrowser(reportFile);
                    System.out.println("Extent Report process completed: " + reportFile.getAbsolutePath());
                } else {
                    System.out.println("Extent Report not found: " + reportFile.getAbsolutePath());
                }
            } catch (Exception e) {
                System.err.println("Error with Extent Report operations: " + e.getMessage());
            }
        }
    }
    
    /**
     * Platform-specific browser opening method
     * @param reportFile The report file to open
     */
    private static void openReportInBrowser(File reportFile) {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String reportPath = reportFile.getAbsolutePath();
            
            System.out.println("Attempting to open report in browser...");
            System.out.println("Operating System: " + os);
            System.out.println("Report Path: " + reportPath);
            
            if (os.contains("linux")) {
                // Check if running in a GUI environment
                String display = System.getenv("DISPLAY");
                if (display == null || display.trim().isEmpty()) {
                    System.out.println("No display detected (headless environment).");
                    System.out.println("Report available at: " + reportPath);
                    return;
                }
                
                // Try different browsers on Linux in order of preference
                String[] browsers = {"firefox", "google-chrome", "chromium-browser", "xdg-open"};
                
                boolean opened = false;
                for (String browser : browsers) {
                    try {
                        System.out.println("Trying to open with: " + browser);
                        ProcessBuilder processBuilder = new ProcessBuilder(browser, reportPath);
                        processBuilder.start();
                        System.out.println("Successfully opened report with: " + browser);
                        opened = true;
                        break;
                    } catch (IOException e) {
                        System.out.println("Failed to open with " + browser + ": " + e.getMessage());
                    }
                }
                
                if (!opened) {
                    System.out.println("Could not open browser automatically on Linux.");
                    System.out.println("Please manually open: " + reportPath);
                    System.out.println("Or run: firefox " + reportPath);
                }
                
            } else if (os.contains("windows")) {
                // Windows
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "start", "\"\"", reportPath);
                    processBuilder.start();
                    System.out.println("Opened report with Windows default browser");
                } catch (IOException e) {
                    System.err.println("Failed to open browser on Windows: " + e.getMessage());
                    System.out.println("Report available at: " + reportPath);
                }
                
            } else if (os.contains("mac")) {
                // macOS
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder("open", reportPath);
                    processBuilder.start();
                    System.out.println("Opened report with macOS default browser");
                } catch (IOException e) {
                    System.err.println("Failed to open browser on macOS: " + e.getMessage());
                    System.out.println("Report available at: " + reportPath);
                }
                
            } else {
                // Fallback to Desktop API for other systems
                try {
                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        Desktop.getDesktop().browse(reportFile.toURI());
                        System.out.println("Opened report using Desktop API");
                    } else {
                        System.out.println("Desktop browsing not supported on this system");
                        System.out.println("Report available at: " + reportPath);
                    }
                } catch (Exception e) {
                    System.err.println("Desktop API failed: " + e.getMessage());
                    System.out.println("Report available at: " + reportPath);
                }
            }
            
        } catch (Exception e) {
            System.err.println("Error opening report in browser: " + e.getMessage());
            System.out.println("Report available at: " + reportFile.getAbsolutePath());
            
            // Provide manual commands for different systems
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("linux")) {
                System.out.println("Manual command: firefox " + reportFile.getAbsolutePath());
            } else if (os.contains("windows")) {
                System.out.println("Manual command: start " + reportFile.getAbsolutePath());
            } else if (os.contains("mac")) {
                System.out.println("Manual command: open " + reportFile.getAbsolutePath());
            }
        }
    }
    
    /**
     * Check if browser opening should be attempted
     * @return true if browser should be opened, false otherwise
     */
    private static boolean shouldOpenBrowser() {
        String openBrowser = System.getProperty("open.report.browser", "true");
        return Boolean.parseBoolean(openBrowser);
    }
    
    private static void clearStaticFields() {
        try {
            System.out.println("Clearing static fields...");
            
            Reflections allClasses = new Reflections("base", "pages", 
                                                     "steps", "utils", 
                                                     "reporting", "listeners", 
                                                     "datamodels");
            Set<Class<?>> classesToClear = allClasses.getSubTypesOf(Object.class);

            int clearedFields = 0;
            for (Class<?> clazz : classesToClear) {
                for (java.lang.reflect.Field field : clazz.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) &&
                        !java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                        field.setAccessible(true);
                        try {
                            field.set(null, null);
                            clearedFields++;
                        } catch (IllegalAccessException e) {
                            System.err.println("Failed to clear static field: " + field.getName());
                        }
                    }
                }
            }
            System.out.println("Static fields cleared successfully. Total fields cleared: " + clearedFields);
            
        } catch (Exception e) {
            System.err.println("Error clearing static fields: " + e.getMessage());
        }
    }
    
    // Utility method to get current test for logging from test methods
    public static void logToExtentReport(String testName, String message, String status) {
        try {
            switch (status.toLowerCase()) {
                case "pass":
                    ExtentReportUtil.createTest(testName).pass(message);
                    break;
                case "fail":
                    ExtentReportUtil.createTest(testName).fail(message);
                    break;
                case "info":
                    ExtentReportUtil.createTest(testName).info(message);
                    break;
                case "warning":
                    ExtentReportUtil.createTest(testName).warning(message);
                    break;
                default:
                    ExtentReportUtil.createTest(testName).info(message);
            }
        } catch (Exception e) {
            System.err.println("Failed to log to Extent Report: " + e.getMessage());
        }
    }
}