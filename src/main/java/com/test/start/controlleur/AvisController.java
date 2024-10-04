package com.test.start.controlleur;

import com.test.start.dto.CreateAvis;
import com.test.start.models.Avis;
import com.test.start.services.AvisService;
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
@RequestMapping("/avis")
public class AvisController {

    private final AvisService avisService;

    @Autowired
    public AvisController(AvisService avisService) {
        this.avisService = avisService;
    }

    @GetMapping
    public ResponseEntity<List<Avis>> findAll() {
        return new ResponseEntity<>(avisService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avis> findById(@PathVariable String id) {
        Avis avis = avisService.findById(id);
        if (avis == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(avis, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateAvis createAvis) {
        avisService.create(createAvis);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Avis avis) {
        if (avisService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        avisService.update(id, avis);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (avisService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        avisService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}