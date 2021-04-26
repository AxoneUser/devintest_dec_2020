package uk.axone.advancedbdd.outline;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author Karthik.Gandhinathan
 */

@CucumberOptions(
    features = "src/test/resources/examples",
    plugin = {
        "html:target/htmlExecReport",
        "pretty", "summary",
    },
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    dryRun = false,
    strict = true,
    monochrome = false

)
public class OutlineRunner extends AbstractTestNGCucumberTests {
}
