package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage{

    //Page Factory
    @FindBy(id = "RememberMe")
    public static WebElement username;

    @FindBy(className = "email")
    public static WebElement email;

    @FindBy(className = "password")
    public static WebElement password;

    @FindBy(css = ".button-1.login-button")  // No spaces between classes in CSS
    public static WebElement loginButton;
      
}