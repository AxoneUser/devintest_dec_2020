package uk.axone.testngadvanced.testngbasics;

import org.testng.annotations.*;

/**
 * @author Karthik.Gandhinathan
 */
public class TestNGAnnotations {

    @Test
    public void myFirstTest(){
        System.out.println("Shopping cart Test");
        //System.out.println(addition(10, 12));
    }

    @Test
    public void mysecondTest(){
        System.out.println("Edit Cart Test");
    }

    @Test
    public void thirdTest(){
        System.out.println("Checkout Test");
    }


    @BeforeTest
    public void beforeTest(){
        System.out.println("--@BeforeTest -- make a connection to the database.");
    }


    @AfterTest
    public void afterTest(){
        System.out.println("--@AfterTest -- release connection to the database.");

    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("----@BeforeClass - launch the browser");

    }

    @AfterClass
    public void afterClass(){
        System.out.println("----@AfterClass -  close the browser");

    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("------@BeforeMethod - Login to the application");

    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("------@AfterMethod  - Logout from the application");

    }

    public int addition(int num1, int num2){
        int total = num1 + num2;
        return total;
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("@BeforeSuite -- Make connection to MQ's and Inject test data messages");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("@AfterSuite -- Release connection MQs");
    }






}
