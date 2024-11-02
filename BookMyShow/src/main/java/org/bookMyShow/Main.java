package org.bookMyShow;

import java.awt.print.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bookMyShow.entity.Movie;
import org.bookMyShow.entity.Seat;
import org.bookMyShow.entity.Show;
import org.bookMyShow.entity.Theatre;
import org.bookMyShow.entity.TimeSlot;
import org.bookMyShow.enums.Place;
import org.bookMyShow.manager.BookingManager;
import org.bookMyShow.manager.ShowManager;

public class Main {
    public static void main(String[] args) {
        Theatre t1 = new Theatre("t1", Place.JAIPUR, 6);
        Theatre t2 = new Theatre("t2", Place.PUNE, 9);
        Theatre t3 = new Theatre("t3", Place.JAIPUR, 3);

        Movie m1 = new Movie("ABCD", 2l);
        Movie m2 = new Movie("JMT", 3l);
        Movie m3 = new Movie("KEB", 1l);
        Movie m4 = new Movie("PGA", 2l);
        Movie m5 = new Movie("Asjqw", 3l);

        ShowManager showManager = ShowManager.getInstance();
        Show s1 = showManager.createShow(t1,m1,LocalDateTime.now().plusHours(2));
        Show s2 = showManager.createShow(t1,m2,LocalDateTime.now().plusHours(6));
        BookingManager bookingManager = new BookingManager();
        List<Seat> seatList = s1.getAvailableSeats();
        List<Seat> booking1 = new ArrayList<>();
        booking1.add(seatList.get(0));
        booking1.add(seatList.get(2));
        bookingManager.bookSeats(s1,booking1);
        System.out.println(s1.getAvailableSeats());
        bookingManager.bookSeats(s1,booking1);


    }
}