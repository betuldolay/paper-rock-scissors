package paperrockscissors.player;

import paperrockscissors.enums.Choice;
import paperrockscissors.utils.IOProvider;

/**
 * The abstract class {@code Player} represents a player in a game.
 */
public abstract class Player {
    /*
     * {@code name}: a {@code String} representing the name of the player
     * */
    private String name;
    /*
     * a {@code Choice} representing the choice made by the player in a game
     * */
    private Choice choice;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    /**
     * Abstract method that must be implemented by concrete subclasses of {@code Player} to select a {@code Choice}
     *
     * @param ioProvider the I/O provider to use for user input and output
     * @return the user's choice
     */
    public abstract Choice selectChoice(IOProvider ioProvider);
}