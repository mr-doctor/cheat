package game.util;

import game.Card;

public class Util {
	public enum Suit {
		HEARTS, DIAMONDS, SPADES, CLUBS }

	public enum Type { ACE, TWO, THREE, FOUR, FIVE, SIX,
		SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

	/**
	 * Checks to see if two cards have the same type.
	 * @param card1
	 * @param card2
	 * @return
	 */
	public static boolean verifyCard(Card card1, Card card2) {
		return card1.getType().equals(card2.getType());
	}
}
