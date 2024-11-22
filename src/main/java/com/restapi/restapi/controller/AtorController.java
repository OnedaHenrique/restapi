package com.restapi.restapi.controller;

import com.restapi.restapi.dto.AtorDTO;
import com.restapi.restapi.model.Ator;
import com.restapi.restapi.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    // POST: Criar um ator (recebendo e retornando AtorDTO)
    @PostMapping
    public ResponseEntity<AtorDTO> createAtor(@RequestBody AtorDTO atorDTO) {
        Ator ator = atorDTO.toEntity(); // Converter DTO para entidade
        Ator createdAtor = atorService.postAtor(ator);
        return new ResponseEntity<>(AtorDTO.fromEntity(createdAtor), HttpStatus.CREATED);
    }

    // GET: Buscar um ator pelo ID (retornando AtorDTO)
    @GetMapping("/{id}")
    public ResponseEntity<AtorDTO> getAtorById(@PathVariable Integer id) {
        Optional<Ator> ator = atorService.getAtorById(id);
        return ator.map(value -> ResponseEntity.ok(AtorDTO.fromEntity(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET: Buscar todos os atores (retornando lista de AtorDTO)
    @GetMapping
    public List<AtorDTO> getAllAtores() {
        List<Ator> atores = atorService.getAllAtores();
        return atores.stream()
                .map(AtorDTO::fromEntity) // Converter cada Ator para AtorDTO
                .toList();
    }

    // DELETE: Deletar um ator pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtor(@PathVariable Integer id) {
        atorService.deleteAtorById(id);
        return ResponseEntity.noContent().build();
    }

    // PUT: Atualizar um ator existente (recebendo e retornando AtorDTO)
    @PutMapping("/{id}")
    public ResponseEntity<AtorDTO> updateAtor(@PathVariable Integer id, @RequestBody AtorDTO atorDTO) {
        Ator ator = atorDTO.toEntity(); // Converter DTO para entidade
        ator.setId(id); // Garantir que o ID do ator seja atualizado corretamente
        Ator updatedAtor = atorService.updateAtor(ator);
        return ResponseEntity.ok(AtorDTO.fromEntity(updatedAtor)); // Retornar o ator atualizado como DTO
    }
}
