package steps;

import static pages.HomePage.*;
import org.testng.annotations.*;
import io.cucumber.java.en.*;

public class LoginSteps {
    
    @Test(groups = {"Login"})
    @Given("the user is on the Demo Web Shop login page")
    public void clickLoginURL(){
        loginURL.click();
    }
}