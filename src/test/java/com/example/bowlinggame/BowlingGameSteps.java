package com.example.bowlinggame;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class BowlingGameSteps {

    private BowlingGame game;

    @Given("^a new bowling game$")
    public void aNewBowlingGame() {
        game = new BowlingGame();
    }

    @When("^I roll all zeros$")
    public void iRollAllZeros() {
        rollMany(20, 0);
    }

    @When("^I roll all ones$")
    public void iRollAllOnes() {
        rollMany(20, 1);
    }

    @When("^I roll a spare$")
    public void iRollASpare() {
        game.roll(5);
        game.roll(5);
    }

    @When("^I roll a strike$")
    public void iRollAStrike() {
        game.roll(10);
    }

    @When("^I roll all strikes$")
    public void iRollAllStrikes() {
        rollMany(12, 10);
    }

    @When("^I roll a (\\d+)$")
    public void iRollA(int pins) {
        game.roll(pins);
    }

    @When("^I roll remaining zeros$")
    public void iRollRemainingZeros() {
        rollMany(16, 0);
    }

    @Then("^my total score should be (\\d+)$")
    public void myTotalScoreShouldBe(int expectedScore) {
        assertEquals(expectedScore, game.score());
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            if (game.currentRoll < 21) {
                game.roll(pins);
            }
        }
    }
}

