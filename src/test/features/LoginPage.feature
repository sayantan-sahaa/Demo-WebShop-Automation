Feature: Login Functionality
  As a registered user
  I want to be able to log in to the Demo Web Shop
  So that I can access my account and manage my orders

  Background:
    Given the user is on the Demo Web Shop login page

  Scenario: Successful login with valid credentials
    When the user enters valid email address
    And the user enters valid password
    And the user clicks on the login button
    Then the user should be logged in successfully
    And the user should see their account information

  Scenario: Failed login with invalid email
    When the user enters invalid email address
    And the user enters valid password
    And the user clicks on the login button
    Then the user should see an error message
    And the user should remain on the login page

  Scenario: Failed login with invalid password
    When the user enters valid email address
    And the user enters invalid password
    And the user clicks on the login button
    Then the user should see an error message
    And the user should remain on the login page

  Scenario: Failed login with empty fields
    When the user leaves the email field empty
    And the user leaves the password field empty
    And the user clicks on the login button
    Then the user should see validation error messages
    And the user should remain on the login page

  Scenario: Remember me functionality
    When the user enters valid email address
    And the user enters valid password
    And the user checks the "Remember me" checkbox
    And the user clicks on the login button
    And the user logs out
    And the user navigates to the login page again
    Then the email field should be pre-filled with the user's email

  Scenario Outline: Login with different credentials
    When the user enters "<email>" as email
    And the user enters "<password>" as password
    And the user clicks on the login button
    Then the login status should be "<status>"

    Examples:
      | email                 | password     | status    |
      | valid@example.com     | valid_pass   | success   |
      | invalid@example.com   | valid_pass   | failure   |
      | valid@example.com     | invalid_pass | failure   |
      | invalid@example.com   | invalid_pass | failure   |

  Scenario: Password recovery functionality
    When the user clicks on the "Forgot password?" link
    Then the user should be redirected to the password recovery page
    When the user enters their email address
    And the user clicks on the recover button
    Then the user should see a confirmation message