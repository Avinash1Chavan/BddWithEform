Feature: Eform Details


  Scenario: Successfully view status
    Given user navigates to Website
    When user enters credential from Db
    And user clicks on Login button
    When user clicks on View Status button
    And user fills E-formNo
    And user clicks on Submit button
    And verify status
