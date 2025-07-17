package base;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class FirefoxDriverManager implements DriverManager {

    @Override
    public WebDriver createDriver(){
        return new FirefoxDriver();
    }
}