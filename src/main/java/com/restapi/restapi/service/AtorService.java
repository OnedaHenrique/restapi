package com.restapi.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.restapi.model.Ator;
import com.restapi.restapi.repository.AtorRepository;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepo;

    public List<Ator> getAtores() {
        return atorRepo.findAll();
    }

    public Optional<Ator> getAtor(int id) {
        return atorRepo.findById(id);
    }

    public Ator postAtor(Ator ator) {
        return atorRepo.save(ator);
    }

    public void deleteAtor(int id) {
        atorRepo.deleteById(id);
    }

    public Ator updateAtor(Ator ator) {
        return atorRepo.save(ator);
    }
}
