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
        }
    } catch (Exception e) {
        System.err.println("Failed to setup WebDriver: " + e.getMessage());
        e.printStackTrace();
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
    } catch (Exception e) {
        System.err.println("Failed to initialize page elements: " + e.getMessage());
        e.printStackTrace();
    }
}

    @AfterSuite
    public static void tearDown() {
        try {
            // Handle soft assertions if available
            if (softAssert != null) {
                softAssert.assertAll();
            }
        } catch (AssertionError e) {
            System.err.println("Soft assertion failures: " + e.getMessage());
            // Log to Extent Report if available
            try {
                ExtentReportUtil.createTest("Soft Assertion Failure")
                    .fail("Soft assertion(s) failed: " + e.getMessage());
            } catch (Exception reportException) {
                System.err.println("Failed to log to extent report: " + reportException.getMessage());
            }
            throw e;
        } finally {
            // Close WebDriver
            WebDriver webDriver = driver.get();
            if (webDriver != null) {
                try {
                    webDriver.quit();
                    System.out.println("WebDriver closed successfully");
                } catch (Exception e) {
                    System.err.println("Error closing WebDriver: " + e.getMessage());
                }
                driver.remove();
            }

            // Open Extent Report
            try {
                File reportFile = new File("target/ExtentReport.html");
                if (reportFile.exists()) {
                    Desktop.getDesktop().browse(reportFile.toURI());
                    System.out.println("Extent Report opened in browser");
                } else {
                    System.out.println("Extent Report not found: " + reportFile.getAbsolutePath());
                }
            } catch (IOException e) {
                System.err.println("Error opening report: " + e.getMessage());
            }

            clearStaticFields();
        }
    }
    
    private static void clearStaticFields() {
        try {
            Reflections allClasses = new Reflections("base", "pages", 
                                                     "steps", "utils", 
                                                     "reporting", "listeners", 
                                                     "datamodels");
            Set<Class<?>> classesToClear = allClasses.getSubTypesOf(Object.class);

            for (Class<?> clazz : classesToClear) {
                for (java.lang.reflect.Field field : clazz.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) &&
                        !java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                        field.setAccessible(true);
                        try {
                            field.set(null, null);
                        } catch (IllegalAccessException e) {
                            System.err.println("Failed to clear static field: " + field.getName());
                        }
                    }
                }
            }
            System.out.println("Static fields cleared successfully");
        } catch (Exception e) {
            System.err.println("Error clearing static fields: " + e.getMessage());
        }
    }
}