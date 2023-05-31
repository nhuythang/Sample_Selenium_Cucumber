
Feature: [Connect Well]Event Creation event type, event details
  Create event with event type, event details
     
  #CW1 AC1
  #A/C Event Creation - Submission
  #Given a user goes to plan tab to create an event
  #When event is submitted with all required fields filled
  #Then event is created succesfully in approved status
  #Scenario: [Connect Well][EMS]Event Creation - Submission
     #Given User access to EMS url
     #And User login to Connect Well web with valid account
     #And User can see Connect Well Dashboard page
     #And User select first client in dashboard
     #And User goes to plan tab to create an event
     #And User clean up approved event
     #When User click to create new event
     #And event is submitted with all required fields filled
     #Then event is created succesfully in approved status
     #And User clean up approved event
     #And User delete all current Draft event
     
  #A/C10 Event Detail Page > Live Toggle
  #G: event detail page > live toggle is turned on
  #T: this event should appear in Connect Scheduler
  Scenario: [Connect Well][EMS]Event Detail Page > Live Toggle
     Given User access to EMS url
     And User login to Connect Well web with valid account
     And User can see Connect Well Dashboard page
     And User select first client in dashboard
     And User goes to plan tab to create an event
     And User clean up approved event
     And User click to create new event
     And event is submitted with all required fields filled
     And event is created succesfully in approved status
     When User access to Connect url have live event in new tab
     And User login to Connect with account live event
     And User access Wellmetrics page from top navigation
     Then User can not see Schedule a screening button
     When User switch to first tab
     And User turn on Live event in Connect Well
     And User switch to latest open tab
     And User refresh Wellmetrics page
     Then User check event Scheduler available
     And User switch to first tab
     And User clean up approved event
     And User delete all current Draft event
     
  #CW1 AC12 & AC13
  #A/C12 Client Details > Add ons
  #G: a user lands on client details > add on section 
  #W: user turns the Vaccines (Flu Shots/Covid-19 Vaccines) toggle on
  #T: user could see 3 vaccine toggles listed on event details page (flu shots/ covide vaccine/ covid & flu shots)
  #A/C13 Event Detail Page >  Vaccine Add ons
  #G: a user lands on event detail page
  #W: user turns any of the flu related toggles on (flu shots/ covide vaccine/ covid & flu shots)
  #T: system should only allow user to turn one of the 3 toggles on
  #Scenario: [Connect Well][EMS] Client Details > Add ons
     #Given User access to EMS url
     #And User login to Connect Well web with valid account
     #And User can see Connect Well Dashboard page
     #And User select first client in dashboard
     #And User goes to plan tab to create an event
     #And User check Vaccine Add on toggle on
     #And User clean up approved event
     #When User click to create new event
     #And event is submitted with all required fields filled
     #And event is created succesfully in approved status
     #And User open event detail page
     #Then User could see 3 vaccine toggles "Flu Shots", "Covid Vaccine" and "Covid & Flu Shots" listed on event details page
     #And User turns Flu Shots toggles on
     #And User can see only Flu Shots toggle turned on
     #And User turns Covid Vaccine toggles on
     #And User can see only Covid Vaccine toggle turned on
     #And User turns Covid & Flu Shots toggles on
     #And User can see only Covid & Flu Shots toggle turned on
     #And User clean up approved event
     #And User delete all current Draft event

  #A/C14 Event Detail Page > Vaccine Add ons
  #G: a user lands on event detail page
  #W: user turns any of the flu related toggles on (flu shots/ covide vaccine/ covid & flu shots)
  #T: scheduler page (in Connect) should refect what’s configured
  #Scenario Outline: [Connect Well][EMS] Event Detail Page > Vaccine Add ons
     #Given User access to EMS url
     #And User login to Connect Well web with valid account
     #And User can see Connect Well Dashboard page
     #And User select first client in dashboard
     #And User goes to plan tab to create an event
     #And User clean up approved event
     #And User click to create new event
     #And event is submitted with all required fields filled
     #And event is created succesfully in approved status
     #And User open event detail page
     #And User turn on Live and "<AddOns>" toggles
     #When User access to Connect url have live event in new tab
     #And User login to Connect with account live event
     #And User access Wellmetrics page from top navigation
     #Then User check event Scheduler available
     #And User can see "<AddOns>" option while booking event
     #And User switch to first tab
     #And User clean up approved event
     #And User delete all current Draft event
     #Examples:
      #| AddOns         |
      #| Flu Shots      |
      #| Covid Vaccine  |
      #| Covid Flu Shots|