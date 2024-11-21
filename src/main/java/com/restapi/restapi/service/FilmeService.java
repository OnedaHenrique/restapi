package com.restapi.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.restapi.dao.FilmeRepository;
import com.restapi.restapi.model.Filme;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepo;

    public List<Filme> getFilmes() {
        return filmeRepo.findAll();
    }

    public Optional<Filme> getFilme(int id) {
        return filmeRepo.findById(id);
    }
    
    public Filme postFilme(Filme filme) {
        return filmeRepo.save(filme);
    }

    public void deleteFilme(int id) {
        filmeRepo.deleteById(id);
    }

    public Filme updateFilme(Filme filme) {
        return filmeRepo.save(filme);
    }
}
