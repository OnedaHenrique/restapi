package com.restapi.restapi.service;

import com.restapi.restapi.dao.AtorDAO;
import com.restapi.restapi.model.Ator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AtorService {

    @Autowired
    private AtorDAO atorDAO;

    public Ator postAtor(Ator ator) {
        return atorDAO.save(ator);
    }

    public Optional<Ator> getAtorById(Integer id) {
        return atorDAO.findById(id);
    }

    public List<Ator> getAllAtores() {
        return atorDAO.findAll();
    }

    @Transactional
    public void deleteAtorById(Integer id) {
        atorDAO.deleteById(id);
    }

    @Transactional
    public Ator updateAtor(Ator ator) {
        atorDAO.update(ator);
                return ator;
    }
}
