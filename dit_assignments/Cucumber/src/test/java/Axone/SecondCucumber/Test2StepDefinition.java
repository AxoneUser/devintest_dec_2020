package Axone.SecondCucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test2StepDefinition {
    @Given("I am on axone-tech.co.uk registration page")
    public void i_am_on_axone_tech_co_uk_registration_page() {
        System.out.println("I am on axone-tech.co.uk registration page");
    }

    @When("I enter username \"(.*)\"")
    public void i_enter_username(String string) {
        System.out.println("I enter username" + "  " + string);
    }

    @When("I enter password \"(.*)\"")
    public void i_enter_password(String string) {
        System.out.println("I enter password" + "  " + string);
    }

    @When("I enter mobile-number \"([0-9]*)\"")
    public void i_enter_mobile_number(String string) {
        System.out.println("I enter mobile-number" + "  " + string);
    }

    @Then("registration should be \"(.*)\"")
    public void registration_should_be(String string) {
        System.out.println("Registration should be" + "  " + string);
    }


}
