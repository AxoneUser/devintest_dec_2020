package uk.axone.testngbasics;

import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestNGPriorities {



    @Test(priority = 2)
    public void logoutTest(){
        System.out.println("logout Test");
    }

    @Test(priority = 1)
    public void verifyHomePageTest(){
        System.out.println("verify home page Test");
    }


    @Test(priority = 0)
    public void loginTest(){
        System.out.println("login Test");
    }





}
