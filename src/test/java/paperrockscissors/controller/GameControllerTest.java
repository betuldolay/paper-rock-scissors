package paperrockscissors.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import paperrockscissors.enums.PlayAgain;
import paperrockscissors.enums.RoundResult;
import paperrockscissors.player.Player;
import paperrockscissors.strategy.Strategy;
import paperrockscissors.utils.IOProvider;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameControllerTest {

    @Mock
    private Player mockHumanPlayer;
    @Mock
    private Player mockComputerPlayer;
    @Mock
    private Strategy mockStrategy;
    @Mock
    private IOProvider mockIOProvider;
    private GameController gameController;

    @BeforeEach
    public void setup() {
        gameController = new GameController(mockHumanPlayer, mockComputerPlayer, mockStrategy, mockIOProvider);
    }

    @Test
    public void testStart_PlayAgainReturnsNo() {
        when(mockIOProvider.playAgain()).thenReturn(PlayAgain.N);
        when(mockStrategy.getRoundResult(any(), any())).thenReturn(RoundResult.TIE);

        // when
        gameController.start();

        // then
        verify(mockIOProvider, times(1)).displayIntro();
        verify(mockIOProvider, times(1)).displayChoiceIntro();
        verify(mockIOProvider, times(1)).displayRoundResult(RoundResult.TIE);
        verify(mockIOProvider, times(1)).playAgain();
        verify(mockIOProvider, times(1)).displaySummary(any(GameResult.class));

    }

    @Test
    public void testStart_PlayAgainReturnsYes() {
        when(mockIOProvider.playAgain()).thenReturn(PlayAgain.Y).thenReturn(PlayAgain.Y).thenReturn(PlayAgain.N);
        when(mockStrategy.getRoundResult(any(), any())).thenReturn(RoundResult.WON).thenReturn(RoundResult.LOST).thenReturn(RoundResult.WON);

        // when
        gameController.start();

        // then
        verify(mockIOProvider, times(1)).displayIntro();
        verify(mockIOProvider, times(3)).displayChoiceIntro();
        verify(mockIOProvider, times(2)).displayRoundResult(RoundResult.WON);
        verify(mockIOProvider, times(3)).playAgain();
        verify(mockIOProvider, times(1)).displayRoundResult(RoundResult.LOST);
        verify(mockIOProvider, times(1)).displaySummary(any(GameResult.class));

    }
}