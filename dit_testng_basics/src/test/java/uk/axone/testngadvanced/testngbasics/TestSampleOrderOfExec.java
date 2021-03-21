package uk.axone.testngadvanced.testngbasics;

import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestSampleOrderOfExec {

    @Test
    public void loginTest(){
        System.out.println("loginTest");
    }

    @Test
    public void verifyHomePageTest(){
        System.out.println("HomePage Test");
    }

    @Test
    public void doLogoutTest(){
        System.out.println("Logout Test");
    }

}
