package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.*;
import core_java.Pattern;
import listeners.Listener;
import static base.DriverManagerFactory.*;


public class Base {

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Base(){}

    @BeforeSuite(alwaysRun = true)
    public static void setUp() { 
        try {
            
            new Pattern().printPattern1(5).printPattern2(5).
            printPattern3(5);
                                
            if (driver.get() == null) {
                
                Class.forName("base.BrowserSelector");
                driver.set(getDriverManager("firefox").createDriver());
                
                Listener webDriverListener = new Listener();
                
                WebDriver decoratedWebDriver = new EventFiringDecorator<>(webDriverListener)
                    .decorate(driver.get());
                
                driver.set(decoratedWebDriver);
                
                decoratedWebDriver.manage().window().maximize();
                
                decoratedWebDriver.get("https://demowebshop.tricentis.com/");
                               
            }
        } catch (Exception e) {
            System.err.println("Failed to setup WebDriver: " + e.getMessage());
            e.printStackTrace();
            
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
    public static void tearDown() {  
        
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
            
            
        }
    
    
}