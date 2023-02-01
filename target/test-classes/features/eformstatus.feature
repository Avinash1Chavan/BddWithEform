Feature: View status

  Background: Successfully Login


  Scenario Outline: Successfully view status
    Given user navigates to Website
    When user enters username as "<sheetname>" and password as "<rownum>"
    And user clicks on Login button
    And user clicks on View Status button
    And user fills E-formNo
    And user clicks on Submit button
    And verify status
    Examples:
      |sheetname  | rownum |
      |  Sheet1 | 0 |
      |  Sheet1 | 1 |
      |  Sheet1 | 2 |
      |  Sheet1 | 3 |
      |  Sheet1 | 4 |
