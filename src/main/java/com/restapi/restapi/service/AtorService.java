package com.restapi.restapi.service;

import com.restapi.restapi.dao.AtorDAO;
import com.restapi.restapi.model.Ator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtorService {

    @Autowired
    private AtorDAO atorDAO;

    public Ator postAtor(Ator ator) {
        return atorDAO.save(ator);  // Chama o DAO para salvar o ator
    }

    public Optional<Ator> getAtorById(Integer id) {
        return atorDAO.findById(id);  // Chama o DAO para buscar ator pelo ID
    }

    public List<Ator> getAllAtores() {
        return atorDAO.findAll();  // Chama o DAO para buscar todos os atores
    }

    public void deleteAtorById(Integer id) {
        atorDAO.deleteById(id);  // Chama o DAO para deletar ator pelo ID
    }

    public Ator updateAtor(Ator ator) {
        atorDAO.update(ator);  // Chama o DAO para atualizar ator
                return ator;
    }
}
