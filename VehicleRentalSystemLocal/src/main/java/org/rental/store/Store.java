package org.rental.store;

import org.rental.Location;
import org.rental.InventoryManager;
import org.rental.vehicle.Vehicle;
import org.rental.vehicle.VehicleType;

import java.util.List;

public class Store {
    Integer id;
    Location location;
    InventoryManager vehicleInventoryManager;

    public Store(Integer id, Location location, InventoryManager inventoryManager){
        this.id = id;
        this.location = location;
        this.vehicleInventoryManager = inventoryManager;
    }

    public List<Vehicle> getVehicles(){
        return vehicleInventoryManager.getVehicles();
    }

    public List<Vehicle> getVehicles(VehicleType type){
        return vehicleInventoryManager.getVehicles(type);
    }


}
