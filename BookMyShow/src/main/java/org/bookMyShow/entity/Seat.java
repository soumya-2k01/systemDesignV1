package org.bookMyShow.entity;

import org.bookMyShow.enums.Status;

public interface Seat {
    double basePrice = 10.0;

    void setPrice();
    public Integer getId();

    public void setId(Integer id);

    public Double getPrice();

    public Status getStatus();

    public void setStatus(Status status);
}
