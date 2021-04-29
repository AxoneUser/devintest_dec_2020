$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Question3/Question3.feature");
formatter.feature({
  "name": "Title of your feature",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Title of your scenario",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "User can Launch Browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Test3StepDefinition.user_can_Launch_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to the following website",
  "keyword": "And "
});
formatter.match({
  "location": "Test3StepDefinition.navigate_to_the_following_website()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I Click Sign-in link",
  "keyword": "When "
});
formatter.match({
  "location": "Test3StepDefinition.i_Click_Sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter UserName \"karthik@axone-tech.uk\" and Password \"password\"",
  "keyword": "And "
});
formatter.match({
  "location": "Test3StepDefinition.enter_UserName_and_Password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify that you have logged in successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "Test3StepDefinition.verify_that_you_have_logged_in_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Logout",
  "keyword": "And "
});
formatter.match({
  "location": "Test3StepDefinition.click_on_Logout()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify that you have logged out of the application",
  "keyword": "Then "
});
formatter.match({
  "location": "Test3StepDefinition.verify_that_you_have_logged_out_of_the_application()"
});
formatter.result({
  "status": "passed"
});
});