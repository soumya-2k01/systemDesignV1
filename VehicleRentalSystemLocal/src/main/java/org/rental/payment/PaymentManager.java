package org.rental.payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.rental.User;

public class PaymentManager {
    List<Bill> bills;
    public PaymentManager(){
        this.bills = new ArrayList<>();
    }
    public Bill generateBill(User user, PricingStrategy pricingStrategy){
        Bill bill = new Bill();
        bill.setId("BX"+new Random().nextInt(1000));
        bill.isPaid = false;
        bill.setUser(user);
        bill.setFrom(user.getReservation().getFrom());
        bill.setTo(user.getReservation().getTill());
        bill.setVehicle(user.getReservation().getVehicle());
        bill.setAmount(pricingStrategy.calculatePrice(user.getReservation()));
        bills.add(bill);
        return bill;
    }

    public void clearBill(Bill bill){
        if(bill.getIsPaid()){
            System.out.println("Bill already paid!");
            return;
        }
        bill.setIsPaid(true);
        System.out.println("Bill paid successfully");
    }

    public Bill fetchBill(User user){
        for(Bill bill: bills){
            if(bill.getUser().getUserId().equals(user.getUserId())){
                return bill;
            }
        }
        System.out.println("No bill found for the user "+ user.getUserName());
        return null;
    }
}
