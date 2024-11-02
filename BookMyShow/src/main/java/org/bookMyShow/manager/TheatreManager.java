package org.bookMyShow.manager;

import java.util.List;
import java.util.stream.Collectors;
import org.bookMyShow.entity.Theatre;
import org.bookMyShow.enums.Place;

public class TheatreManager {
    TheatreManager theatreManager;
    List<Theatre> theatres;

    TheatreManager() {

    }
    public synchronized TheatreManager getInstance() {
        if(theatreManager == null) {
            this.theatreManager = new TheatreManager();
        }
        return theatreManager;
    }

    public void addTheatres(List<Theatre> theatres) {
        this.theatres.addAll(theatres);
    }
    public List<Theatre> getTheatres() {
        return theatres;
    }
    public List<Theatre> getTheatres(Place place) {
        return theatres.stream().filter(theatre -> theatre.getPlace().equals(place)).collect(Collectors.toList());
    }

}
