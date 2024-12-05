package com.restapi.restapi.service;

import com.restapi.restapi.dao.FilmeDAO;
import com.restapi.restapi.model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Optional<Filme> getFilmeByTitulo(String titulo) {
        return filmeDAO.findByTitulo(titulo);
    }

    public List<Filme> getAllFilmes() {
        return filmeDAO.findAll();
    }

    public List<Filme> getFilmeByIdade(Integer idade) {
        return filmeDAO.findByIdade(idade);
    }

    @Transactional
    public void deleteFilmeById(Integer id) {
        filmeDAO.deleteById(id);
    }

    @Transactional
    public Filme updateFilme(Filme filme) {
        filmeDAO.update(filme);
        return filme;
    }
}
