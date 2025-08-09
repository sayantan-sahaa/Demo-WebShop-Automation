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
        clickLoginURL().enterValidEmail()
        .enterValidPassword().clickLoginButton().
        verifySuccessfulLogin();
    }
    
    @Given("the user is on the Demo Web Shop login page")
    public LoginSteps clickLoginURL(){
        loginURL.click();
        return this;
    }
    
    @When("the user enters valid email address")
    public LoginSteps enterValidEmail() {
        email.sendKeys("test@example.com");
        return this;
    }

    @And("the user enters valid password")
    public LoginSteps enterValidPassword() {
        password.sendKeys("password123");
        return this;
    }

    @And("the user clicks on the login button")
    public LoginSteps clickLoginButton() {
        scrollToElement(loginButton);
        loginButton.click();
        return this;
    }

    @Then("the user should be logged in successfully")
    public LoginSteps verifySuccessfulLogin() {
        return this;
    }
}