package org.rental;

import org.rental.payment.Reservation;

public class User {
    Integer userId;
    String userName;
    Boolean verifiedLicense;
    Reservation reservation;

    public User(Integer id, String name, Boolean isVerified){
        this.userId = id;
        userName = name;
        verifiedLicense = isVerified;
        reservation = null;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getVerifiedLicense() {
        return verifiedLicense;
    }

    public void setVerifiedLicense(Boolean verifiedLicense) {
        this.verifiedLicense = verifiedLicense;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
