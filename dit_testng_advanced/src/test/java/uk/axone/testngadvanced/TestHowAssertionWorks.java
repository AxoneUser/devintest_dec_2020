package uk.axone.testngadvanced;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowAssertionWorks {


    //assertEquals
    //assertTrue
    //assertFalse

    @Test
    public void testAssertEquals(){
        System.out.println("First line of code");
        String expectedVal = "uk.axone";
        String actualVal = "axone";


        Assert.assertEquals(actualVal, expectedVal, "Equality assertion - unequal objects");
        System.out.println("Last line of code");

    }

    @Test
    public void testAssertionTrue(){
        Assert.assertTrue(2 > 5, "condition evaluated to false");
    }

    @Test
    public void testAssertionFalse(){
        Assert.assertFalse(2 < 5, "condition evaluated to true");
    }


}
