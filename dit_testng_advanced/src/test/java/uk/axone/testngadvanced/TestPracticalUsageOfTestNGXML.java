package uk.axone.testngadvanced;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestPracticalUsageOfTestNGXML {


    @Parameters({"browser"})
    @Test
    public void testCrossBrowser(String browserType){
        System.out.println("My test is executing in the " + browserType + " browser");
    }

}
