package base;

import java.util.Set;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.*;
import core_java.Pattern;
import listeners.Listener;
import reporting.ExtentReportUtil;
import utils.Asserts;
import static base.DriverManagerFactory.*;


public class Base {

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeSuite(alwaysRun = true)
    public void setUp() { 
        try {
            
            new Pattern().printPattern1(5).printPattern2(5).
            printPattern3(5);

            ExtentReportUtil.initializeReport();
        
            ScreenShotUtil.startScreenRecord();
                        
            if (driver.get() == null) {
                
                Class.forName("base.BrowserSelector");
                driver.set(getDriverManager("firefox").createDriver());
                
                Listener webDriverListener = new Listener();
                
                WebDriver decoratedWebDriver = new EventFiringDecorator<>(webDriverListener)
                    .decorate(driver.get());
                
                driver.set(decoratedWebDriver);
                
                decoratedWebDriver.manage().window().maximize();
                
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
            System.out.println("Clearing static fields manually...");
            int clearedFields = 0;

            // Manually declare all classes in the framework
            Set<Class<?>> classes = Set.of(
            base.Base.class,
            base.BrowserSelector.class,
            listeners.Listener.class,
            reporting.ExtentReportUtil.class,
            utils.Asserts.class,
            core_java.Pattern.class,
            pages.HomePage.class

            );

            for (Class<?> clazz : classes) {
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