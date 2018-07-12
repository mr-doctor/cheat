package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static util.Config.*;

public class CheatGame {

	private final int numPlayers;
	private Stack<Card> pile = new Stack<>();

	private int turn = 0;

	public CheatGame(int numPlayers) {
		assert numPlayers > MIN_PLAYERS;
		assert numPlayers < MAX_PLAYERS;
		this.numPlayers = numPlayers;
	}

	/**
	 * Plays the cards that are passed into this function, adding them to the pile.
	 * @param cards the cards to add.
	 */
	public void playCards(List<Card> cards) {
		pile.addAll(cards);
	}

	public Stack<Card> getPile() {
		return pile;
	}
}
