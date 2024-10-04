package com.test.start.controlleur;

import com.test.start.dto.CreateCinema;
import com.test.start.models.Cinema;
import com.test.start.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping
    public ResponseEntity<List<Cinema>> findAll() {
        return new ResponseEntity<>(cinemaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cinema> findById(@PathVariable String id) {
        Cinema cinema = cinemaService.findById(id);
        if (cinema == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateCinema createCinema) {
        cinemaService.create(createCinema);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Cinema cinema) {
        if (cinemaService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cinemaService.update(id, cinema);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (cinemaService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cinemaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}