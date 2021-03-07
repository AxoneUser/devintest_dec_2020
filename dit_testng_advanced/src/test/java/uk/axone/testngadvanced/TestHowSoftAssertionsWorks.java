package uk.axone.testngadvanced;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowSoftAssertionsWorks {

    @Test
    public void testSoftAssertion(){

        System.out.println("My first line of code");
        SoftAssert softAssert = new SoftAssert();

        int expectedVal = 123;
        int actualValue = 456;

        softAssert.assertEquals(actualValue, expectedVal, "Integers are unequal"); //error
        softAssert.assertTrue(2 > 1, "condition evaluated to false"); //no error
        softAssert.assertTrue(false, "condition evaluated to false"); //error
        softAssert.assertFalse(true, "condition evaluated to true");//error


        System.out.println("My last line of code");

        softAssert.assertAll();


    }
}
