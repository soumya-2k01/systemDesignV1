package org.bookMyShow.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.bookMyShow.enums.Status;

public class Show {
    Integer id;
    Movie movie;
    TimeSlot timeSlot;
    public List<Seat> seats;

    static int counter = 1;

    public Show(Movie movie, TimeSlot timeSlot, Integer cap) {
        this.id = counter++;
        this.movie = movie;
        this.timeSlot = timeSlot;
        this.seats = setSeats(cap);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public List<Seat> setSeats(int cap) {
        List<Seat> seatList = new ArrayList<>();
        for(int i=0; i<cap/3; i++) {
            Seat s1 = new GoldSeat();
            Seat s2 = new PlatinumSeat();
            Seat s3 = new SilverSeat();
            seatList.add(s1);
            seatList.add(s2);
            seatList.add(s3);
        }
        return seatList;
    }

    public List<Seat> getAvailableSeats() {
        return seats.stream().filter(seat -> seat.getStatus().equals(Status.AVAILABLE)).collect(Collectors.toList());
    }
}
