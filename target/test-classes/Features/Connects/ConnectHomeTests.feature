Feature: Member connects
  Home page displays requirements, levels, and points
  # MEM8 AC2
  Scenario: Home page points, levels, and requirements (full outcomes)
    Given User access to Connect url
    When User login to Connect web with valid account
    Then User can see the level number and level name
    And User can see "View details" link