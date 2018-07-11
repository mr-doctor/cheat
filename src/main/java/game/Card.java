package game;

import game.util.Util.*;

public class Card {

	private final Suit suit;
	private final Type type;

	public Card(Suit suit, Type type) {
		this.suit = suit;
		this.type = type;
	}

	public Suit getSuit() {
		return suit;
	}

	public Type getType() {
		return type;
	}

	@Override
	public boolean equals(Object obj) {
		if (!obj.getClass().equals(this.getClass())) {
			return false;
		}
		if (!(obj instanceof Card)) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		Card cardObj = (Card) obj;

		return cardObj.getSuit().equals(this.getSuit()) && cardObj.getType().equals(this.getType());
	}
}
