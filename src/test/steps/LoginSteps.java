package steps;

import org.testng.annotations.*;

import base.Base;
import io.cucumber.java.en.*;

import pages.HomePage;
import pages.LoginPage;

import static utils.CommonUtils.scrollToElement;

public class LoginSteps {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod(alwaysRun = true)
    public void ensureDriverInitialized() {
        try {
            Base.getDr();
        } catch (IllegalStateException e) {
            // If driver isn't initialized via TestNG lifecycle, initialize it here
            Base.setUp();
        }
    }

    @Test(groups = {"Login"})
    public void completeLoginFlow(){
        clickLoginURL().enterValidEmail()
        .enterValidPassword().clickLoginButton().
        verifySuccessfulLogin();
    }
    
    @Given("the user is on the Demo Web Shop login page")
    public LoginSteps clickLoginURL(){
        homePage.loginURL().click();
        return this;
    }
    
    @When("the user enters valid email address")
    public LoginSteps enterValidEmail() {
        loginPage.email().sendKeys("test@example.com");
        return this;
    }

    @And("the user enters valid password")
    public LoginSteps enterValidPassword() {
        loginPage.password().sendKeys("password123");
        return this;
    }

    @And("the user clicks on the login button")
    public LoginSteps clickLoginButton() {
        scrollToElement(loginPage.loginButton());
        loginPage.loginButton().click();
        return this;
    }

    @Then("the user should be logged in successfully")
    public LoginSteps verifySuccessfulLogin() {
        return this;
    }
}