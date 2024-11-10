package org.example.manager;

import java.util.ArrayList;
import java.util.List;
import org.example.entity.Cell;
import org.example.entity.Ship;
import org.example.entity.ShipRequest;

public class ShipManager {
    List<Ship> ships;
    PlayerManager playerManager;
    LocationValidator locationValidator;

    public ShipManager() {
        ships = new ArrayList<>();
    }

    public List<List<Cell>> addShips(List<ShipRequest> shipRequests, int gridSize) {
        if(shipRequests.size()%2==1) {
            System.out.println("Fleet of both players should be equal");
            return null;
        }
        List<List<Cell>> grid = new ArrayList<>();
        if(!validateShips(shipRequests, gridSize)) {
            System.out.println("Invalid ship position input");
            return null;
        }
        int idx = 1;
        for(ShipRequest request: shipRequests) {
            Ship ship = createShip("SH"+idx,request);
            ships.add(ship);
        }
        playerManager.assignShips(ships);
    }

    public boolean validateShips(List<ShipRequest> shipRequests, int gridSize) {
        if(shipRequests.size()%2==1)return false;
        LocationValidator loc1 = new LocationValidatorForA();
        LocationValidator loc2 = new LocationValidatorForB();
        for(ShipRequest request: shipRequests.subList(0,gridSize/2)) { // For A
            if(!loc1.validateLocation(request,gridSize))return false; // to check overlapping
        }
        for(ShipRequest request: shipRequests.subList(gridSize/2,gridSize)) { // For B
            if(!loc2.validateLocation(request,gridSize))return false;
        }
        return true;
    }

    public Ship createShip(String name, ShipRequest shipRequest) {
        List<Cell> cords = new ArrayList<>();
        Ship ship = new Ship(name, shipRequest.getSize());
    }
}
