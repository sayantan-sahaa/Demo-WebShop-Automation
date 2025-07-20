package base;

import java.util.Set;
import java.io.File;
import java.lang.reflect.Method;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.reflections.Reflections;
import org.testng.annotations.*;

import core_java.Pattern;

import listeners.Listener;
import reporting.ExtentReportUtil;
import utils.Asserts;


public class Base {

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeSuite(alwaysRun = true)
    public void setUp() { 
        try {
            
            new Pattern().printPattern1(5).printPattern2(5).
            printPattern3(5);

            ExtentReportUtil.initializeReport();
            
            ScreenShotUtil.startScreenRecord();
                        
            DriverManagerFactory driverManager = new DriverManagerFactory();
            driverManager.setdriverMap(FirefoxDriverManager.class, "firefox");
            
            if (driver.get() == null) {
                DriverManagerFactory driverManagerFactory = new DriverManagerFactory();
                DriverManager dm = driverManagerFactory.getDriverManager("firefox");
                WebDriver rawWebDriver = dm.createDriver();
                
                driver.set(rawWebDriver);
                
                Listener webDriverListener = new Listener();
                
                WebDriver decoratedWebDriver = new EventFiringDecorator<>(webDriverListener)
                    .decorate(rawWebDriver);
                
                driver.set(decoratedWebDriver);
                
                decoratedWebDriver.manage().window().maximize();
                
                decoratedWebDriver.manage().deleteAllCookies();
                decoratedWebDriver.get("https://demowebshop.tricentis.com/");
                               
                ExtentReportUtil.createTest("Test Suite Setup")
                    .info("Screen recording started using Meta+Alt+R shortcut")
                    .info("WebDriver initialized successfully")
                    .info("Application URL: https://demowebshop.tricentis.com/")
                    .info("Current URL: " + decoratedWebDriver.getCurrentUrl());
            }
        } catch (Exception e) {
            System.err.println("Failed to setup WebDriver: " + e.getMessage());
            e.printStackTrace();
            
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
    public void initPageElements(Method method) {
        String testName = method.getName();
        
        System.out.println("Initializing page elements for test: " + testName);
        try {
            WebDriver driverInstance = getDr();
            PageFactory.initElements(driverInstance, HomePage.class);
            PageFactory.initElements(driverInstance, LoginPage.class);
            System.out.println("Page elements initialized successfully");
                            
        } catch (Exception e) {
            System.err.println("Failed to initialize page elements: " + e.getMessage());
            e.printStackTrace();
            
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
    public void tearDown() {  
        try {
            System.out.println("Starting test suite teardown...");
            
            // Handle soft assertions if available
            if (Asserts.softAssert != null) {
                try {
                    Asserts.softAssert.assertAll();
                    ExtentReportUtil.createTest("Soft Assertions Validation")
                        .pass("All soft assertions passed successfully");
                } catch (AssertionError e) {
                    System.err.println("Soft assertion failures: " + e.getMessage());
                    
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
            WebDriver webDriver = driver.get();
            if (webDriver != null) {
                try {
                    // Stop screen recording before browser closes
                    ScreenShotUtil.stopScreenRecord();
                    
                    webDriver.quit();
                    System.out.println("WebDriver closed successfully");
                    
                    ExtentReportUtil.createTest("Test Suite Teardown")
                        .info("Screen recording stopped using Meta+Alt+R shortcut")
                        .info("WebDriver closed successfully")
                        .pass("Test suite teardown completed");
                        
                } catch (Exception e) {
                    System.err.println("Error closing WebDriver: " + e.getMessage());
                    
                    ExtentReportUtil.createTest("Test Suite Teardown - WebDriver Error")
                        .fail("Error closing WebDriver: " + e.getMessage())
                        .fail(e);
                }
                driver.remove();
            }

            clearStaticFields();
            
            try {
                System.out.println("Flushing Extent Report...");
                ExtentReportUtil.flushReport();
                System.out.println("Extent Report flushed successfully");
                
                File reportFile = new File("target/ExtentReport.html");
                if (reportFile.exists()) {
                    //openReportInBrowser(reportFile);
                    System.out.println("Extent Report process completed: " + reportFile.getAbsolutePath());
                } else {
                    System.out.println("Extent Report not found: " + reportFile.getAbsolutePath());
                }
                
            } catch (Exception e) {
                System.err.println("Error with Extent Report operations: " + e.getMessage());
            }
        }
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

    
}