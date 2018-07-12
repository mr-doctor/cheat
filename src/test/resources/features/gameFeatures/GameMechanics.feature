Feature: Game mechanics

  Scenario Outline: check that ending the turn works
	Given a game of cheat with 3 players
	Given the turn starts at <start turn>
	When it goes to the next turn
	Then the turn is <end turn>
	Examples:
	  | start turn | end turn |
	  | 1          | 2        |
	  | 2          | 3        |
	  | 3          | 1        |