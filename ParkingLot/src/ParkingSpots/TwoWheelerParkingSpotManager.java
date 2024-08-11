package ParkingSpots;

import java.util.List;

public class TwoWheelerParkingSpotManager implements ParkingSpotManager{
    List<TwoWheelerParkingSpot> twoWheelerParkingSpots;

    TwoWheelerParkingSpotManager(List<TwoWheelerParkingSpot> parkingSpots){
        twoWheelerParkingSpots = parkingSpots;
    }

}
