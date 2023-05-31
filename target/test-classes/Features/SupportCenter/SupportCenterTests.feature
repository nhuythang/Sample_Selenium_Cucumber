Feature: [Support Center] Search for Member/Program, view member Program detail, update path/activity

  #A/C Support Center - Member Tab Search Function - valid info
  #G: an internal user who lands on member tab
  #W: the user puts a member’s valid first name OR last name OR Email OR Mobile Number
  #T: member record should display after user hits enter key
  Scenario: [SC2] Member Tab Search Function - valid info
    Given User access to Support Center url
    And User login to Support Center with valid account
    And User can see Support Center Dashboard page
    When User open Member tab in Support Center
    And User input member valid email to search in Member page
    Then User can see member record display email

  #A/C Support Center - Member Tab - View Record Details
  #G: an record is returned when an internal user looks it up
  #W:  internal user should have the ability to click on “view”
  #T: direct user to the member/program information page
  Scenario: [SC3] Member Tab - View Record Details
    Given User access to Support Center url
    And User login to Support Center with valid account
    And User can see Support Center Dashboard page
    When User open Member tab in Support Center
    And User input member valid email to search in Member page
    And User click on View link in display record
    Then User can see member information page

  #A/C Support Center - Results Mgmt Tab Search Function - valid info
  #G: an internal user who lands on member tab
  #W: the user puts a member’s valid first name OR last name OR Email
  #T: member record should display after user hits enter key
  Scenario: [SC4] Results Management Tab Search Function - valid info
    Given User access to Support Center url
    And User login to Support Center with valid account
    And User can see Support Center Dashboard page
    When User open Result Management tab in Support Center
    And User input member valid email to search in Results Management page
    Then User can see Result records display in Results Management page

  #A/C Support Center - Results Mgmt Tab - View Record Details
  #G: an record is returned when an internal user looks it up
  #W:  internal user should have the ability to click on first name OR last name of the returned record
  #T: direct user to the results mgmt detail page
  Scenario Outline: [SC5] Results Management Tab - View Record Details
    Given User access to Support Center url
    And User login to Support Center with valid account
    And User can see Support Center Dashboard page
    When User open Result Management tab in Support Center
    And User input member valid email to search in Results Management page
    And User click on "<Link>" link to display Result record
    Then User can see Results Management detail page
    Examples:
    | Link      |
    | FirstName |
    | LastName  |

  #A/C Support Center - Member Tab - View Member Path/Activity Details
  #G: an internal user lands on member / porgram information detail page
  #W: user clicks on program information tab
  #T:  user should be able to see all program content details including
  # ID | Title | Category | Type | Required for | Dates available | Status | Potential points | Add points
  Scenario: [SC6-AC1] Member Tab - View Member Path/Activity Details
    Given User access to Support Center url
    And User login to Support Center with valid account
    And User can see Support Center Dashboard page
    When User open Member tab in Support Center
    And User input member valid email to search in Member page
    And User click on View link in display record
    And User open Program Information tab
    Then User can see all program content details
    
  #A/C Support Center - Member Tab - View Levels and Rewards Details
  #G: an internal user lands on member / porgram information detail page
  #W: user clicks on program information tab
  #T:  user should be able to see all levels and rewards details including
  #Levels |Required Items | Rewards details | Status | Total Required Pts
  Scenario: [SC6-AC2] Member Tab - View Levels and Rewards Details
    Given User access to Support Center url
    And User login to Support Center with valid account
    And User can see Support Center Dashboard page
    When User open Member tab in Support Center
    And User input member valid email to search in Member page
    And User click on View link in display record
    And User open Program Information tab
    Then User can see all levels and rewards details
    
  #A/C Support Center - Member Tab - Update Member Path/Activity Status
  #G: an internal user lands on member / porgram information detail page > Program Info Tab
  #W: user clicks on any of the unjoined/ unenrolled activity/path
  #T:  user should have the ability to join/enroll an activity/path on behalf of members
  #Scenario: [SC7] Member Tab - Update Member Path/Activity Status
    #Given User access to Support Center url
    #And User login to Support Center with valid account
    #And User can see Support Center Dashboard page
    #When User open Member tab in Support Center
    #And User input member valid email to search in Member page
    #And User click on View link in display record
    #And User open Program Information tab
    #And User click to "UnEnroll" link activity or path
    #Then User can see activity changed status "<status>"
    #Examples:
    #| Link      | Status |
    #| UnEnroll  | 
    #| UnJoin    |