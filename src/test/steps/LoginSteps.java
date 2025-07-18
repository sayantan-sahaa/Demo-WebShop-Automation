package steps;

import static pages.HomePage.*;
import static pages.LoginPage.*;

import org.testng.annotations.*;

import base.Base;
import io.cucumber.java.en.*;
import static utils.CommonUtils.*;

public class LoginSteps extends Base{

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
        scrollToElement(loginButton);
        //new Actions(getDr()).sendKeys(Keys.PAGE_DOWN).perform();
        loginButton.click();
    }

    @Then("the user should be logged in successfully")
    public void verifySuccessfulLogin() {
    }
}