package com.restapi.restapi.controller;

import com.restapi.restapi.model.Filme;
import com.restapi.restapi.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    public ResponseEntity<Filme> createFilme(@RequestBody Filme filme) {
        Filme createdFilme = filmeService.postFilme(filme);
        return new ResponseEntity<>(createdFilme, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getFilmeById(@PathVariable Integer id) {
        Optional<Filme> filme = filmeService.getFilmeById(id);
        return filme.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Filme> getAllFilmes() {
        return filmeService.getAllFilmes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable Integer id) {
        filmeService.deleteFilmeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> updateFilme(@PathVariable Integer id, @RequestBody Filme filme) {
        filme.setId(id);  // Define o ID para garantir a consistência
        filmeService.updateFilme(filme);
        return ResponseEntity.ok(filme);
    }
}
