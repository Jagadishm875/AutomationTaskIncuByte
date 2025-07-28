Feature: Sign up and login flow

  Scenario: Create a new user and login successfully
    Given I navigate to the Magento homepage
    When I click on the "Create an Account" link
    And I fill the registration form with valid details
    Then I should see the success message after account creation
    Then I close the browser