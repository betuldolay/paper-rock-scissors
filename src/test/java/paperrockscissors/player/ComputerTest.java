package paperrockscissors.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import paperrockscissors.enums.Choice;
import paperrockscissors.utils.IOProvider;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ComputerTest {

    @Mock
    Random mockRandom;
    @Mock
    private IOProvider mockIOProvider;

    Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer(mockRandom);
    }

    @Test
    public void testSelectChoice_ReturnsPaper_WhenRandomNumberGeneratorReturnsZero() {

        when(mockRandom.nextInt(anyInt())).thenReturn(0);
        final Choice choice = computer.selectChoice(mockIOProvider);

        assertEquals(choice, Choice.P);
    }

    @Test
    public void testSelectChoice_ReturnsRock_WhenRandomNumberGeneratorReturnsOne() {

        when(mockRandom.nextInt(anyInt())).thenReturn(1);
        final Choice choice = computer.selectChoice(mockIOProvider);

        assertEquals(choice, Choice.R);
    }

    @Test
    public void testSelectChoice_ReturnsScissors_WhenRandomNumberGeneratorReturnsTwo() {

        when(mockRandom.nextInt(anyInt())).thenReturn(2);
        final Choice choice = computer.selectChoice(mockIOProvider);

        assertEquals(choice, Choice.S);
    }

    @Test
    public void testSelectChoice_ThrowsException_WhenRandomNumberGeneratorReturnsNumberGreaterThanTwo() {
        when(mockRandom.nextInt(anyInt())).thenReturn(3);

        ArrayIndexOutOfBoundsException thrown = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> computer.selectChoice(mockIOProvider)
        );

        assertEquals(thrown.getMessage(), "Index 3 out of bounds for length 3");
    }
}
