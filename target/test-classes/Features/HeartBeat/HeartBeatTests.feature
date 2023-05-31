Feature: [HeartBeat] Login, Search and connect survey to path and practice, publish/unpublish survey
  Can login, search survey, connect survey to path/practice, publish/unpublish surrvey 

  #HB1 A/C 1: Successful Login
  #Given: a user lands on heartbeat.adurolife.com
  #When: the user enters the correct username and password and clicks the login button
  #Then: the system shall log the user into Heartbeat and land them on the “All Surveys” page
  Scenario: [HB1][AC1]Login to HeartBeat successfull
    Given User access to HeartBeat url
    When User login to Heart Beat with valid account
    Then User can see All Surveys page

  #HB2 A/C 1: Can search for survey
  #Given: a user is successfully logged into Heartbeat and is on the “All Surveys” page
  #When: the user types a keyword in the search bar
  #Then: search results appear dynamically as the search term is entered
  Scenario: [HB2][AC1]Can search for survey
    Given User access to HeartBeat url
    And User login to Heart Beat with valid account
    And User can see All Surveys page
    When User type keyword "automation testing" in the search textbox
    Then User can see search result appear only 1 survey "Automation Testing Survey"

  #HB5 A/C 1: Can connect survey to path and practice
  #Select Aduro Path > Practice > Step
  #Select deployment type
  #Publish a survey
  Scenario: [HB5][AC1]Can connect survey to path and practice
    Given User access to HeartBeat url
    And User login to Heart Beat with valid account
    And User UnPublish "Automation Testing" survey
    And User type keyword "automation testing" in the search textbox
    And User can see search result appear only 1 survey "Automation Testing Survey"
    And User select Publish a survey from search grid
    And User can see title SELECT SURVEY DESTINATION
    When User select ADURO Path -> Practice -> Step
    And User search for "Automation" in path search box
    And User can see and select "Automation Test" path
    And User select practice and step
    And User select Deployment Type Roadmap to Success
    And User click Next button to move to Distribute tab
    And User select Start Date and End Date
    And User select Wave time date
    And User input completion value
    And User click Publish button
    Then User can see survey "Automation Testing Survey" change to pending in All Survey Page

  #HB6 A/C 1: Can publish and unpublish survey
  #Given: a member selects to “publish” a survey by clicking on the three dots on the survey item from the search grid
  #When: the member selects a “Deploy to” and “Deploy type” configuration
  #Then: the survey is published to the selected configuration
  Scenario: [HB5][AC1]Can connect survey to path and practice
    Given User access to HeartBeat url
    And User login to Heart Beat with valid account
    And User UnPublish "Automation Testing" survey
    And User type keyword "automation testing" in the search textbox
    And User can see search result appear only 1 survey "Automation Testing Survey"
    And User select Publish a survey from search grid
    And User can see title SELECT SURVEY DESTINATION
    When User select ADURO Path -> Practice -> Step
    And User search for "Automation" in path search box
    And User can see and select "Automation Test" path
    And User select practice and step
    And User select Deployment Type Roadmap to Success
    And User click Next button to move to Distribute tab
    And User select Start Date and End Date
    And User select Wave time date
    And User input completion value
    And User click Publish button
    Then User can see survey "Automation Testing Survey" change to pending in All Survey Page
    And User wait until survey "Automation Testing Survey" publish successfully
    And User access to Connect url have live event in new tab
    And User login to Connect with account has Heart Beat survey in path
    And User search for "Automation Test" path in Discover page
    And User access path "Automation Test" and see "Automation test practice" practice
    And User can open "Automation test practice" to see "Automation Testing Survey" survey
    And User switch to first tab
    And User UnPublish "Automation Testing" survey
