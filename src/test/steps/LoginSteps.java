package steps;

import org.openqa.selenium.Keys;

import static pages.HomePage.*;
import static pages.LoginPage.*;
import static utils.CommonUtils.scrollToElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import io.cucumber.java.en.*;

import hooks.Hooks;

public class LoginSteps extends Hooks{

    @Test(groups = {"Login"})
    public void completeLoginFlow(){
        clickLoginURL();
        enterValidEmail();
        enterValidPassword();
        clickLoginButton();
        verifySuccessfulLogin();
    }
    
    @Given("the user is on the Demo Web Shop login page")
    public void clickLoginURL(){
        loginURL.click();
    }
    
    @When("the user enters valid email address")
    public void enterValidEmail() {
        email.sendKeys("test@example.com");
    }

    @And("the user enters valid password")
    public void enterValidPassword() {
        password.sendKeys("password123");
    }

    @And("the user clicks on the login button")
    public void clickLoginButton() {
        //scrollToElement(loginButton);
        new Actions(getDr()).sendKeys(Keys.PAGE_DOWN).perform();
        loginButton.click();
    }

    @Then("the user should be logged in successfully")
    public void verifySuccessfulLogin() {
        // Add your verification logic here
    }
}