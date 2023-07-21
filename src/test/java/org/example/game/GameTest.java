package org.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Kolya5", 0);
    Player player2 = new Player(2, "Sonya_a", 3);
    Player player3 = new Player(3, "Vasiliy007", 9);
    Player player4 = new Player(4, "Sonya_aaa", 3);

    @Test
    public void shouldRoundIfVinSecond() {
        Game manager = new Game();
        manager.register(player1);
        manager.register(player2);
        manager.register(player3);
        manager.register(player4);

        int expected = 2;
        int actual = manager.round("Kolya5", "Sonya_a");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundIfVinFirst() {
        Game manager = new Game();
        manager.register(player1);
        manager.register(player2);
        manager.register(player3);
        manager.register(player4);

        int expected = 1;
        int actual = manager.round("Vasiliy007", "Sonya_a");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundIfDraw() {
        Game manager = new Game();
        manager.register(player1);
        manager.register(player2);
        manager.register(player3);
        manager.register(player4);

        int expected = 0;
        int actual = manager.round("Sonya_aaa", "Sonya_a");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundIfFirstPlayerNotRegistered() {
        Game manager = new Game();
        manager.register(player1);
        manager.register(player2);
        manager.register(player3);
        manager.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Kolya3", "Sonya_a");
        });
    }

    @Test
    public void shouldRoundIfSecondPlayerNotRegistered() {
        Game manager = new Game();
        manager.register(player1);
        manager.register(player2);
        manager.register(player3);
        manager.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Sonya_a", "Kolya3");
        });
    }
}
