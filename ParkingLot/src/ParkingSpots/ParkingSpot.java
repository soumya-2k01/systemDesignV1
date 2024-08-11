package ParkingSpots;

import Vehicle.Vehicle;

public interface ParkingSpot {

    String parkVehicle(Vehicle vehicle);
    Vehicle removeVehicle();
}
