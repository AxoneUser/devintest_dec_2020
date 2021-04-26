package uk.axone.advancedbdd.testng;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Karthik.Gandhinathan
 */
public class TestNGStepDefn {
    @Given("user is on the Landing page")
    public void userIsOnTheLandingPage() {
        System.out.println("user is on the Landing page");
    }

    @When("user navigates to Signin page")
    public void userNavigatesToSigninPage() {
        System.out.println("user navigates to Signin page");
    }

    @And("user enters username and password credentials")
    public void userEntersUsernameAndPasswordCredentials() {
        System.out.println("user enters username and password credentials");
    }

    @Then("user is successfully logged in")
    public void userIsSuccessfullyLoggedIn() {
        System.out.println("user is successfully logged in");
    }


}
