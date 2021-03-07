package uk.axone.testngadvanced;

import org.testng.SkipException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 *
 * ways to skip a test:
 * 1. Using @Ignore annotation. This can be used at package, class and at the test method levels
 * 2. Using enabled=false
 * 3. Using skipException
 *
 * @author Karthik.Gandhinathan
 */

public class TestHowToSkipATest {

    @Test
    public void doLoginTest(){
        System.out.println("Login Test");
    }

    @Test
    public void logoutTest(){
        System.out.println("Logout Test");
    }


    //@Ignore
    //@Test(enabled = false)
    @Test
    public void verifyHomePageTest(){
        System.out.println("HomePage Test");
        //if (!dataAvailable) --> perform a conditional check and evaluate the data is present or not.
            throw new SkipException("Data still unavailable...Please try later.");
        //System.out.println("End of HomePage test");

    }


    @Test
    public void verifyLandingPageTest(){
        System.out.println("LandingPage Test");
    }



}
