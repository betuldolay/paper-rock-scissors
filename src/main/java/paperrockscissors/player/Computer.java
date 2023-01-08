package paperrockscissors.player;

import paperrockscissors.enums.Choice;
import paperrockscissors.utils.IOProvider;

import java.util.Random;

/**
 * The Computer class is a concrete implementation of the Player class representing a computer player in a paper-rock-scissors game.
 * <p>
 * This player makes a random selection of paper, rock, or scissors.
 */
public class Computer extends Player {
    private final Random random;
    private static final Choice[] choices = Choice.values();

    /**
     * Constructs a new {@code Computer} with the given {@code Random} object as a source of randomness.
     *
     * @param random the {@code Random} object to use for generating random choices
     */
    public Computer(final Random random) {
        this.random = random;
        setName("Computer");
    }

    /**
     * Generates a random integer within the given range (inclusive).
     *
     * @param bound the upper bound (exclusive) for the random integer
     * @return a random integer within the range [0, bound)
     */
    public int generateRandomInt(int bound) {
        return random.nextInt(bound);
    }

    /**
     * Makes a random choice from choices array of paper, rock, or scissors based on the random integer.
     *
     * @param ioProvider the {@code IOProvider} to use for displaying the choice
     * @return the randomly chosen {@code Choice}
     */
    @Override
    public Choice selectChoice(final IOProvider ioProvider) {
        setChoice(choices[generateRandomInt(choices.length)]);
        ioProvider.displayPlayersChoice(this);
        return getChoice();
    }
}
