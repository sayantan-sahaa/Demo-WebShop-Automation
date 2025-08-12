package base;

public class BrowserSelector {

    static{
        DriverManagerFactory driverManager = new DriverManagerFactory();
        driverManager.setdriverMap(FirefoxDriverManager.class, "firefox");
    }
    
}
