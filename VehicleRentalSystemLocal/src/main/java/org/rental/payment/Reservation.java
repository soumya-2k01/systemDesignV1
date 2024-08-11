package org.rental.payment;

import java.util.Date;
import org.rental.vehicle.Vehicle;

public class Reservation {
    static Integer id = 0;
    Status status;
    Vehicle vehicle;
    Date bookingDate;
    Date from;
    Date till;

    public Reservation(){
        id++;
    }
    public Integer getId() {
        return id;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTill() {
        return till;
    }

    public void setTill(Date till) {
        this.till = till;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
