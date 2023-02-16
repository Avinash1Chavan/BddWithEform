@Common
Feature:  Snapdeal buying product scenario

  Scenario: Successfully buying product On Snapdeal
    Given user navigates to Snapdeal Application
    When user enter product name on search field
    And User verified search result
    Then User Select Sorted with Popularity
    And Selected Range 700 to 3000
    Then user clicked on First Item
    Then moved to another tab
    And clicked the AddToCart button
    And verified remove cart item

