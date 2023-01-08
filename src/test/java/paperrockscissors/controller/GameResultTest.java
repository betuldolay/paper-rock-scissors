package paperrockscissors.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import paperrockscissors.enums.RoundResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameResultTest {

    private GameResult gameResult;

    @BeforeEach
    public void setUp() {
        gameResult = new GameResult();
    }

    @Test
    public void testUpdateGameResult_Won() {

        RoundResult roundResult = RoundResult.WON;

        // Update wins
        gameResult.updateGameResult(roundResult);
        // Assert
        assertEquals(1, gameResult.getWins());
        // Update wins one more time
        gameResult.updateGameResult(roundResult);
        // Assert
        assertEquals(2, gameResult.getWins());
    }

    @Test
    public void testUpdateGameResult_Lost() {

        RoundResult roundResult = RoundResult.LOST;

        // Update losses
        gameResult.updateGameResult(roundResult);
        // Assert
        assertEquals(1, gameResult.getLosses());
    }

    @Test
    public void testUpdateGameResult_Tie() {

        RoundResult roundResult = RoundResult.TIE;

        // Update ties
        gameResult.updateGameResult(roundResult);
        // Assert
        assertEquals(1, gameResult.getTies());
    }
}