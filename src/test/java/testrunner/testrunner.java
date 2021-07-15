package testrunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/DataDriven.feature"
        ,glue= {"org.example.stepdef", "org.example.hooksetup"}
        ,dryRun = false
        ,monochrome = true
)

public class testrunner {
}