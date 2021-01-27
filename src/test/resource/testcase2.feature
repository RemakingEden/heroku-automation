Feature: Infinite Scroll
  As a user I should able to scroll to the bottom of the page and the page will automatically load more


  Scenario: I scroll to the bottom of the page twice
    Given I navigate to "http://the-internet.herokuapp.com/infinite_scroll"
    And I wait for "2" seconds
    And I scroll to the bottom of the page
    And I wait for "2" seconds
    And I scroll to the bottom of the page
    And I wait for "2" seconds
    When I scroll to the top of the page
    Then I should see text stating "Infinite Scroll"
