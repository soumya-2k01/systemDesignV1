package org.rental.store;

import java.util.Date;
import org.rental.Location;
import org.rental.User;
import org.rental.payment.Bill;
import org.rental.payment.HourlyPricingStrategy;
import org.rental.payment.PaymentManager;
import org.rental.payment.PricingStrategy;
import org.rental.payment.Reservation;
import org.rental.payment.Status;
import org.rental.vehicle.Vehicle;
import org.rental.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StoreManager {
    List<Store> stores;
    PaymentManager paymentManager;

    public StoreManager(List<Store> stores){
        this.stores = stores;
        this.paymentManager = new PaymentManager();
    }

    public void addStore(Store store){
        stores.add(store);
    }
    public List<Store> getStores(){
        return stores;
    }

    public List<Store> getStores(Location location){
        List<Store> storesByLocation = new ArrayList<>();
        for(Store store: stores){
            if(Objects.equals(store.location.getId(), location.getId())){
                storesByLocation.add(store);
            }
        }
        return storesByLocation;
    }

    public List<Vehicle> getVehicleList(Store store){
        return store.getVehicles();
    }
    public List<Vehicle> getVehicleList(Store store, VehicleType type){
        return store.getVehicles(type);
    }

    public void reserveVehicle(User user,  Vehicle vehicle, Date from, Date to) throws Exception {
        if(!user.getVerifiedLicense()) throw new Exception("License not verified");
        if(vehicle.getActive() && !vehicle.getBooked()){
            Reservation reservation = new Reservation();
            reservation.setVehicle(vehicle);
            reservation.setFrom(from);
            reservation.setTill(to);
            reservation.setStatus(Status.SCHEDULED);
            reservation.setBookingDate(new Date());
            vehicle.setBooked(true);
            user.setReservation(reservation);
            System.out.println("Vehicle booked successfully");
        }
        else throw new Exception("Vehicle is not available for booking");
    }

    public void pickUpVehicle(User user, Vehicle vehicle) throws Exception {
        if(user.getReservation() == null) throw new Exception("No reservation found");
        if(user.getReservation().getStatus() == Status.SCHEDULED && user.getReservation().getVehicle().getVehicleNo().equals(vehicle.getVehicleNo())){
            user.getReservation().setStatus(Status.INPROGRESS);
            System.out.println("Vehicle picked up successfully");
        }
        else throw new Exception("Vehicle cannot be picked up");
    }

    public void dropVehicle(User user, Vehicle vehicle, PricingStrategy pricingStrategy) throws Exception {
        if(user.getReservation()==null || user.getReservation().getVehicle() != vehicle)
            throw new Exception("No reservation found for the vehicle");
        if(user.getReservation().getStatus()!=Status.INPROGRESS){
            throw new Exception("Vehicle has not been picked up yet");
        }
        Bill bill = paymentManager.fetchBill(user);
        if(Objects.isNull(bill)) {
            bill = paymentManager.generateBill(user, pricingStrategy);
        }
        System.out.println("your due bill is " + bill.getAmount());
        paymentManager.clearBill(bill);
        vehicle.setBooked(false);
        user.getReservation().setStatus(Status.COMPLETED);
    }

}
