#Author: Karthik Gandhinathan
Feature: Login feature
  In order to use the Axone enterprise portal, I want the login application so that I could use my training artefacts.
  Scenario: Successful login with valid credentials
    Given user is on the Landing page
    When user navigates to Signin page
    And user enters username and password credentials
    Then user is successfully logged in