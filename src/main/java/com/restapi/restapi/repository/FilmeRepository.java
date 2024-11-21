package com.restapi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    
}
