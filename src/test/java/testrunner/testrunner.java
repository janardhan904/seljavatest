package testrunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/DataDriven.feature"
        ,glue= {"org.example.stepdef", "org.example.hooksetup"}
        ,dryRun = false
        ,monochrome = true  // If the monochrome option is set to false, then the console output is not as readable as it should be
        ,plugin = { "json:target/cucumber.json", "pretty",
        "junit:target/Cucumber.xml",
        "html:target/cucumber-reports" }  //Pretty - This provides more verbose output
)

public class testrunner {
}