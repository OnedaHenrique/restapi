package com.restapi.restapi.service;

import com.restapi.restapi.dao.FilmeDAO;
import com.restapi.restapi.model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeDAO filmeDAO;

    public Filme postFilme(Filme filme) {
        return filmeDAO.save(filme);
    }

    public Optional<Filme> getFilmeById(Integer id) {
        return filmeDAO.findById(id);
    }

    public List<Filme> getAllFilmes() {
        return filmeDAO.findAll();
    }

    public void deleteFilmeById(Integer id) {
        filmeDAO.deleteById(id);
    }

    public Filme updateFilme(Filme filme) {
        filmeDAO.update(filme);
        return filme;
    }
}
