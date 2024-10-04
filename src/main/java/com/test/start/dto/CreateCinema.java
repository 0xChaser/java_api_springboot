package com.test.start.dto;

import java.util.List;

public class CreateCinema {

    private String name;

    private String address;

    private List<String> movieIds;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getMovieIds() {
        return this.movieIds;
    }

    public void setMovieIds(List<String> movieIds) {
        this.movieIds = movieIds;
    }
}