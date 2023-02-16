@XmlBinding
Feature: Validating Ecommerce_API's

  @LoginForEcommerceXml
  Scenario Outline: Login validation for ecommerce site
    Given Body payload  with the credentials "<userEmail>" and "<userPassword>"
    When user calls the required resource "Login_API" with "POST" method
    Then the API call will be success with status code 200
    Examples:
      | userEmail | userPassword |
      |srimannaidu7849@gmail.com|Sriman@7849|

  @AddProduct
  Scenario Outline:Validating Addition of the product
    Given The authorization token is fetched with the given data "<productName>", "<productCategory>", "<productSubCategory>", "<productPrice>","<productDescription>","<productFor>"
    When user calls the required resource "Login_API" with "POST" method
    Then the API call will be pass successfully with status code 201
    And The "message" will be rendered as the "Product Added Successfully"
    Examples:
      | productName | productCategory | productSubCategory | productPrice | productDescription | productFor |
      | Laptop      | Electronics     |Computer devices    |90000         |Best Laptop         |everyone    |

  @PlacingOrder
  Scenario: Placing the order for product created
    Given sending the placing order payload in xml with required properties
    When user calls the required resource "Login_API" with "POST" method
    Then the API call will be pass successfully with status code 201
    And The "message" will be rendered as the "Order Placed Successfully"
    And the orderNumber will be fetched

  @FetchingOrderDetails
  Scenario: Fetching the order details
    Given Fetching the order details by sending orderNumber as the query parameter
    When user calls the required resource "Login_API" with "POST" method
    Then the API call will be pass successfully with status code 200
    And The message will displayed as "Orders fetched for customer Successfully"

  @DeleteProduct
  Scenario: Deleting the product
    Given Fetching the productId that to be delete
    When user calls the required resource "Login_API" with "POST" method
    Then the API call will be pass successfully with status code 200
    And The "message" should be "Product Deleted Successfully"



