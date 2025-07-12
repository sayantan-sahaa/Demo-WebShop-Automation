package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.AfterGroups;

public class Hooks {

    public static final ThreadLocal <WebDriver> driver = new ThreadLocal<>();

    static{
        DriverManagerFactory driverManager = new DriverManagerFactory();
        driverManager.setdriverMap(Base.class, "firefox");
    }

    @BeforeGroups(groups = {"authentication"})
    public static void setUp() {
        if (driver.get() == null) {
            DriverManagerFactory driverManagerFactory = new DriverManagerFactory();
            DriverManager dm = driverManagerFactory.getDriverManager("firefox");
            WebDriver webDriver = dm.createDriver();
            webDriver.manage().window().maximize();
            webDriver.get("https://demowebshop.tricentis.com/");
            driver.set(webDriver);
        }
    }

    @BeforeGroups(groups = {"authentication"})
    public static WebDriver getDr(){
        return driver.get();
    }

    @AfterGroups(groups = {"authentication"})
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