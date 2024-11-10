package org.example;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.example.entity.Session;
import org.example.entity.SessionType;
import org.example.entity.Tier;
import org.example.entity.User;
import org.example.service.AdminService;
import org.example.service.BookingService;
import org.example.service.UserService;

public class Main {
    public static void main(String[] args) {
        AdminService admin = new AdminService();
        UserService userService = new UserService();
        BookingService bookingService = new BookingService(userService);

        User u1 = new User(1,"soumya", Tier.SILVER);
        User u2 = new User(2,"jaynit", Tier.GOLD);

        LocalDateTime startTime = LocalDateTime.now().plusDays(1);
        LocalDateTime endTime = LocalDateTime.now().plusDays(1).plusHours(1);
        Session session1 = new Session(1, SessionType.YOGA, 2, Date.from(startTime.toInstant(ZoneOffset.UTC)),
                Date.from(endTime.toInstant(ZoneOffset.UTC)));
        startTime = startTime.plusHours(3);
        endTime = endTime.plusHours(4);
        Session session2 = new Session(1, SessionType.YOGA, 2, Date.from(startTime.toInstant(ZoneOffset.UTC)),
                Date.from(endTime.toInstant(ZoneOffset.UTC)));

        String u1pass = userService.register(u1);
        userService.login(u1,"123");

        bookingService.bookClass(u1, session1);
        bookingService.bookClass(u2,session1);

    }
}