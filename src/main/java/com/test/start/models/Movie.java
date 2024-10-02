package com.test.start.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
 
    @Column(name="name", nullable=false)
    private String name;

    @Column(name="duration")
    private String duration;


    public Movie(String name, String duration){
        this.name = name;
        this.duration = duration;
    }

    public Movie() {}

    public String getMovieName(){
        return name;
    }

    public String getMovieDuration(){
        return duration;
    }

    public String getId(){
        return id;
    }

    public void setMovieName(String name){
        this.name = name;
    }
    public void setMovieduration(String duration){
        this.duration = duration;
    }

    public void setId(String id){
        this.id = id;
    }
}

