Feature: Test feature
  Scenario Outline: Test scenario
    Given I have a test case class "<className>"
    When I run the test case with browser "<browser>"
    Then the test case should run successfully

    Examples:
      | className                 | browser |
      |             | Chrome   |
      | TestCaseClass2            | Edge     |