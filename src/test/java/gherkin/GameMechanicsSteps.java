package gherkin;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import game.Card;
import game.CheatGame;
import static game.util.Util.*;

import java.util.ArrayList;

import static gherkin.InterClassStorage.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameMechanicsSteps {

	@Given("^the turn starts at (\\d+)$")
	public void theTurnStartsAtX(int startTurn) {
		getGame().setTurn(startTurn);
	}

	@When("^it goes to the next turn$")
	public void itGoesToTheNextTurn() throws Throwable {
		getGame().nextTurn();
	}

	@Then("^the turn is (\\d+)$")
	public void theTurnIsEndTurn(int expectedTurn) throws Throwable {
		assertEquals(expectedTurn, getGame().getTurn());
	}
}
