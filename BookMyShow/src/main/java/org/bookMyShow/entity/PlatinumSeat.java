package org.bookMyShow.entity;

import org.bookMyShow.enums.Status;

public class PlatinumSeat implements Seat {
    private Integer id;
    private Double price;
    private Status status;
    static int counter = 1;
    public PlatinumSeat() {
        this.id = counter++;
        setPrice();
        this.status = Status.AVAILABLE;
    }

    @Override
    public void setPrice() {
        this.price = basePrice+40.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
