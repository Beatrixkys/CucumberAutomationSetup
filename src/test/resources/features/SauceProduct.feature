Feature: Products

Background:
    Given I login with username "standard_user" and password "secret_sauce"

@Product1 @Feature:Product
Scenario: To validate checkout
    Given I should be on Products page
    And I select first Product to checkout 
    And I click on Shopping Cart
    Then I should be on Checkout Page "Your Cart"
    When I click on Checkout 
    Then I should be on Checkout Page "Checkout: Your Information"
    When I fill in Checkout details
    And I click Continue
    Then I should be on Checkout Page "Checkout: Overview"
    When I click Finish 
    Then I should see Completed Page
    #Check navigation

