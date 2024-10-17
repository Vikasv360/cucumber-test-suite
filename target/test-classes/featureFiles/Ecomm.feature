
Feature: Validating all the functionalities of Swag Labs Ecommerce application 

  @E2E
  Scenario Outline: Validate placing a purchase order
    Given User is on the Swag Labs login screen
    When User login with valid "<username>" and "<password>" 
    Then User select list of items from products screen
    | Sauce Labs Backpack      |
    | Sauce Labs Bike Light    |
    | Sauce Labs Fleece Jacket |
    And User clicks on the cart icon
    And User verifies the items in Your Cart screen
    Then User clicks on Checkout button
    And User enters "<FirstName>", "<LastName>", "<ZipCode>" in Checkout: Your Information screen
    Then User clicks on Continue button
    And User verifies the price total in Checkout: Overview screen
    And User verifies the success message in Checkout: Complete! screen
    Then User clicks Back Home button 
    And User is displayed with Products screen

 Examples: 
      | username        | password     | FirstName | LastName | ZipCode |
      | standard_user   | secret_sauce | Vikas     | V        | 741852  |
      | standard_user   | secret_sauce | Vasantha  | Vanitha  | 852966  |
      | problem_user    | secret_sauce | Vajantha  | Vanutha  | 455677  |


