package com.restapi.restapi.dao;

import com.restapi.restapi.model.Filme;
import java.util.List;
import java.util.Optional;

public interface FilmeDAO {
    Filme save(Filme filme);
    Optional<Filme> findById(Integer id);
    Optional<Filme> findByTitulo(String titulo);
    List<Filme> findAll();
    void deleteById(Integer id);
    void update(Filme filme);
    List<Filme> findByIdade(Integer ano);
}
