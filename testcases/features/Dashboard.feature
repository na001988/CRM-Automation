
@SIT
Feature: Access to the shortcuts in the home dashboard
  I want to provide valid credentials to enter into the system and perform actions in the shortcuts.

  Scenario: TC_010 - Verify creation of booking
    Given I enter a user_name and a password
    And press the login_button
    Then I can see the main page of the system
    And I choose the "appointment" shorcut
    And I fill the form with required information
    And I "save" the form
    Then I can see the new "appointment" is created in the system under test. 


  Scenario: TC_011 - Verify access to publications
    Given I enter a user_name and a password
    And press the login_button
    Then I can see the main page of the system
    And I choose the "publications" shorcut
    Then I can read the fist post

  Scenario: TC_012 - Verify access to forum
    Given I enter a user_name and a password
    And press the login_button
    Then I can see the main page of the system
    And I choose the "forum" shorcut
    Then I can read the posts in the page

  Scenario: TC_013 - Verify creation of new comment
    Given I enter a user_name and a password
    And press the login_button
    Then I can see the main page of the system
    And I choose the "post" shorcut
    Then I can enter a question in the form

