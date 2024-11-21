package com.restapi.restapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.restapi.dto.AtorDTO;
import com.restapi.restapi.mapper.AtorMapper;
import com.restapi.restapi.model.Ator;
import com.restapi.restapi.service.AtorService;

@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @GetMapping
    public List<AtorDTO> getAtores() {
        return atorService.getAtores().stream().map(AtorMapper::toAtorDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<AtorDTO> getAtor(@PathVariable int id) {
        return atorService.getAtor(id).map(AtorMapper::toAtorDTO);
    }

    @PostMapping
    public AtorDTO postAtor(@RequestBody Ator ator) {
        Ator atorSalvo = atorService.postAtor(ator);
        return AtorMapper.toAtorDTO(atorSalvo);
    }

    @DeleteMapping("/{id}")
    public void deleteAtor(@PathVariable int id) {
        atorService.deleteAtor(id);
    }
    
    @PutMapping("/{id}")
    public Ator updateAtor(@PathVariable int id, @RequestBody Ator ator) {
        ator.setId(id);
        return atorService.updateAtor(ator);
    }
}
