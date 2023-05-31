
Feature: Connect - Wellmetrics page - Scheduler Page
  A member should be able to access to see Wellmetrics and visit scheduler page via Wellmetrics page 

#MEM10: Can open Wellmetrics page and view biometric results
#A/C 2: Wellmetrics data is displayed and correct
#Given: The member is in a program with wellmetrics available and all biometrics available. 
#     The member has wellmetrics data available to view.
#When: They log in on web and navigate to the wellmetrics page from the top navigation.
#Then: There are tiles for blood pressure, cholesterol, hdl, triglycerides, ldl, tc:hdl, 
#      ldl:hdl, blood glucose, waist, height, weight, and bmi. Check that the values in the biometric card match the expected values.
  Scenario: Wellmetrics page and results
     Given User access to Connect url
     When User login to Connect web with valid account
     And User access Wellmetrics page from top navigation
     Then User can see 'Wellmetrics' page display successfully
     And User can see value of Blood Pressure match expected '60/60'
     And User can see value of Total Cholesterol match expected '200'
     And User can see value of HDL match expected '50'
     And User can see value of Triglycerides match expected '145'
     And User can see value of LDL match expected '109'
     And User can see value of TC:HDL match expected '4'
     And User can see value of LDL:HDL match expected '2.2'
     And User can see value of Blood Glucose match expected '100'
     And User can see value of Waist match expected '30'
     And User can see value of Height match expected '97'
     And User can see value of Weight match expected '143'
     And User can see value of BMI match expected '10.7'

#MEM14
#A/C Connect - Scheduler - Visit Scheduler
#G: a member lands on connect main menu
#W: a member has an screening tile AND this client has available events (has at least 1 event turned on in CW2.0)
#T: a member should be able to click on screening acitivity > “Schedule New Screening” > to visit scheduler page

  Scenario: To visit scheduler page
    Given User access to Connect url
    And User login to Connect with account having screening event
    And User access Wellmetrics page from top navigation
    And User can see 'Wellmetrics' page display successfully
    When User click to Schedule a screening button
    Then User can see Schedule Services page

#MEM15
#A/C Connect - Scheduler - Book On Site Event
#G: a member lands on scheduler page
#W: there is avaialble events (event is turned on in CW2.0)
#T: a member should be able to pick the location > select date > select slot> check consent box > confirm > 
#  see confirmation “Thank you” page  to complete the booking process
  Scenario: Book On Site Event
    Given User access to Connect url
    And User login to Connect with account having screening event
    And User access Wellmetrics page from top navigation
    And User click to Schedule a screening button
    And User can see Schedule Services page
    When User book an available event
    Then User can see confirmation Thank you to complete booking process