package com.restapi.restapi.dao;

import com.restapi.restapi.model.Ator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class AtorDAOImpl implements AtorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Ator save(Ator ator) {
        entityManager.persist(ator);
        return ator;
    }

    @Override
    public Optional<Ator> findByNome(String nome) {
        try {
            Ator ator = entityManager.createQuery(
                    "SELECT a FROM Ator a WHERE a.nome LIKE :nome", Ator.class)
                    .setParameter("nome", "%" + nome + "%")
                    .getSingleResult();
            return Optional.ofNullable(ator);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Ator> findById(Integer id) {
        Ator ator = entityManager.find(Ator.class, id);
        return Optional.ofNullable(ator);
    }

    @Override
    public List<Ator> findByNacio(String nacio) {
        return entityManager.createQuery(
                "SELECT a FROM Ator a WHERE a.nacionalidade LIKE :nacio", Ator.class)
                .setParameter("nacio", "%" + nacio + "%")
                .getResultList();
    }

    @Override
    public List<Ator> findAll() {
        return entityManager.createQuery("SELECT a FROM Ator a", Ator.class)
                .getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        Ator ator = entityManager.find(Ator.class, id);
        if (ator != null) {
            entityManager.remove(ator);
        }
    }

    @Override
    public void update(Ator ator) {
        entityManager.merge(ator);
    }
}
