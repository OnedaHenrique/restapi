package com.restapi.restapi.dao;

import com.restapi.restapi.model.Ator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AtorDAOImpl implements AtorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Ator save(Ator ator) {
        if (ator.getId() == null) {
            entityManager.persist(ator);  // Cria novo ator
        } else {
            entityManager.merge(ator);  // Atualiza ator existente
        }
        return ator;
    }

    @Override
    public Optional<Ator> findById(Integer id) {
        Ator ator = entityManager.find(Ator.class, id);  // Busca ator pelo ID
        return Optional.ofNullable(ator);
    }

    @Override
    public List<Ator> findAll() {
        return entityManager.createQuery("SELECT a FROM Ator a", Ator.class)
                .getResultList();  // Retorna todos os atores
    }

    @Override
    public void deleteById(Integer id) {
        Ator ator = entityManager.find(Ator.class, id);
        if (ator != null) {
            entityManager.remove(ator);  // Remove ator pelo ID
        }
    }

    @Override
    public void update(Ator ator) {
        entityManager.merge(ator);  // Atualiza ator existente
    }
}
