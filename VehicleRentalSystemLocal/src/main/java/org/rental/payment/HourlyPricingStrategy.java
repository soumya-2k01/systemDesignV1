package org.rental.payment;

public class HourlyPricingStrategy implements PricingStrategy{
    @Override
    public Double calculatePrice(Reservation reservation) {
        Float basePrice = reservation.getVehicle().getBasePrice();
        long difference = reservation.till.getTime() - reservation.from.getTime();
        Integer hours = (int) (difference/(1000*60*60));
        return basePrice*hours*0.25;
    }
}
