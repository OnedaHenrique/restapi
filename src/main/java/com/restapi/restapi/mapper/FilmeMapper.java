package com.restapi.restapi.mapper;

import java.util.stream.Collectors;

import com.restapi.restapi.dto.AtorDTO;
import com.restapi.restapi.dto.FilmeDTO;
import com.restapi.restapi.model.Filme;

public class FilmeMapper {

    public static FilmeDTO toFilmeDTO(Filme filme) {
        FilmeDTO filmeDTO = new FilmeDTO();
        filmeDTO.setId(filme.getId());
        filmeDTO.setTitulo(filme.getTitulo());
        filmeDTO.setFaixaEtaria(filme.getFaixaEtaria());
        filmeDTO.setSinopse(filme.getSinopse());
        filmeDTO.setAtores(
            filme.getAtores().stream()
                .map(ator -> {
                    AtorDTO atorDTO = new AtorDTO();
                    atorDTO.setId(ator.getId());
                    atorDTO.setNome(ator.getNome());
                    atorDTO.setIdade(ator.getIdade());
                    atorDTO.setNacionalidade(ator.getNacionalidade());
                    return atorDTO;
                })
                .collect(Collectors.toList())
        );
        return filmeDTO;
    }
}
