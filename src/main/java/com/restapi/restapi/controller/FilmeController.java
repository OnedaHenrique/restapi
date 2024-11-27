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

    @PostMapping
    public ResponseEntity<FilmeDTO> createFilme(@RequestBody FilmeDTO filmeDTO) {
        Filme filme = filmeDTO.toEntity(); // Converte DTO para entidade
        Filme createdFilme = filmeService.postFilme(filme); // Salva no banco
        return new ResponseEntity<>(FilmeDTO.fromEntity(createdFilme), HttpStatus.CREATED); // Retorna como DTO
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeDTO> getFilmeById(@PathVariable Integer id) {
        Optional<Filme> filme = filmeService.getFilmeById(id);
        return filme
                .map(value -> ResponseEntity.ok(FilmeDTO.fromEntity(value))) // Converte para DTO
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<FilmeDTO> getAllFilmes() {
        return filmeService.getAllFilmes()
                .stream()
                .map(FilmeDTO::fromEntity) // Converte todos para DTO
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable Integer id) {
        filmeService.deleteFilmeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeDTO> updateFilme(@PathVariable Integer id, @RequestBody FilmeDTO filmeDTO) {
        Filme filme = filmeDTO.toEntity(); // Converte DTO para entidade
        filme.setId(id); // Garante que o ID seja consistente
        filmeService.updateFilme(filme); // Atualiza no banco
        return ResponseEntity.ok(FilmeDTO.fromEntity(filme)); // Retorna como DTO
    }
}
