
@SIT
Feature: Access to the shortcuts in the home dashboard
  I want to provide valid credentials to enter into the system and perform actions in the shortcuts.

  Scenario: TC_010 - Verify creation of contacts in the home dashboard.
    Given I enter a user_name and a password
    And press the login_button
    Then I can see the main page of the system
    And I choose the "Create Contact" shorcut
    And I fill the form with required information
    And I "save" the form
    Then I can see the new "Contact" is created in the system under test. 




