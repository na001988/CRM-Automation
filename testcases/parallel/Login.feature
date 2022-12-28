
@sit
Feature: Access to the CRM Application
  I want to provide valid credentials and enter to the system under test.

  Scenario: A - Verify a user can login to the system
    Given I enter a user_name and a password
    And press the login_button
    Then I can see the main page of the system 


  Scenario: B - Verify a user can login to the system
    And press the login_button
    Then I can see the main page of the system 

