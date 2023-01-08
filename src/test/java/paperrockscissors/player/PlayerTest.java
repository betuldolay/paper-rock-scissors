package paperrockscissors.player;

import org.junit.jupiter.api.Test;
import paperrockscissors.enums.Choice;
import paperrockscissors.utils.IOProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlayerTest {
    @Test
    public void testPlayerConstructor() {
        Player player = new PlayerImpl();
        assertNotNull(player);
    }

    @Test
    public void testPlayerConstructorWithName() {
        Player player = new PlayerImpl("Alice");
        assertNotNull(player);
        assertEquals("Alice", player.getName());
    }

    @Test
    public void testSetName() {
        Player player = new PlayerImpl();
        player.setName("Bob");
        assertEquals("Bob", player.getName());
    }

    @Test
    public void testGetChoice() {
        Player player = new PlayerImpl();
        player.setChoice(Choice.P);

        assertEquals(Choice.P, player.getChoice());
    }

    @Test
    public void testSetChoice() {
        Player player = new PlayerImpl();
        player.setChoice(Choice.S);

        assertEquals(Choice.S, player.getChoice());
    }

    private static class PlayerImpl extends Player {
        public PlayerImpl() {
            super();
        }

        public PlayerImpl(String name) {
            super(name);
        }

        @Override
        public Choice selectChoice(IOProvider ioProvider) {
            return null;
        }
    }
}