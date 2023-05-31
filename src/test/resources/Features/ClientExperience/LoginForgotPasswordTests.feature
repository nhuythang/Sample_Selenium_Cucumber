Feature: Login CC
  I want to use this template for my feature file

  Scenario: Login to CC successfully
    Given User access to CC url
    When User login to CC with valid account
    Then HomeScreen displays successfully

  Scenario Outline: Login to CC with multiple valid accounts
    Given User access to CC url
    When User login to CC with '<user>' and '<password>'
    Then HomeScreen displays successfully
    

    Examples: 
      | user                 				| password  |
      | thang.nguyen@adurolife.com  | Abcd@1234 |
      | thang.nguyen@adurolife.com  | Abcd@1234 |
      #| thang.nguyen@adurolife.com  | Abcd@12345 |

  Scenario: Access forgot password page
    Given User access to CC url
    When User click to Forgot Password button
    Then Forgot Password page displays successfully with text "Enter your email address to reset your password."