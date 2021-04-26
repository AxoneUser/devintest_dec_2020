package uk.axone.advancedbdd.testng;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author Karthik.Gandhinathan
 */

@CucumberOptions(
    features = "src/test/resources/testng",
    plugin = {
        "html:target/htmlExecReport",
        "pretty", "summary",
    },
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    dryRun = false,
    strict = true,
    monochrome = false

)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
