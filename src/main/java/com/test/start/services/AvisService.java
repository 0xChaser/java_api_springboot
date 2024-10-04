package com.test.start.services;

import java.util.List;

import com.test.start.dto.CreateAvis;
import com.test.start.models.Avis;
import com.test.start.models.Movie;
import com.test.start.repositories.AvisRepository;
import com.test.start.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvisService {

    private final AvisRepository avisRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public AvisService(AvisRepository avisRepository, MovieRepository movieRepository) {
        this.avisRepository = avisRepository;
        this.movieRepository = movieRepository;
    }

    public List<Avis> findAll() {
        return avisRepository.findAll();
    }

    public Avis findById(String id) {
        return avisRepository.findById(id).orElse(null);
    }

    public void create(CreateAvis createAvis) {
        Avis avis = new Avis();
        avis.setComment(createAvis.getComment());
        avis.setRating(createAvis.getRating());

        Movie movie = movieRepository.findById(createAvis.getMovieId()).orElseThrow(() -> new RuntimeException("Movie not found"));
        avis.setMovie(movie);

        avisRepository.save(avis);
    }

    public void delete(String id) {
        avisRepository.deleteById(id);
    }

    public void update(String id, Avis avis) {
        Avis updatedAvis = findById(id);
        updatedAvis.setComment(avis.getComment());
        updatedAvis.setRating(avis.getRating());
        avisRepository.save(updatedAvis);
    }
}