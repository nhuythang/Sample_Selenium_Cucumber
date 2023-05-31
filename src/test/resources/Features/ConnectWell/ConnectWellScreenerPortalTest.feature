Feature: [Connect Well][Screener Portal] Check in & record members bio data
  Check in & record members bio data
     
  #CW2 AC1 Screener portal - Check in members
  #A/C Screener portal - Check in members
  #G: a screener lands on screener portal > event list > event page
  #W: screener clicks on "check in" card 
  #T: screener shall be able to check a member in 
  Scenario: [Connect Well][EMS]Screener portal - Check in members
     Given User access to EMS url
     And User login to Connect Well web with valid account
     And User can see Connect Well Dashboard page
     And User access to Screener Portal url in new tab
     And User clean up pending checkin event
     And User select first client in dashboard
     And User goes to plan tab to create an event
     And User clean up approved event
     And User delete all current Draft event
     And User click to create new event
     And event is submitted with all required fields filled
     And event is created succesfully in approved status
     And User turn on Live event in Connect Well
     And User access to Connect url have live event in new tab
     And User login to Connect with account live event
     And User access Wellmetrics page from top navigation
     And User click to Schedule a screening button
     When User book an available event
     Then User can see confirmation Thank you to complete booking process
     And User access to Screener Portal url in new tab
     And User search for created event in screener portal
     And User check event name and access event detail
     And User open Check In page
     And User check in member
     And User can see member check in successfull
     And User switch to first tab
     And User clean up approved event
     And User delete all current Draft event
   #CW4 AC1 & AC2
   #AC1 Screener portal - record bio data
   #G: a screener lands on screener portal > event list > event page
   #W: screener clicks on "screening" tile
   #T: screener shall be able to click on the "screen" botton to enter bio order collecting page
   #AC2 Screener portal - record bio data
   #G: a screener lands on bio order collecting page
   #W: screener enters all required fields
   #T: screener shall be able to submit the order
   Scenario: [Connect Well][EMS]Screener portal - Record Bio Data
     Given User access to EMS url
     And User login to Connect Well web with valid account
     And User can see Connect Well Dashboard page
     And User access to Screener Portal url in new tab
     And User clean up pending checkin event
     And User select first client in dashboard
     And User goes to plan tab to create an event
     And User clean up approved event
     And User delete all current Draft event
     And User click to create new event
     And event is submitted with all required fields filled
     And event is created succesfully in approved status
     And User turn on Live event in Connect Well
     And User access to Connect url have live event in new tab
     And User login to Connect with account live event
     And User access Wellmetrics page from top navigation
     And User click to Schedule a screening button
     When User book an available event
     And User can see confirmation Thank you to complete booking process
     And User access to Screener Portal url in new tab
     And User search for created event in screener portal
     And User check event name and access event detail
     And User open Check In page
     And User check in member
     And User can see member check in successfull
     And User back to event detail
     Then User click Screening button to see Screening page
     And User click Screen button in Screening page
     And User can see bio order collecting page
     And User enters all required fields in order collecting page
     And User shall be able to submit the order
     And User switch to first tab
     And User clean up approved event
     And User delete all current Draft event