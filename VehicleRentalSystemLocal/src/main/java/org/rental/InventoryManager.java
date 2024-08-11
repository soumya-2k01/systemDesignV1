package org.rental;

import org.rental.vehicle.Vehicle;
import org.rental.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    List<Vehicle> vehicles;

    public InventoryManager(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles(){
        return vehicles;
    }
    public List<Vehicle> getVehicles(VehicleType type){
        List<Vehicle> vehicleListByType = new ArrayList<>();
        for(Vehicle vehicle: vehicles){
            if(vehicle.getVehicleType().equals(type))
                vehicleListByType.add(vehicle);
        }
        return vehicleListByType;
    }

}
