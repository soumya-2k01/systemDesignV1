package org.bookMyShow.entity;

import java.util.ArrayList;
import java.util.List;
import org.bookMyShow.enums.Place;

public class Theatre {
    Integer id;
    String name;
    Place place;

    Integer capacity;
    List<Show> shows;

    static int counter = 1;

    public Theatre(String name, Place place, Integer capacity) {
        this.id = counter++;
        this.name = name;
        this.place = place;
        this.capacity = capacity;
        this.shows = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
    public void addShows(List<Show> shows) {
        this.shows.addAll(shows);
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
