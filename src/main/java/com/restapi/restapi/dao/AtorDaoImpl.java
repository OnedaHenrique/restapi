package com.restapi.restapi.dao;

import com.restapi.restapi.model.Ator;

import jakarta.persistence.EntityManager;

public class AtorDaoImpl implements AtorDAO{
    private EntityManager em;

    public void criar(Ator ator) {
        em.persist(ator);
    }

    public Ator buscar(Long id) {
        return em.find(Ator.class,id);
    }

    public void atualizar(Ator ator) {
        
    }
}
