Feature: View status

  Background: Successfully Login
    Given user navigates to Website
    When user enters credential from credentialsheet
    And user clicks on Login button

  Scenario: Successfully view status
    When user clicks on View Status button
    And user fills E-formNo
    And user clicks on Submit button
    And verify status
