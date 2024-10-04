package com.test.start.services;


import com.test.start.models.Actor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.start.repositories.ActorRepository;


@Service
public class ActorService {

    private final ActorRepository repository;

@Autowired
    public ActorService(ActorRepository repository){
        this.repository = repository;
    }

    public List<Actor> findAll(){
        return repository.findAll();
    }

    public Actor findById(String id){
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }

    public void create(Actor actor){
        repository.save(actor);
    }

    public void update(String id, Actor actor){
        Actor updatedActor = findById(id);
        updatedActor.setName(actor.getName());
        updatedActor.setFirstname(actor.getFirstname());
        repository.save(updatedActor);
    }
}
