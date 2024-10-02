package com.test.start.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Acteur")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
 
    @Column(name="name", nullable=false)
    private String name;

    @Column(name="firstname")
    private String firstname;


    public Actor(String name, String firstname){
        this.name = name;
        this.firstname = firstname;
    }

    public Actor() {}

    public String getName(){
        return name;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setId(String id){
        this.id = id;
    }
}
