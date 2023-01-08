package paperrockscissors.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import paperrockscissors.enums.Choice;
import paperrockscissors.utils.IOProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HumanTest {

    @Mock
    private IOProvider mockIOProvider;

    Human human;

    @BeforeEach
    void setUp() {
        human = new Human();
    }

    @Test
    public void testSelectChoice_ReturnsPaper() {

        when(mockIOProvider.getInput()).thenReturn("P");
        final Choice choice = human.selectChoice(mockIOProvider);

        assertEquals(choice, Choice.P);
    }

    @Test
    public void testSelectChoice_ReturnsRock() {

        when(mockIOProvider.getInput()).thenReturn("R");
        final Choice choice = human.selectChoice(mockIOProvider);

        assertEquals(choice, Choice.R);
    }

    @Test
    public void testSelectChoice_ReturnsScissors() {

        when(mockIOProvider.getInput()).thenReturn("S");
        final Choice choice = human.selectChoice(mockIOProvider);

        assertEquals(choice, Choice.S);
    }
}