package uk.axone.cucumberbasics.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Karthik.Gandhinathan
 */
public class LoginStep {

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        System.out.println("User is on the landing page");
        //driver.get("");
    }

    @When("user navigates to signin page")
    public void user_navigates_to_signin_page()
    {
        //driver.findElement(By.id("sigin")).click();
        System.out.println("user navigates to signin page");
    }

    @And("user enters username and password credentials")
    public void user_enters_username_and_password_credentials() {
        //driver.findElement(By.id("username")).sendKeys("karthik");
        //driver.findElement(By.id("password")).sendKeys("password");
        //driver.findElement(By.id("button")).click();
        System.out.println("user enters username and password credentials");
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        System.out.println("user is successfully logged in");
        //validations.
    }

}
