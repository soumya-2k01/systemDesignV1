package org.rental.payment;

public class DailyPricingStrategy implements PricingStrategy{
    @Override
    public Double calculatePrice(Reservation reservation) {
        Float basePrice = reservation.getVehicle().getBasePrice();
        long difference = reservation.till.getTime() - reservation.from.getTime();
        Integer hours = (int) (difference/(1000*60*60*24));
        return basePrice*hours*10.0;
    }
}
