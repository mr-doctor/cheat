package gherkin;

import game.Card;
import game.CheatGame;

import java.util.List;

public class InterClassStorage {

	private static CheatGame game;
	private static List<Card> cardList;

	public static CheatGame getGame() {
		return game;
	}

	public static void setGame(CheatGame game) {
		InterClassStorage.game = game;
	}

	public static List<Card> getCardList() {
		return cardList;
	}

	public static void setCardList(List<Card> cardList) {
		InterClassStorage.cardList = cardList;
	}

	public static void addCard(Card card) {
		cardList.add(card);
	}
}
