Feature: Eform Details

  Background: Successfully Login
    Given user navigates to Website
    When user enters credential from credentialsheet
    And user clicks on Login button


  Scenario: Successfully submit Additional software request details
    Given user is on Additional software request page
    When user enter required detail to raise eform
    And User Click on Submit button
    Then User gets eform number

  Scenario: Successfully submit privilege request details
    Given user is on Privilege request page
    When user enter required detail
    And User accept terms and conditions
    And User Click Submit button
    Then User gets eform number

  Scenario: Successfully view status
    When user clicks on View Status button
    And user fills E-formNo
    And user clicks on Submit button
    And verify status
