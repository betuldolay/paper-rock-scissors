package paperrockscissors.controller;

import paperrockscissors.enums.PlayAgain;
import paperrockscissors.enums.RoundResult;
import paperrockscissors.player.Computer;
import paperrockscissors.player.Human;
import paperrockscissors.player.Player;
import paperrockscissors.strategy.PaperRockScissorsStrategy;
import paperrockscissors.strategy.Strategy;
import paperrockscissors.utils.IOProvider;

import java.util.Random;

/**
 * The main controller class for a paper-rock-scissors game.
 */
public final class GameController {
    private final Player humanPlayer;
    private final Player computerPlayer;
    private final Strategy strategy;
    private final IOProvider ioProvider;

    public GameController() {
        this(new Human(), new Computer(new Random()), new PaperRockScissorsStrategy(), new IOProvider());
    }

    public GameController(final Player humanPlayer, final Player computerPlayer, final Strategy strategy, final IOProvider ioProvider) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.strategy = strategy;
        this.ioProvider = ioProvider;
    }

    /**
     * Starts the game.
     */
    public void start() {
        ioProvider.displayIntro();
        final GameResult gameResult = new GameResult();

        PlayAgain playAgain;
        do {
            ioProvider.displayChoiceIntro();
            playRound(gameResult);
            playAgain = ioProvider.playAgain();
        } while (playAgain == PlayAgain.Y);

        ioProvider.displaySummary(gameResult);
    }

    /**
     * Plays a single round of the game and updates the game result.
     *
     * @param gameResult the game result to update
     */
    private void playRound(final GameResult gameResult) {
        final GameEngine gameEngine = new GameEngine(humanPlayer, computerPlayer, strategy, ioProvider);
        RoundResult roundResult = gameEngine.play();
        gameResult.updateGameResult(roundResult);
        ioProvider.displayRoundResult(roundResult);
    }
}