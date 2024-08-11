package ParkingSpots;
import Vehicle.Vehicle;

public class TwoWheelerParkingSpot implements ParkingSpot {
    private String spotId;
    private boolean isEmpty;
    private Vehicle vehicle;
    private double basePrice;

    static int idCounter = 1;

    TwoWheelerParkingSpot(){
        this.spotId = "tw"+(idCounter++);
        this.isEmpty = true;
        this.vehicle = null;
        this.basePrice = 10;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public String parkVehicle(Vehicle vehicle) {
        this.isEmpty = false;
        this.vehicle = vehicle;
        return spotId;
    }

    @Override
    public Vehicle removeVehicle() {
        this.isEmpty = true;
        Vehicle vehicle = this.vehicle;
        this.vehicle = null;
        return vehicle;
    }
}
