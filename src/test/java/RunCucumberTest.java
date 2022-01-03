import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "junit:target/cucumber-junit.xml"},
        features = "src/test/resources/features", tags = "@SetResults")



public class RunCucumberTest {}


