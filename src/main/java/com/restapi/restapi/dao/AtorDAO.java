package com.restapi.restapi.dao;

import com.restapi.restapi.model.Ator;
import java.util.List;
import java.util.Optional;

public interface AtorDAO {
    Ator save(Ator ator);
    Optional<Ator> findById(Integer id);
    List<Ator> findAll();
    void deleteById(Integer id);
    void update(Ator ator);
}
