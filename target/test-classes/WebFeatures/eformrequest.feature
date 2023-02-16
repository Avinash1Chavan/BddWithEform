Feature: Request form

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


  Scenario: Successfully submit infrastructure request details
    Given user is on infrastructure request page
    When user select project and enter Requirement Details
    And user enter User Details
    And user enter Remarks
    And User clicks on Submit button
    Then user gets eform number


  Scenario: Successfully submit link request form details
    Given user is on link request form page
    When user select project name
    And user enter location Details
    And user enter link Details
    And user enter remarks
    And User click on Submit button
    Then user get eform number