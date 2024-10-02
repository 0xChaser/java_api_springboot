package com.test.start.controlleur;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.start.models.Actor;
import com.test.start.services.ActorService;

@RestController
@RequestMapping("/actors")
public class ActorController {
    
    private final ActorService service;

    @Autowired
    public ActorController(ActorService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Actor>>findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> findById(@PathVariable String id){
        Actor actor = service.findById(id);
        if(actor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Actor actor){
        service.create(actor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        Actor actor = service.findById(id);
        if(actor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
