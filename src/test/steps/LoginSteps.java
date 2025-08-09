package steps;

import static pages.HomePage.*;
import static pages.LoginPage.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import base.Base;
import io.cucumber.java.en.*;
import pages.HomePage;

import static utils.CommonUtils.*;

public class LoginSteps extends Base{

    @Test(groups = {"Login"})
    public void completeLoginFlow(){

        PageFactory.initElements(driver.get(), HomePage.class);

        clickLoginURL().enterValidEmail()
        .enterValidPassword().clickLoginButton().
        verifySuccessfulLogin();
    }
    
    @Given("the user is on the Demo Web Shop login page")
    public LoginSteps clickLoginURL(){
        WebElement login = getDr().findElement(By.cssSelector("a.ico-login"));
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
        //new Actions(getDr()).sendKeys(Keys.PAGE_DOWN).perform();
        loginButton.click();
        return this;
    }

    @Then("the user should be logged in successfully")
    public LoginSteps verifySuccessfulLogin() {
        return this;
    }
}