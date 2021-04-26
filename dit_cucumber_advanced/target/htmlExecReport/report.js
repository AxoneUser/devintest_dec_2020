$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/parameter/parameter.feature");
formatter.feature({
  "name": "Login feature",
  "description": "  In order to use the Axone enterprise portal, I want the login application so that I could use my training artefacts.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Successful login with valid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegressionTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Home page",
  "keyword": "Given "
});
formatter.match({
  "location": "uk.axone.advancedbdd.parameter.ParamStepDefn.userIsOnTheHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to login page",
  "keyword": "When "
});
formatter.match({
  "location": "uk.axone.advancedbdd.parameter.ParamStepDefn.userNavigatesToLoginPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters \"axoneUser123\" and \"password@123\" credentials",
  "keyword": "And "
});
formatter.match({
  "location": "uk.axone.advancedbdd.parameter.ParamStepDefn.userEntersAndCredentials(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user logged in message displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "uk.axone.advancedbdd.parameter.ParamStepDefn.userLoggedInMessageDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});