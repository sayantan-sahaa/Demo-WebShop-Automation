package steps;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import base.Hooks;
import io.cucumber.java.en.When;

public class LoginStep extends Hooks {

    @Test(groups = {"authentication"})
    @When("the user is on the login page, then the window title should be Demo Web Shop")
    public void getTitle(){
        assertEquals(getDr().getTitle(), "Demo Web Shop");
    }
}