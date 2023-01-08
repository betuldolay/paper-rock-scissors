package paperrockscissors.controller;

import lombok.Data;
import paperrockscissors.enums.RoundResult;

/**
 * A class representing the result of a paper-rock-scissors game.
 */
@Data
public class GameResult {
    private int wins;
    private int losses;
    private int ties;

    /**
     * Updates the result of the game based on the result of the round.
     *
     * @param roundResult the result of the round
     */
    public void updateGameResult(final RoundResult roundResult) {
        switch (roundResult) {
            case WON:
                wins++;
                break;
            case LOST:
                losses++;
                break;
            case TIE:
                ties++;
                break;
        }
    }
}
