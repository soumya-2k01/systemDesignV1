package org.example.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import org.example.entity.Booking;
import org.example.entity.BookingStatus;
import org.example.entity.Session;
import org.example.entity.SessionType;
import org.example.entity.User;

public class BookingService {
    List<Booking> bookings;
    Queue<Booking> waitList;

    UserService userService;
    AdminService adminService;

    public BookingService(UserService userService) {
        bookings = new ArrayList<>();
        waitList = new LinkedList<>();
        this.userService = userService;
    }

    public Booking bookClass(User user, Session session) {
        userService.validateUserEligibility(user);
        adminService.validateSessionEligibility(session);
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setBookingDate(new Date());
        booking.setSession(session);
        if(session.getCurCapacity() >= session.getMaxCapacity()) {
            booking.setBookingStatus(BookingStatus.PENDING);
            waitList.offer(booking);
        }
        else {
            booking.setBookingStatus(BookingStatus.BOOKED);
            bookings.add(booking);
            session.setCurCapacity(session.getCurCapacity()+1);
        }
        return booking;
    }

    public void cancelClass(User user, Session session) {
        Booking booking = bookings.stream().filter(existingBookings ->
                        existingBookings.getUser().getId()==user.getId() && existingBookings.getSession().getId()== session.getId()).findFirst()
                .orElse(null);
        if(booking==null) {
            throw new RuntimeException("No such booking exists");
        }
        booking.setBookingStatus(BookingStatus.CANCELLED);
        session.setCurCapacity(session.getCurCapacity()-1);

        if(!waitList.isEmpty()) {
            Booking waitListBooking = waitList.poll();
            waitListBooking.setBookingStatus(BookingStatus.BOOKED);
            session.setCurCapacity(session.getCurCapacity()-1);
            bookings.add(waitListBooking);
        }

    }

    public List<Booking> getAllBookingByUser(User user) {
        return bookings.stream().filter(booking -> booking.getUser().getId() == user.getId()).collect(Collectors.toList());
    }

    public List<Booking> getAllBookingBySessionType(SessionType sessionType) {
        return bookings.stream().filter(booking -> booking.getSession().getSessionType().equals(sessionType)).collect(Collectors.toList());
    }

    public List<Booking> getAllBookingBySession(Session session) {
        return bookings.stream().filter(booking -> booking.getSession().getId() == session.getId()).collect(Collectors.toList());
    }


}
