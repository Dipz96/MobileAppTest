
Feature: Red Bus App Test
 
  
  Scenario: App Login Test
    When Login To Account
    Then Profile Page is Displayed

	Scenario: Search for buses
    Given Login To Account
    When Search Buses for "currentDate+2"
    Then Bus Details are Displayed