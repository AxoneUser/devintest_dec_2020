Feature: Login scenario with examples.

  @SmokeTest
  Scenario Outline: Successful login
    Given user is on the Landingpage
    When user navigates to Signinpage
    And user enters <username> and <password>
    Then user login successful <message>
    Examples:
      | username  | password  | message         |
      | username1 | password1 | Welcome admin   |
      | username2 | password2 | Welcome student |
      | username3 | password3 | Welcome coach   |

    @E2ETest
    Scenario: Sample Scenario
      Given user is on the Landingpage
      When user navigates to Signinpage
      And user enters <username> and <password>
      Then user login successful <message>
