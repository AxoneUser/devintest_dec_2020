package Axone.ThirdCucumber;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Question3",//feature file
        glue = { "Axone.ThirdCucumber" },//code
        plugin = { "pretty", "html: targetBddOutput" },
        monochrome = true

)

public class TestParameterRunner3 extends AbstractTestNGCucumberTests {

}
