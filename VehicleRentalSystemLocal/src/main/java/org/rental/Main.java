package org.rental;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.rental.payment.DailyPricingStrategy;
import org.rental.payment.HourlyPricingStrategy;
import org.rental.store.Store;
import org.rental.vehicle.Vehicle;
import org.rental.vehicle.VehicleType;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Store> stores = new ArrayList<>();
        List<Vehicle> vehicleList1 = getVehicleList1();
        List<Vehicle> vehicleList2 = getVehicleList2();
        Store store1 = new Store(1, new Location(1, "Banglore"), new InventoryManager(vehicleList1));
        Store store2 = new Store(2, new Location(2, "Jaipur"), new InventoryManager(vehicleList2));
        stores.add(store1);
        stores.add(store2);
        CarRentalSystem rentalSystem = new CarRentalSystem(stores);
        rentalSystem.addUser(new User(1, "Sg", true));
        rentalSystem.addUser(new User(2, "Sam", true));

        System.out.println(rentalSystem.storeManager.getVehicleList(store1).toString());
        List<Vehicle> query2 = rentalSystem.storeManager.getVehicleList(store2, VehicleType.CAR);

        User u1 = rentalSystem.users.get(0);
        User u2 = rentalSystem.users.get(1);

        rentalSystem.storeManager.reserveVehicle(u1, query2.get(0), new Date(System.currentTimeMillis() + 48 * 60 * 60 * 1000),
                new Date(System.currentTimeMillis() + 96 * 60 * 60 * 1000));

        rentalSystem.storeManager.reserveVehicle(u2, query2.get(1), new Date(System.currentTimeMillis() + 48 * 60 * 60 * 1000),
                new Date(System.currentTimeMillis() + 96 * 60 * 60 * 1000));

        rentalSystem.storeManager.pickUpVehicle(u1, query2.get(0));
        rentalSystem.storeManager.dropVehicle(u1,query2.get(0), new HourlyPricingStrategy());
        rentalSystem.storeManager.dropVehicle(u2,query2.get(1), new DailyPricingStrategy());
        rentalSystem.storeManager.pickUpVehicle(u2, query2.get(1));
    }

    public static List<Vehicle> getVehicleList1() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("V1", VehicleType.CAR, false, 50.0f, true));
        vehicles.add(new Vehicle("V2", VehicleType.BIKE, false, 25.0f, true));
        vehicles.add(new Vehicle("V3", VehicleType.CAR, false, 60.0f, true));
        vehicles.add(new Vehicle("V4", VehicleType.BIKE, false, 20.0f, true));
        return vehicles;
    }

    public static List<Vehicle> getVehicleList2() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("V5", VehicleType.CAR, false, 70.0f, true));
        vehicles.add(new Vehicle("V6", VehicleType.BIKE, false, 35.0f, true));
        vehicles.add(new Vehicle("V7", VehicleType.CAR, false, 80.0f, true));
        vehicles.add(new Vehicle("V8", VehicleType.BIKE, false, 30.0f, true));
        return vehicles;
    }
}