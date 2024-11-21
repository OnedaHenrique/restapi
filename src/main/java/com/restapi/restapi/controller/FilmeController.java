package com.restapi.restapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.restapi.dto.FilmeDTO;
import com.restapi.restapi.mapper.FilmeMapper;
import com.restapi.restapi.model.Filme;
import com.restapi.restapi.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService FilmeService;

    @GetMapping
    public List<FilmeDTO> getFilmes() {
        return FilmeService.getFilmes().stream()
            .map(FilmeMapper::toFilmeDTO)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<FilmeDTO> getFilme(@PathVariable int id) {
        return FilmeService.getFilme(id).map(FilmeMapper::toFilmeDTO);
    }

    @PostMapping
    public FilmeDTO postFilme(@RequestBody Filme filme) {
        Filme filmeSalvo = FilmeService.postFilme(filme);
        return FilmeMapper.toFilmeDTO(filmeSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtor(@PathVariable int id) {
        FilmeService.deleteFilme(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public Filme updateAtor(@PathVariable int id, @RequestBody Filme filme) {
        filme.setId(id);
        return FilmeService.updateFilme(filme);
    }
}
