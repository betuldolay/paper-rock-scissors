package paperrockscissors.controller;

import paperrockscissors.exception.InvalidException;
import paperrockscissors.player.Player;
import paperrockscissors.enums.RoundResult;
import paperrockscissors.strategy.Strategy;
import paperrockscissors.utils.IOProvider;

/**
 * The engine that runs the game.
 */
public class GameEngine {
    /**
     * The human player.
     */
    private final Player human;

    /**
     * The computer player.
     */
    private final Player computer;

    /**
     * The strategy for determining the result of the game.
     */
    private final Strategy strategy;

    /**
     * The I/O provider for interacting with the user.
     */
    private final IOProvider ioProvider;

    /* Constructs a new game engine with the given players, strategy, and I/O provider.
     * @param humanPlayer the humanPlayer player
     * @param computerPlayer the computerPlayer player
     * @param strategy the strategy for determining the result of the game
     * @param ioProvider the I/O provider for interacting with the user
     */
    public GameEngine(final Player humanPlayer, final Player computerPlayer, final Strategy strategy, final IOProvider ioProvider) {
        this.human = humanPlayer;
        this.computer = computerPlayer;
        this.strategy = strategy;
        this.ioProvider = ioProvider;
    }

    public RoundResult play() {
        try {
            return strategy.getRoundResult(human.selectChoice(ioProvider), computer.selectChoice(ioProvider));
        } catch (Exception ex) {
            // log the exception
            throw new InvalidException("Game Engine threw an exception: " + ex);
        }
    }
}