Feature: Members forgot password
  Can use forgot password to set new password
  # MEM3 AC1
  Scenario: Forgot password normal code entry
    Given User access to Connect forgot password url
    When User enter email address then click 'Log in with Aduro'
    Then User can see enter password page and "I forgot my password" link displayed
    And User click the link to see reset password page
    And User enter email then click 'Send Code'
    And User can see enter code page
    And User enter their code into input code field and click 'Continue'
    And User can see create "New Password" page