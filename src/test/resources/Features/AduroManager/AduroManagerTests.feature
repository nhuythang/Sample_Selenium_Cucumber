Feature: [AMP] Can create or edit path, practice, or activity

  #Aduro Manager - AM1 login Aduro Manager success
  #Given: a user lands on cms.adurolife.com
  #When: the user enters the correct username and password and clicks the login button
  #Then: the system shall log the user into Aduro Manager and land them on the “Dashboard” page
  Scenario: Login to Aduro Manager
      Given User access to Aduro Manager url
      When User login to Auduro Manager with valid account
      Then User can see Aduro Manager Dashboard page

  #Aduro Manager - AM2 Can create or edit path, practice, or activity
  #Given: a logged-in user on any screen 
  #When: 
  #the user selects “New Path,” “New Practice,” or “New Activity”
  #the user configures all fields in the path/practice/activity
  #the user selects “save path/practice/activity”
  #Then: 
  #the content is saved
  #the content can be retrieved via a search
  Scenario Outline:[AMP] Create new Path/Practice/Activity
      Given User access to Aduro Manager url
      And User login to Auduro Manager with valid account
      And User can see Aduro Manager Dashboard page
      When User select "<Guidance>" in Dashboard page
      And User input all fields in "<Guidance>" page
      And User Save "<Guidance>"
      Then User can seach new "<Guidance>" created
      And User clean up testing data created "<Guidance>"
      Examples:
      | Guidance |
      | Path     |
      | Practice |
      | Activity |