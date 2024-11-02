package org.bookMyShow.manager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.bookMyShow.entity.Seat;
import org.bookMyShow.entity.Show;
import org.bookMyShow.enums.Status;

public class BookingManager {

    public void bookSeats(Show show, List<Seat> seatList) {
        List<Seat> seat1 = show.getAvailableSeats();
        Set<Seat> seats = new HashSet<>(seat1);
        for(Seat seat: seatList) {
            if(!seats.contains(seat)) {
                System.out.println("Seat " + seat.getId() + "is not available for booking");
                return;
            }
            seat.setStatus(Status.BOOKED);
        }
        show.seats = seat1;
        generateTicket();
    }

    public void generateTicket() {

    }

}
