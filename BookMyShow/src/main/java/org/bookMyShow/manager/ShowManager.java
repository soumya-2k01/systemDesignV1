package org.bookMyShow.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bookMyShow.entity.Movie;
import org.bookMyShow.entity.Show;
import org.bookMyShow.entity.Theatre;
import org.bookMyShow.entity.TimeSlot;

public class ShowManager {
    static ShowManager showManager;
    TheatreManager theatreManager;
    List<Show> shows;


    ShowManager() {
        this.shows = new ArrayList<>();
    }
    public static synchronized ShowManager getInstance() {
        if(showManager == null) {
            showManager = new ShowManager();
        }

        return showManager;
    }

    public Show createShow(Theatre theatre, Movie movie, LocalDateTime startTime) {
        TimeSlot timeSlot = new TimeSlot(startTime, startTime.plusHours(movie.getDuration()));
        if(isAvailable(theatre, timeSlot)) {
            Show show = new Show(movie, timeSlot, theatre.getCapacity());
            shows.add(show);
            theatre.addShows(Arrays.asList(show));
            return show;
        }
        else {
            System.out.println("Show timings clash with another show");
        }
        return null;
    }

    public boolean isAvailable(Theatre theatre, TimeSlot slot) {
        for(Show show: theatre.getShows()) {
            if(slot.getEndTime().isAfter(show.getTimeSlot().getStartTime()) &&
                    slot.getStartTime().isBefore(show.getTimeSlot().getEndTime())) {
                return false;
            }
        }
        return true;
    }
}
