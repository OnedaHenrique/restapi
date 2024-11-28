package com.restapi.restapi.controller;

import com.restapi.restapi.dto.FilmeDTO;
import com.restapi.restapi.model.Filme;
import com.restapi.restapi.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping("/create")
    public ResponseEntity<FilmeDTO> createFilme(@RequestBody FilmeDTO filmeDTO) {
        Filme filme = filmeDTO.toEntity();
        Filme createdFilme = filmeService.postFilme(filme);
        return new ResponseEntity<>(FilmeDTO.fromEntity(createdFilme), HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<FilmeDTO> getFilmeById(@PathVariable Integer id) {
        Optional<Filme> filme = filmeService.getFilmeById(id);
        return filme
                .map(value -> ResponseEntity.ok(FilmeDTO.fromEntity(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<FilmeDTO> getAllFilmes() {
        return filmeService.getAllFilmes()
                .stream()
                .map(FilmeDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable Integer id) {
        filmeService.deleteFilmeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FilmeDTO> updateFilme(@PathVariable Integer id, @RequestBody FilmeDTO filmeDTO) {
        Filme filme = filmeDTO.toEntity();
        filme.setId(id);
        filmeService.updateFilme(filme);
        return ResponseEntity.ok(FilmeDTO.fromEntity(filme));
    }
}