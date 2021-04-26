package uk.axone.advancedbdd.parameter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Karthik.Gandhinathan
 */
public class ParamStepDefn {

    @Given("user is on the Home page")
    public void userIsOnTheHomePage() {
        System.out.println("user is on the Home page");
    }

    @When("user navigates to login page")
    public void userNavigatesToLoginPage() {
        System.out.println("user navigates to login page");
    }

    @And("user enters {string} and {string} credentials")
    public void userEntersAndCredentials(String uName, String pass) {
        System.out.println("user enters: "+uName+" and password is: "+pass);
    }

    @Then("user logged in message displayed")
    public void userLoggedInMessageDisplayed() {
        System.out.println("user logged in message displayed");
    }

    @After
    public void tearDown(){
        System.out.println("I am inside tearDown method");
    }

    @Before(order = 0)
    public void beforeClass(){
        System.out.println("Make Queue connection");
    }


    @Before(order = 2)
    public void beforeTest(){
        System.out.println("Launch a browser");
    }


    @Before(order = 1)
    public void beforeScenario(){
        System.out.println("Make a Database connection");
    }



}
