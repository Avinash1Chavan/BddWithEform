Feature: Eform Details

  Scenario Outline: successfully submit Additional software request details
    Given user navigates to Website
    When user fills credential  from given sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on Login button
    Given user is on Additional software request page
    When user enter required detail to raise eform
    And User Click on Submit button
    Then User gets eform number
    Examples:
      | SheetName | RowNumber |
      | Sheet1    | 0         |


#  Scenario Outline: successfully submit privilege request details
#    Given user navigates to Website
#    When user fills credential  from given sheetname "<SheetName>" and rownumber <RowNumber>
#    And user clicks on Login button
#    Given user is on Privilege request page
#    When user enter required detail to raise eform
#    And User accept terms and conditions
#    And User Click on Submit button
#    Then User gets eform number
#    Examples:
#      | SheetName | RowNumber |
#      | Sheet1    | 0         |


  Scenario Outline: Successfully view status
    Given user navigates to Website
    When user fills credential  from given sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on Login button
    When user clicks on View Status button
    And user fills E-formNo
    And user clicks on Submit button
    And verify status

    Examples:
      | SheetName | RowNumber |
      | Sheet1    | 0         |

