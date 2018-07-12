package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static game.util.Util.*;
import static util.Config.*;

public class CheatGame {

	private final int numPlayers;
	private Stack<Card> pile = new Stack<>();
	private List<Card> lastPlayed;
	private List<Card> lastClaimed;

	private int turn;

	public CheatGame(int numPlayers) {
		assert numPlayers > MIN_PLAYERS;
		assert numPlayers < MAX_PLAYERS;
		this.numPlayers = numPlayers;
		turn = 1;
	}

	/**
	 * Plays the cards that are passed into this function, adding them to the pile.
	 * @param cards the cards to add.
	 */
	public void playCards(List<Card> cards) {
		pile.addAll(cards);
		lastPlayed = cards;
	}

	/**
	 * Claims the cards that are passed into this function.
	 * @param cards the cards to add.
	 */
	public void claimCards(List<Card> cards) {
		assert !cards.isEmpty();
		lastClaimed = cards;
	}

	public void claimCards(int number, Type type) {
		assert number > 0;
		assert type != null;
		for (int i = 0; i < number; i++) {
			lastClaimed.add(new Card(Suit.values()[(int) (Math.random() * Suit.values().length)], type));
		}
	}

	/**
	 * A player calls Cheat on the last-played set of cards. The player calling must not be the player who played those
	 * cards, and the pile must have cards.
	 *
	 * @param playerCalling the index of the player calling Cheat
	 * @return true if the cards were invalid and the call was correct,
	 * false if the cards were valid and the call was incorrect.
	 */
	public boolean callCheat(int playerCalling) {
		assert playerCalling != turn;
		assert pile.size() > 0;

		lastPlayed = new ArrayList<>();
		lastClaimed = new ArrayList<>();

		return !lastPlayIsValid();
	}

	public int nextTurn() {
		turn = (turn + 1 > numPlayers) ? 1 : turn + 1;
		return turn;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	/**
	 * Returns the pile of cards and resets the pile. Should be used when a player must pick up the pile.
	 * @return the pile of Cards as a Stack.
	 */
	public Stack<Card> drawPile() {
		Stack<Card> pile = getPile();
		this.pile = new Stack<>();
		return pile;
	}

	private boolean lastPlayIsValid() {
		if (lastPlayed.size() != lastClaimed.size()) {
			return false;
		}
		for (int i = 0; i < lastPlayed.size(); i++) {
			if (!verifyCard(lastPlayed.get(i), lastClaimed.get(i))) {
				return false;
			}
		}
		return true;
	}

	public Stack<Card> getPile() {
		return pile;
	}
}
