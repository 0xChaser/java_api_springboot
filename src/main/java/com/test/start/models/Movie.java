package com.test.start.models;

import com.test.start.global.Category;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @ManyToMany(mappedBy = "movies")
    private List<Cinema> cinemas;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Avis> avis;

    public Movie() {}

    public Movie(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }
}