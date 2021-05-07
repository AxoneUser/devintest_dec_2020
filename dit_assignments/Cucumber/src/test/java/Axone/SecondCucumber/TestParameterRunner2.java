package Axone.SecondCucumber;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Question2",//feature file
        glue = { "Axone.SecondCucumber" },//code
        plugin = { "pretty", "html: targetBddOutput" },
        monochrome = true

)

public class TestParameterRunner2 extends AbstractTestNGCucumberTests {

}
