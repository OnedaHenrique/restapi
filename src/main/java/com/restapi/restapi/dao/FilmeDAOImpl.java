package com.restapi.restapi.dao;

import com.restapi.restapi.model.Filme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class FilmeDAOImpl implements FilmeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Filme save(Filme filme) {
            entityManager.persist(filme);
        return filme;
    }

    @Override
    public Optional<Filme> findById(Integer id) {
        Filme filme = entityManager.find(Filme.class, id);
        return Optional.ofNullable(filme);
    }

    @Override
    public List<Filme> findAll() {
        return entityManager.createQuery("SELECT f FROM Filme f", Filme.class)
                .getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        Filme filme = entityManager.find(Filme.class, id);
        if (filme != null) {
            entityManager.remove(filme);
        }
    }

    @Override
    public void update(Filme filme) {
        entityManager.merge(filme);
    }
}
