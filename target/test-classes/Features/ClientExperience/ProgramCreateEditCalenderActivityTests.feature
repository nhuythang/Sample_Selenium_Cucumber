@CC4
Feature: Create New Program Create a Program
      Editing / Managing Activity Calendar
      Editing / Managing Required Activities
  
  # AC1/2
  Scenario: Create a new program
    Given User access to CC url
    And User login to CC with valid account
    When User access program library page
    And User click to Add New Program
    Then User can see create program page
    Then User complete the required fields and click Next
    And User can see Edit Program Dates page

  # AC9
  Scenario: The system shall display a popup with a list of activities and phases to add to
    Given User access to CC url
    And User login to CC with valid account
    And HomeScreen displays successfully
    And User access to Activity Calendar url
    And Activity Calendar page displays successfully
    When User click to Add Remove Activities button
    Then Popup Edit Activities is displayed with a list of activities and phases to add to

  # AC10
  Scenario: User is able to add new activity in program
    Given User access to CC url
    And User login to CC with valid account
    And HomeScreen displays successfully
    And User access to Activity Calendar url
    And Activity Calendar page displays successfully
    When User click to Add Remove Activities button
    Then User is able to add new 1 activity in Edit Activities popup