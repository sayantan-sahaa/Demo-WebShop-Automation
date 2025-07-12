package hooks;

import java.io.IOException;
import java.util.Set;
import java.awt.Desktop;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.reflections.Reflections;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;

import base.*;
import listeners.Listener;
import reporting.ExtentReportUtil;
import static utils.CommonUtils.*;
import static utils.Asserts.*;

public class Hooks {

    public static final ThreadLocal <WebDriver> driver = new ThreadLocal<>();

    public static void main(String[] args) {
        
    }
    //static {
    @BeforeSuite
    public static void setUp() {
        
        DriverManagerFactory driverManager = new DriverManagerFactory();
        driverManager.setdriverMap(Base.class, "firefox");
        if (driver.get() == null) {
            DriverManagerFactory driverManagerFactory = new DriverManagerFactory();
            DriverManager dm = driverManagerFactory.getDriverManager("firefox");
            WebDriver webDriver = dm.createDriver();
            webDriver.manage().window().maximize();
            webDriver.get("https://demowebshop.tricentis.com/");
            driver.set(webDriver);
        }
    
    }
    @BeforeSuite
    public static WebDriver getDr(){
        return driver.get();
    }

    @AfterSuite
    public static void tearDown() {
        if (getDr() != null) {
            getDr().quit();
            driver.remove();
        }

        try {
            
        } catch (Exception e) {
        } finally{
            
        }
    }
}