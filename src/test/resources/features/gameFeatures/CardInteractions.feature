Feature: Card Interactions

  Scenario: Checking for an updated pile
	Given a game of cheat with 1 players
	Given a list of cards to play
	And the cards to play contains a Ace of Hearts
	And the cards to play contains a Three of Clubs
	When the cards are played
	Then the pile of cards has 2 cards