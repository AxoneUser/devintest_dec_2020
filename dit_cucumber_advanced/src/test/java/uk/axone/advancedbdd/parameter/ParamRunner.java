package uk.axone.advancedbdd.parameter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author Karthik.Gandhinathan
 */
@CucumberOptions(
    features = "src/test/resources/parameter",
    plugin = {
        "html:target/htmlExecReport",
        "pretty", "summary",
    },
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    dryRun = false,
    strict = true,
    monochrome = false
    //tags = {"@E2ETest or @SmokeTest"}
)
public class ParamRunner extends AbstractTestNGCucumberTests {
}
