package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import org.example.manager.ShipManager;

public class Battlefield {
    List<List<Cell>> grid;
    int gridSize;
    ShipManager shipManager;
    int size;

    public Battlefield(int n) {
        if(n%2==1){
            System.out.println("Grid cannot be of odd size");
            return;
        }
        this.gridSize = n;
        grid = new ArrayList<>(n);
        for(int i=0; i<n; i++) {
            grid.set(i, new ArrayList<>());
        }
    }

    public void start() {

    }

    public void fillGrid(List<ShipRequest> shipRequests) {
        grid = shipManager.addShips(shipRequests, gridSize);
    }

}
