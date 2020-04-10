Feature: Tasks page validation
  
  Description: This feature is for tasks page validation

  Background: 
    Given User is on tasks page

  Scenario: Tasks page validation scenario
  
  	When User clicks on new tasks link
    Then user fill new tasks details
