Feature: Test OrangeHRM Login Validations
  Scenario: Logo Presence OrangeHRM Home Page
    Given I Launch Chrome Browser
    When I open Orange HRM homepage
    Then I Verify Logo Presence
    And Close Browser

    Scenario: Login validation with different users
      Given I Launch Chrome Browser
      When I open Orange HRM homepage
      Then I Verify Logo Presence
      Then Enter user details with "Admin" and "admin123"
      And Close Browser