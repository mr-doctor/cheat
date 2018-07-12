package gherkin;

import static org.junit.jupiter.api.Assertions.*;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import game.Card;
import game.CheatGame;
import static game.util.Util.*;

import java.util.ArrayList;

import static gherkin.InterClassStorage.*;

public class CardInteractionSteps {

	private int numCards = 0;

	@Given("^a game of cheat with (\\d+) players$")
	public void givenAGameOfCheatWithNPlayers(int numPlayers) {
		setGame(new CheatGame(numPlayers));
	}

	@Given("^a list of cards to play$")
	public void aListOfCardsToPlay() throws Throwable {
		setCardList(new ArrayList<>());
	}

	@And("^the cards to play contains a ([^\"]*) of ([^\"]*)$")
	public void theCardsToPlayContainsATypeOfSuit(String typeString, String suitString) throws Throwable {
		Suit suit = Suit.valueOf(suitString.toUpperCase());
		Type type = Type.valueOf(typeString.toUpperCase());

		Card card = new Card(suit, type);

		addCard(card);
		numCards++;
	}

	@And("^the cards to play contains an ([^\"]*) of ([^\"]*)$")
	public void theCardsToPlayContainsAnTypeOfSuit(String typeString, String suitString) throws Throwable {
		theCardsToPlayContainsATypeOfSuit(typeString, suitString);
	}

	@When("^the cards are played$")
	public void theCardsArePlayed() throws Throwable {
		getGame().playCards(getCardList());
	}

	@Then("^the pile of cards has (\\d+) cards$")
	public void thePileOfCardsIncreasesInSize(int expectedSize) throws Throwable {
		assertEquals(expectedSize, numCards);
	}

	@Then("^the pile of cards contains those cards$")
	public void thePileOfCardsContainsThoseCards() throws Throwable {
		assertTrue(getGame().getPile().containsAll(getCardList()));
	}
}
