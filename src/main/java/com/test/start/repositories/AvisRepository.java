package com.test.start.repositories;

import com.test.start.models.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisRepository extends JpaRepository<Avis, String> {
}