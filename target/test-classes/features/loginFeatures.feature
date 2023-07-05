Feature: Login Functionality Of Orange CRM Website
  This feature will used to test login functionality of application

  @regression
  Scenario: Positive Login test case
    Given the website is open
    When User enters "Admin" and "admin123"
    And Hit the submit button
    Then Homepage should be loaded

  Scenario Outline: Positive Login test data
    Given the website is open
    When User enter "<UserName>" and "<Password>"
    And Hit the submit button
    Then Homepage should be loaded
    Examples:
      | UserName  | Password|
      | Admin | admin123  |
      | Admin1| admin321  |
