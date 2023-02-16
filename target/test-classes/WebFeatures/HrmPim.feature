@Common
Feature: Orange Hrm AddEmployee And EmployeeList Scenario


  Background: Successfully Login on Hrm Application
    Given user navigates to HrmWebsite
    When user enters credential on Hrm Application and click login button

  Scenario: Successfully automated AddEmployee details
    Given user clicking PIM On Orange HRM application
    Given user clicking AddEmployee On Orange HRM application
    When user entering Orange HRM application details as First Name,lastName, middleName and click save button
    And user scrolled Orange HRM application
    And user selecting dropdowns on Orange HRM application
    Then User selected data on Hrm application
    And  user Select Radio Button on Hrm
    Then user Select Smoker checkbox on Hrm









