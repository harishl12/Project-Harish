@Sanity
Feature: Login with Back ground

  Background: 
    Given Navigate to Facebook.com
    And validate Homepage

  Scenario: valid Login test
    When user entered valid "username"
    And user entered valid "password"
    Then Login is successful

  Scenario: invalid Login test
    When user entered invalid "username"
    And user entered invalid "password"
    Then Login is failed
