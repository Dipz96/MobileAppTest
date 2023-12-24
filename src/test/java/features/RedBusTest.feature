
Feature: Red Bus App Test
 
  
  Scenario: App Login Test
    When Login To Account with "email"
    Then Profile Page is Displayed

	Scenario: Search for buses
    Given Login To Account
    When Search Buses for "currentDate+2"
    Then Bus Details are Displayed
    
    Scenario: App Login Test with OTP
    When Login To Account with "Phone Number"
    Then Profile Page is Displayed