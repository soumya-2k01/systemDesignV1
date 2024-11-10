package org.example.entity;

import java.util.Set;

public class Ship {
    String name;
    int size;
    Set<Cell> location;

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
    }


}
