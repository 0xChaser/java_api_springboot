package com.test.start.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.start.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    
}

