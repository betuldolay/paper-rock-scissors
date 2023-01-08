package paperrockscissors.enums;

/**
 * An enum class representing the possible choices in this game of paper-rock-scissors.
 */
public enum Choice {
    /**
     * Indicates the choice of paper.
     */
    P("Paper"),
    /**
     * Indicates the choice of rock.
     */
    R("Rock"),
    /**
     * Indicates the choice of scissors.
     */
    S("Scissors");

    private final String name;

    /**
     * Constructs a new `Choice` enum value with the given name.
     *
     * @param name the name of the choice
     */
    Choice(String name) {
        this.name = name;
    }

    /**
     * Returns the name of this choice.
     *
     * @return the name of this choice
     */
    public String getName() {
        return name;
    }
}
