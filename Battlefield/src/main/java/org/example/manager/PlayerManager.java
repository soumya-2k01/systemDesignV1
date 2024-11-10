package org.example.manager;

import java.util.List;
import org.example.entity.Player;
import org.example.entity.Ship;

public class PlayerManager {
    Player playerA;
    Player playerB;

    public PlayerManager(Player a, Player b) {
        playerA = a;
        playerB = b;
    }

    public void assignShips(List<Ship> ships) {
        playerA.setShips(ships.subList(0, ships.size()/2));
        playerB.setShips(ships.subList(ships.size()/2,ships.size()));
    }
}
