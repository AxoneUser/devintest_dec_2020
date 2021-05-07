package Axone.Cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestStepDefinition {

    @Given("I am a {string}")
    public void i_am_a(String tester) {
        System.out.println("I am a " + tester);
    }

    @When("I {string} my tasks")
    public void i_my_tasks(String completionState) {
        System.out.println("I " + completionState + " my tasks");
    }

    @When("{string} important bugs")
    public void important_bugs(String action) {
        System.out.println(action + " important bugs");
    }

    @Then("My Manager {string} me")
    public void my_Manager_me(String behavior) {
        System.out.println("My Manager " + behavior + " me");
    }

    @Then("Developer {string} me")
    public void developer_me(String behavior) {
        System.out.println("Developer " + behavior + " me");
    }


}



