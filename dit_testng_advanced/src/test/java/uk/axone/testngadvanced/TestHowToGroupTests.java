package uk.axone.testngadvanced;

import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowToGroupTests {

    @Test(groups = {"smokeTest", "cart"})
    public void shoppingCartTest1(){
        System.out.println("Smoke Test");
    }

    @Test(groups = {"cart"})
    public void shoppingCartTest2(){
        System.out.println("Cart Test - 2");
    }

    @Test(groups = {"cart"})
    public void shoppingCartTest3(){
        System.out.println("Cart Test - 3");
    }

    @Test(groups = {"payment", "e2e", "IntegrationTest"})
    public void paymentGatewayTest1(){
        System.out.println("Integeration Test");
    }

    @Test(groups = {"payment"}, dependsOnMethods = {"paymentGatewayTest1"})
    public void paymentGatewayTest2(){
        System.out.println("payment Test - 2");
    }

    @Test(groups = {"payment"})
    public void paymentGatewayTest3(){
        System.out.println("payment Test - 3");
    }

}
