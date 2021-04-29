#Author: your.email@your.domain.com

@tag
Feature: Life of an IT Tester

  Scenario Outline: Parameterizing the scenario to form a single scenario
    Given I am a "<tester>"
    When I "<task completion>" my tasks
    And "<bugtype>" important bugs
    Then My Manager "<appreciation>" me
    But Developer "<developer>" me


    Examples:
      | tester      | task completion | bugtype  | appreciation | developer |
      | Good Tester | Complete        | find     | rewards      | hates     |
      | Bad Tester  | Incomplete      | not find | warns        | likes     |
