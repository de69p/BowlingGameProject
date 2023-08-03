Feature: Bowling Game Scoring
  In order to play a game of bowling
  As a player
  I want to be able to keep track of my score

  Scenario: Gutter game
    Given a new bowling game
    When I roll all zeros
    Then my total score should be 0

  Scenario: All ones
    Given a new bowling game
    When I roll all ones
    Then my total score should be 20

  Scenario: One spare
    Given a new bowling game
    When I roll a spare
    And I roll a 3
    And I roll all zeros
    Then my total score should be 16

  Scenario: One strike
    Given a new bowling game
    When I roll a strike
    And I roll a 3
    And I roll a 4
    And I roll all zeros
    Then my total score should be 24

  Scenario: Perfect game
    Given a new bowling game
    When I roll all strikes
    Then my total score should be 300
