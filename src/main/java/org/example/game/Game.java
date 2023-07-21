package org.example.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
   List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player name1 = findByName(playerName1);
        Player name2 = findByName(playerName2);

        if (name1 == null) {
            throw new NotRegisteredException(
                    "Element with name: " + playerName1 + " not registered "
            );
        }
        if (name2 == null) {
            throw new NotRegisteredException(
                    "Element with name: " + playerName2 + " not registered "
            );
        }
        if (name1.getStrength() > name2.getStrength()) {
            return 1;
        }
        if (name1.getStrength() < name2.getStrength()) {
            return 2;
        }
        return 0;

    }
}
