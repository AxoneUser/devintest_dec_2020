#Author: Karthik Gandhinathan
Feature: Login feature
  In order to use the Axone enterprise portal, I want the login application so that I could use my training artefacts.

  @RegressionTest
  Scenario: Successful login with valid credentials
    Given user is on the Home page
    When user navigates to login page
    And user enters "axoneUser123" and "password@123" credentials
    Then user logged in message displayed