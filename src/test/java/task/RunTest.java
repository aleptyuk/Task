package task;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/scenarios/",
        glue = {"steps"},
        plugin = {"pretty"})
public class RunTest extends AbstractTestNGCucumberTests {
}
