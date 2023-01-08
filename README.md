# Paper Rock Scissors Game
This is a command-line, Object-Oriented Design implementation of the popular game [Paper Rock Scissors](https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors)
This game allows a user to play against a computer, and keeps track of the number of wins, losses, and ties.

How to Run
---
To run the game, run the GameApplication class.

![img.png](img.png)

How to Play
---
1. The game will start by displaying an intro message.
2. On each round, the user will be prompted to choose either P, R, or S.
3. The computer will also make its choice.
4. The round result will be displayed and the overall game result will be updated.
5. You will be asked if you want to play again by prompting Y or N.
6. When the user chooses to play again, he/she will be prompted again to make a choice of  P, R, or S.
7. When the user chooses to not play again, the final game result will be displayed.
8. Game result will show the total number of wins, losses and ties.

Code Structure
---
The game consists of several classes:
* **GameApplication**: This is the entry point to the game.
* **GameController**: This is the main controller class that coordinates the game flow and invokes the other classes.
* **GameEngine**: This class handles the logic of playing a single round of the game. It receives the choices of the two players and determines the result of the round.
* **GameResult**: This class tracks the overall result of the game, including the number of wins, losses, and ties.
* **RoundResult**: This class tracks the result of a round, which then will be used to update the GameResult.
* **PlayAgain**: This class tracks the choice to play again.
* **Human and Computer**: These classes represent the two players in the game. The human player is controlled by the user, while the computer player uses a random number generator to choose its move.
* **Strategy**: This interface defines the strategy for determining the result of a round. The default implementation is the PaperRockScissorsStrategy, which follows the standard rules of the game.
* **IOProvider**: This class handles the input and output for the game, including displaying messages and prompts to the user.

Customization
---
The game can be customized by providing your own implementations for the Player and Strategy classes.
The default implementation is Human for a human player and Computer for a computer player.

The default implementation is PaperRockScissorsStrategy for strategy. For example, A Lizard-Spock extension can be implemented as another strategy here.
You can also provide a custom IOProvider if you want to change the way the game handles input and output.

Testing
---
Unit tests can be found in the test package. To run the tests, use a testing library such as JUnit.

Mockito is used to mock dependencies in some tests.

Notes
---
For the sake of the continuity of the game, this game implemented in such a way that if the user chooses an invalid choice (other than P, R, S) then a warning message will be shown and the user will be prompted to choose again.
Same logic will be applied to continue to play the game. 