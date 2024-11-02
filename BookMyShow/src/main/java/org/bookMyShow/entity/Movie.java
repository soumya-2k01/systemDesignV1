package org.bookMyShow.entity;

public class Movie {
    Integer id;
    String name;
    Long duration;

    static int counter = 1;

    public Movie(String name, Long duration) {
        this.id = counter++;
        this.name = name;
        this.duration = duration;
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

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Movie.counter = counter;
    }
}
