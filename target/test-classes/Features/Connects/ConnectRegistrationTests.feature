Feature: [Connect Web] Activate/register new member account
  Activate/register new account Connect web
  # MEM1 AC3
  Scenario: New member attempts login before registration
    Given User access to Connect url
    When User enter email address of not register member then click 'Log in with Aduro'
    Then User is moved to the first registration page

  # MEM1 AC5
  Scenario: Navigating to the registration page
    Given User access to Connect Client has Signup url
    When User click to SignUp link
    Then User is moved to the first registration page

  # MEM1 AC1 & AC30
  #A/C 1: New, unverified member attempts login
  #Given: A new member enters their email on the login page and clicks Log In with Aduro
  #When: User is found in our system, has started registration, but not verified their account
  #Then: The user is moved to the enter pw page, then to the Verify screen where a new verification email is sent.
  #A/C 30: Member verifies account
  #Given: A new member has started registration, but not verified their account. The verification link in the email we sent them has not expired.
  #When: They click the verification link in the email.
  #Then: The user is moved to the login screen. And a green success message appears on the page. And the account is verified.
  Scenario: AC1 & AC30 | Unverified Member try to login and verifies account
    Given A new member is created in system
    And New member enter their email on login page and click Log In with Aduro
    And User is moved to the first registration page
    And User start Registration flow and submit
    And User can see and enter password then submit
    And User receive verification email
    When User click to verification link in email
    Then User is moved to login screen with a green success message appears on the page