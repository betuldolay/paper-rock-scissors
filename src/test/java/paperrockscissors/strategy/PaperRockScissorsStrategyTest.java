package paperrockscissors.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import paperrockscissors.enums.Choice;
import paperrockscissors.enums.RoundResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaperRockScissorsStrategyTest {

    Strategy paperRockScissorsStrategy;

    @BeforeEach
    void setUp() {
        paperRockScissorsStrategy = new PaperRockScissorsStrategy();
    }

    @Test
    void testGetRoundResult_ReturnsTie_WhenFirstChoiceEqualsSecondChoice() {
        assertEquals(RoundResult.TIE, paperRockScissorsStrategy.getRoundResult(Choice.P, Choice.P));
        assertEquals(RoundResult.TIE, paperRockScissorsStrategy.getRoundResult(Choice.R, Choice.R));
        assertEquals(RoundResult.TIE, paperRockScissorsStrategy.getRoundResult(Choice.S, Choice.S));
    }

    @Test
    void testGetRoundResult_ReturnsWon_WhenFirstChoiceBeatsSecondChoice() {
        assertEquals(RoundResult.WON, paperRockScissorsStrategy.getRoundResult(Choice.P, Choice.R));
        assertEquals(RoundResult.WON, paperRockScissorsStrategy.getRoundResult(Choice.R, Choice.S));
        assertEquals(RoundResult.WON, paperRockScissorsStrategy.getRoundResult(Choice.S, Choice.P));
    }

    @Test
    void testGetRoundResult_ReturnsLost_WhenSecondChoiceBeatsFirstChoice() {
        assertEquals(RoundResult.LOST, paperRockScissorsStrategy.getRoundResult(Choice.P, Choice.S));
        assertEquals(RoundResult.LOST, paperRockScissorsStrategy.getRoundResult(Choice.R, Choice.P));
        assertEquals(RoundResult.LOST, paperRockScissorsStrategy.getRoundResult(Choice.S, Choice.R));
    }
}