Feature: Human performance
     Can open the Human Performance page and view HPA results
  #MEM11>AC 1/2
	Scenario: Access and verify HPA data is displayed and correct
     Given User access to Connect url
     When User login to Connect web with HPA account
     And User access HPA page from top navigation
     Then User can see "Human Performance" page have "Flourishing Index", "Human Performance Assessment"
     And User can see flourishing index score is "120 / 120"
     And User can see 6 cards in Flourishing Index section
     And User can see card 1 in Flourishing Index is "Close Social Relationships"
     And User can see card 2 in Flourishing Index is "Character & Virtue"
     And User can see card 3 in Flourishing Index is "Happiness & Life Satisfaction"
     And User can see card 4 in Flourishing Index is "Financial & Material Stability"
     And User can see card 5 in Flourishing Index is "Meaning & Purpose"
     And User can see card 6 in Flourishing Index is "Mental & Physical Health"
     And User can see HPA section have 3 cards in Top Strengths
     And User can see HPA section have 3 cards in Top Opportunities
     And User can see 13 cards in All Scores section