package com.test.start.models;

import jakarta.persistence.*;

@Entity
@Table(name = "avis")
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "rating", nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    public Avis() {}

    public Avis(String comment, int rating, Movie movie) {
        this.comment = comment;
        this.rating = rating;
        this.movie = movie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}