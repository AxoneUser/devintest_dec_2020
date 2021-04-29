#Author: your.email@your.domain.com
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Register user on Gmail.com
    Given I am on axone-tech.co.uk registration page
    When I enter username "<UserName>"
    When I enter password "<Password>"
    When I enter mobile-number "<Mobile Number>"
    Then registration should be "Successful"

    Examples:
      | UserName | Password  | Mobile Number |
      | User1    | Password1 | 07986876345   |
      | User2    | Password2 | 07934876345   |
