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

    @PostMapping("/create")
    public ResponseEntity<AtorDTO> createAtor(@RequestBody AtorDTO atorDTO) {
        Ator ator = atorDTO.toEntity();
        Ator createdAtor = atorService.postAtor(ator);
        return new ResponseEntity<>(AtorDTO.fromEntity(createdAtor), HttpStatus.CREATED);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<AtorDTO> getAtorByNome(@PathVariable String nome) {
        Optional<Ator> ator = atorService.getAtorByNome(nome);
        return ator.map(value -> ResponseEntity.ok(AtorDTO.fromEntity(value)))
        .orElseThrow(() -> new ResourceNotFoundException("Ator com o nome '" + nome + "' não foi encontrado."));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<AtorDTO> getAtorById(@PathVariable Integer id) {
        Optional<Ator> ator = atorService.getAtorById(id);
        return ator.map(value -> ResponseEntity.ok(AtorDTO.fromEntity(value)))
        .orElseThrow(() -> new ResourceNotFoundException("Ator com o id '" + id + "' não foi encontrado."));
    }

    @GetMapping("/nacio/{nacio}")
    public List<AtorDTO> getAtoresByNacionalidade(@PathVariable String nacio) {
        List<Ator> atores = atorService.getAtorByNacio(nacio);
        if (atores.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum ator encontrado com a nacionalidade '" + nacio + "'.");
        }
        return atores.stream().map(AtorDTO::fromEntity).toList();
    }
    

    @GetMapping
    public List<AtorDTO> getAllAtores() {
        List<Ator> atores = atorService.getAllAtores();
        return atores.stream()
                .map(AtorDTO::fromEntity)
                .toList();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAtor(@PathVariable Integer id) {
        atorService.deleteAtorById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AtorDTO> updateAtor(@PathVariable Integer id, @RequestBody AtorDTO atorDTO) {
        Ator ator = atorDTO.toEntity();
        ator.setId(id);
        Ator updatedAtor = atorService.updateAtor(ator);
        return ResponseEntity.ok(AtorDTO.fromEntity(updatedAtor));
    }
}
