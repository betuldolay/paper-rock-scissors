package paperrockscissors.controller;

import paperrockscissors.enums.Choice;
import paperrockscissors.enums.RoundResult;
import paperrockscissors.exception.InvalidException;
import paperrockscissors.player.Player;
import paperrockscissors.strategy.Strategy;
import paperrockscissors.utils.IOProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameEngineTest {
    private Player mockHumanPlayer;
    private Player mockComputerPlayer;
    private Strategy mockStrategy;
    private IOProvider mockIOProvider;
    private GameEngine gameEngine;

    @BeforeEach
    public void setup() {
        mockHumanPlayer = mock(Player.class);
        mockComputerPlayer = mock(Player.class);
        mockStrategy = mock(Strategy.class);
        mockIOProvider = mock(IOProvider.class);
        gameEngine = new GameEngine(mockHumanPlayer, mockComputerPlayer, mockStrategy, mockIOProvider);
    }

    @Test
    public void testPlay_HumanWins() {
        // given
        when(mockHumanPlayer.selectChoice(mockIOProvider)).thenReturn(Choice.P);
        when(mockComputerPlayer.selectChoice(mockIOProvider)).thenReturn(Choice.R);
        when(mockStrategy.getRoundResult(Choice.P, Choice.R)).thenReturn(RoundResult.WON);

        // when
        RoundResult result = gameEngine.play();

        // then
        assertEquals(RoundResult.WON, result);
        verify(mockHumanPlayer, times(1)).selectChoice(mockIOProvider);
        verify(mockComputerPlayer, times(1)).selectChoice(mockIOProvider);
        verify(mockStrategy, times(1)).getRoundResult(Choice.P, Choice.R);
    }

    @Test
    public void testPlay_ComputerWins() {
        // given
        when(mockHumanPlayer.selectChoice(mockIOProvider)).thenReturn(Choice.P);
        when(mockComputerPlayer.selectChoice(mockIOProvider)).thenReturn(Choice.S);
        when(mockStrategy.getRoundResult(Choice.P, Choice.S)).thenReturn(RoundResult.LOST);

        // when
        RoundResult result = gameEngine.play();

        // then
        assertEquals(RoundResult.LOST, result);
        verify(mockHumanPlayer, times(1)).selectChoice(mockIOProvider);
        verify(mockComputerPlayer, times(1)).selectChoice(mockIOProvider);
        verify(mockStrategy, times(1)).getRoundResult(Choice.P, Choice.S);
    }

    @Test
    public void testPlay_Tie() {
        // given
        when(mockHumanPlayer.selectChoice(mockIOProvider)).thenReturn(Choice.P);
        when(mockComputerPlayer.selectChoice(mockIOProvider)).thenReturn(Choice.P);
        when(mockStrategy.getRoundResult(Choice.P, Choice.P)).thenReturn(RoundResult.TIE);

    }

    @Test
    public void testPlay_ThrowsException() {
        // given
        when(mockHumanPlayer.selectChoice(mockIOProvider)).thenThrow(new InvalidException("Some test exception"));

        // when
        assertThrows(InvalidException.class, () -> gameEngine.play());

        // then
        verify(mockHumanPlayer, times(1)).selectChoice(mockIOProvider);
        verify(mockComputerPlayer, times(0)).selectChoice(mockIOProvider);
        verify(mockStrategy, times(0)).getRoundResult(any(), any());
    }
}