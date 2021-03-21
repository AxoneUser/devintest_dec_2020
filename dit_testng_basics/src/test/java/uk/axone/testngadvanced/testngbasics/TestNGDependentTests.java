package uk.axone.testngadvanced.testngbasics;

import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestNGDependentTests {

    @Test
    public void launchWebSite(){
        System.out.println("Launch the browser and navigate to the application url");
    }

    @Test(dependsOnMethods = {"launchWebSite"})
    public void loginApplication(){
        System.out.println("Log in to the application");
    }

    @Test(dependsOnMethods = {"loginApplication"})
    public void addToCartTest(){
        System.out.println("adding the products to the shopping cart");
        int x = 100;
        System.out.println(x / 0);
        System.out.printf("end of add to Cart Test");
    }

    @Test(dependsOnMethods = {"addToCartTest"})
    public void checkOutTest(){
        System.out.println("Perform a checkout test");
    }


}
