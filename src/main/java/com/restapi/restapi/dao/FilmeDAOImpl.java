package com.restapi.restapi.dao;

import com.restapi.restapi.model.Filme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FilmeDAOImpl implements FilmeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Filme save(Filme filme) {
        if (filme.getId() == null) {
            entityManager.persist(filme);  // Cria novo filme
        } else {
            entityManager.merge(filme);  // Atualiza filme existente
        }
        return filme;
    }

    @Override
    public Optional<Filme> findById(Integer id) {
        Filme filme = entityManager.find(Filme.class, id);  // Busca filme pelo ID
        return Optional.ofNullable(filme);
    }

    @Override
    public List<Filme> findAll() {
        return entityManager.createQuery("SELECT f FROM Filme f", Filme.class)
                .getResultList();  // Retorna todos os filmes
    }

    @Override
    public void deleteById(Integer id) {
        Filme filme = entityManager.find(Filme.class, id);
        if (filme != null) {
            entityManager.remove(filme);  // Remove filme pelo ID
        }
    }

    @Override
    public void update(Filme filme) {
        entityManager.merge(filme);  // Atualiza filme existente
    }
}
