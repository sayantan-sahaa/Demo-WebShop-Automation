package base;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;


public class Base implements DriverManager{

    @Override
    public WebDriver createDriver(){
        return new FirefoxDriver();
    }

}