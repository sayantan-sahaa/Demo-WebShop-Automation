package steps;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import static pages.HomePage.*;
import hooks.Hooks;
import io.cucumber.java.en.*;

public class HomeStep extends Hooks {

    @BeforeGroups(groups={"Register", "Login", "Category-Panels", })
    @Test(groups = {"homepage"})
    @When("When the user is on the home page, then the window title should be Demo Web Shop")
    public void getTitle(){
        assertEquals(getDr().getTitle(), "Demo Web Shop");
        loginURL.click();
    }

    /*@BeforeGroups(groups={"Login"})
    @Test(groups = {"homepage"})
    @Then("the user is able to click on login url")
    public void clickLoginURL(){
        loginURL.click();
    }*/
}