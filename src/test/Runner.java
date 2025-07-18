import io.cucumber.testng.CucumberOptions;
import pages.HomePage;
import pages.LoginPage;
import reporting.ExtentReportUtil;
import utils.Asserts;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Set;
import static base.Base.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.reflections.Reflections;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import base.ScreenShotUtil;

@CucumberOptions(
    features = "src/test/features",
    glue = {"steps", "hooks"},
    plugin = {
        "pretty",
    },
    monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {
    
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    
}