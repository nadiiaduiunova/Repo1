package test.functionalTests;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:\\Repo1\\src\\test\\java\\test\\functionalTests",
        glue = "D:\\Repo1\\src\\test\\java\\test\\StepDefinitions"
)

public class TestRunner {

}
