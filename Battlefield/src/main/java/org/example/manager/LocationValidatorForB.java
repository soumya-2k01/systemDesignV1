package org.example.manager;

import org.example.entity.ShipRequest;

public class LocationValidatorForB implements LocationValidator{
    @Override
    public boolean validateLocation(ShipRequest shipRequest, int n) {
        int x = shipRequest.getxStart();
        int y = shipRequest.getyStart();
        int shipSize = shipRequest.getSize();
        if(!(x>=0 && x<n && y>=n/2 && y<n))return false;
        else if(x+shipSize-1>=n || y+shipSize-1>=n)return false;
        return true;
    }
}
