Feature: Automated End2End Tests
Description: The purpose of this feature is to test end 2 end integration.

Scenario: Customer place an order by purchasing an item from search
    Given user is on home page
    When he search for "dress"
    And choose to buy the first item
    And moves to checkout for mini cart
    And enter personal details on checkout page
    And select the same delivery address
    And select payment method as "check" payment
    And place the order