Feature: Login 
  User can login with and without MFA
  #MEM2 AC5
  Scenario: Member logs in successfully
    Given User access to Connect url
    When User login to Connect web with valid account
    Then User can see program in Home page

  #MEM2 AC12
  Scenario: Member logs in, configures non-required MFA
    Given A member has not login to Connect
    And User access to Connect url
    When User login to Connect for first time
    Then User can see MFA setup page
    And User can click Not Now to skip MFA
    And User can see program in Home page