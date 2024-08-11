package org.rental.payment;

import java.util.Date;
import org.rental.User;
import org.rental.vehicle.Vehicle;

public class Bill {
    String id;
    User user;
    Date from;
    Date to;
    Double amount;
    Vehicle vehicle;
    Boolean isPaid;

    public Bill() {
    }

    public Bill(String id, User user, Date from, Date to, Double amount, Vehicle vehicle, Boolean isPaid) {
        this.id = id;
        this.user = user;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.vehicle = vehicle;
        this.isPaid = isPaid;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean paid) {
        isPaid = paid;
    }
}
