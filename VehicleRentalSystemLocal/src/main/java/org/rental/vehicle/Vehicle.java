package org.rental.vehicle;

public class Vehicle {
    String vehicleNo;
    VehicleType vehicleType;
    Boolean isBooked;
    Float basePrice;
    Boolean isActive;

    public Vehicle(String vehicleNo, VehicleType type, Boolean isBooked, Float price, Boolean isActive){
        this.vehicleNo = vehicleNo;
        this.vehicleType = type;
        this.isBooked = isBooked;
        this.basePrice = price;
        this.isActive = isActive;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float basePrice) {
        this.basePrice = basePrice;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
