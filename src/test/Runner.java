import org.testng.annotations.*;

import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"steps"},
    plugin = {"pretty", "html:target/cucumber-reports"}
)
public class Runner extends AbstractTestNGCucumberTests{

    
    
}