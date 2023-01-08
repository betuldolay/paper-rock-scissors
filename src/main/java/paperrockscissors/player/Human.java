package paperrockscissors.player;

import paperrockscissors.enums.Choice;
import paperrockscissors.utils.IOProvider;

/**
 * A class representing a human player in a paper-rock-scissors game.
 */
public class Human extends Player {

    /**
     * Constructs a new {@code Human} with the name "Human".
     */
    public Human() {
        setName("Human");
    }

    /**
     * Prompts the user for their choice and returns it. If the user enters an invalid choice, displays a warning and prompts the user again.
     *
     * @param ioProvider the I/O provider to use for user input and output
     * @return the user's choice
     */
    @Override
    public Choice selectChoice(final IOProvider ioProvider) {
        try {
            setChoice(Choice.valueOf(ioProvider.getInput().toUpperCase()));
            ioProvider.displayPlayersChoice(this);
        } catch (IllegalArgumentException ex) {
            ioProvider.displayValidChoiceWarning();
            selectChoice(ioProvider);
        }

        return getChoice();
    }
}

