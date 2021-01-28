Feature: Key Presses
  As a user I should able to input keys into a box and see them displayed on the web page


  Scenario: I enter 4 key presses and assert they echo back
    Given I navigate to "http://the-internet.herokuapp.com/key_presses"
    When I input an "a" key into the input field having id "target"
    Then I see the input "a" shown on the element having id "result"
    When I input an "/" key into the input field having id "target"
    Then I see the input "slash" shown on the element having id "result"
    When I input an "h" key into the input field having id "target"
    Then I see the input "h" shown on the element having id "result"
    When I input an "1" key into the input field having id "target"
    Then I see the input "1" shown on the element having id "result"