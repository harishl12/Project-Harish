@Smoke
Feature: Login
  
  In this feature we login to website facebook.com with valid username amd password

@Before


  Scenario Outline: validLogin
    Given Navigate to facebook.com
    And input valid username as "<userName>" and password as "<password>" in textbox
    And user select the age category
      | Age      | Location |
      | below 18 | India    |
      | above 18 | USA      |
    And validate title of webpage
    When Click on login
    Then login "<loginType>" be successful
    And check the Titlepage with username as "Harry"

    Examples: 
      | userName | password | loginType  |
      | valid    | valid    | Should     |
      | invalid  | invalid  | Should not |

  Scenario Outline: inValidLogin
    Given Navigate to facebook.com
    And input valid username as "<userName>" and password as "<password>" in textbox
    And user select the age category
      | Age      | Location |
      | below 18 | India    |
      | above 18 | USA      |
    And validate title of webpage
    When Click on login
    Then login "<loginType>" be successful
    And check the Titlepage with username as "Harry"

    Examples: 
      | userName | password | loginType  |
      | valid    | valid    | Should     |
      | invalid  | invalid  | Should not |
