package steps;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.*;

import static base.Base.*;
import io.cucumber.java.en.*;

public class HomeStep{

    @BeforeGroups(groups={"Register", "Login", "Category-Panels", })
    @Test(groups={"Home"})
    @When("the user is on the home page, then the window title should be Demo Web Shop")
    public void getTitle(){
        assertEquals(getDr().getTitle(), "Demo Web Shop");
    }

    
}