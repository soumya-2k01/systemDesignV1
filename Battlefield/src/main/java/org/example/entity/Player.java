package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    List<Ship> ships;

    public Player(String name) {
        this.name = name;
        ships = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
}
