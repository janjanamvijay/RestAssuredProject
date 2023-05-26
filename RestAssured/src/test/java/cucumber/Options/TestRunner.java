package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features="src/test/java/features",plugin = "html:target/jsonReports/Test-Results-Report.html",
        glue = {"stepDefinitions"}
)
public class TestRunner {
}
