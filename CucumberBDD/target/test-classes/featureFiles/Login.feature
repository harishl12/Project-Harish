Feature: Login
  
  In this feature we login to website facebook.com with valid username amd password

  Scenario Outline: validLogin
    Given Navigate to facebook.com
    And input valid username as "<userName>" and password as "<password>" in textbox
    And validate title of webpage
    When Click on login
    Then login "<loginType>" be successful
    And check the Titlepage with username as "Harry"

    Examples: 
      | userName | password | loginType  |
      | valid    | valid    | Should     |
      | invalid  | invalid  | Should not |
