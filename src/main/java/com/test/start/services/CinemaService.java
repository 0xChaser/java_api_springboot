package com.test.start.services;

import java.util.List;

import com.test.start.dto.CreateCinema;
import com.test.start.models.Cinema;
import com.test.start.models.Movie;
import com.test.start.repositories.CinemaRepository;
import com.test.start.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository, MovieRepository movieRepository) {
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
    }

    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    public Cinema findById(String id) {
        return cinemaRepository.findById(id).orElse(null);
    }

    public void create(CreateCinema createCinema) {
        Cinema cinema = new Cinema();
        cinema.setName(createCinema.getName());
        cinema.setAddress(createCinema.getAddress());

        List<Movie> movies = movieRepository.findAllById(createCinema.getMovieIds());
        cinema.setMovies(movies);

        cinemaRepository.save(cinema);
    }

    public void delete(String id) {
        cinemaRepository.deleteById(id);
    }

    public void update(String id, Cinema cinema) {
        Cinema updatedCinema = findById(id);
        updatedCinema.setName(cinema.getName());
        updatedCinema.setAddress(cinema.getAddress());
        cinemaRepository.save(updatedCinema);
    }
}