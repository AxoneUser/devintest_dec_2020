package uk.axone.cucumberbasics.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Karthik.Gandhinathan
 */

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = {"uk/axone/cucumberbasics/stepdefinition"},
    plugin = {"html: axoneTestResult"},
    publish = true
)
public class Runner {
}
