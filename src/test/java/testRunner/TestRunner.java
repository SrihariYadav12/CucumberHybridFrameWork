package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = ".//FeatureFiles", glue = { "stepDefinitions" }, tags = "@smoke and not @ignore", plugin = {
		"html:target/CucumberReports/CucumberReport.html", "json:target/CucumberReports/CucumberReport.json",
		"junit:target/CucumberReports/CucumberReport.xml" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
