package com.restapi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.model.Ator;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Integer> {
    
}
