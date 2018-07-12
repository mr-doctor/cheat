package game;

import game.util.Util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Card {

	private final Suit suit;
	private final Type type;

	/**
	 * A custom clone function which creates a new Card using the same suit and type as the origin object.
	 * @return a new Card, a copy of this Card.
	 */
	public Card copy() {
		return new Card(getSuit(), getType());
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
