package org.rental.payment;

public interface PricingStrategy {
    Double calculatePrice(Reservation reservation);
}
