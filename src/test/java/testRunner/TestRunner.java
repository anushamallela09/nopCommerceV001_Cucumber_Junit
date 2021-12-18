package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources"},
        glue = {"stepDefinitions"},
        dryRun = false,
        monochrome = true,
        tags = "@SmokeTest or @regression",
        plugin = {"pretty","html:target/cucumber-reports"}

)
public class TestRunner {

}
