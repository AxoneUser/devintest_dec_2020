package Axone.Cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Question1",//feature file
        glue = { "Axone.Cucumber" },//code
        plugin = { "pretty", "html: targetBddOutput" },
        monochrome = true

)

public class TestParameterRunner {

}
