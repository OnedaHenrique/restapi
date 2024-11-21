package com.restapi.restapi.mapper;

import java.util.stream.Collectors;

import com.restapi.restapi.dto.AtorDTO;
import com.restapi.restapi.dto.FilmeDTO;
import com.restapi.restapi.model.Ator;

public class AtorMapper {

    public static AtorDTO toAtorDTO(Ator ator) {
        AtorDTO atorDTO = new AtorDTO();
        atorDTO.setId(ator.getId());
        atorDTO.setNome(ator.getNome());
        atorDTO.setIdade(ator.getIdade());
        atorDTO.setNacionalidade(ator.getNacionalidade());
        atorDTO.setFilmes(
            ator.getFilmes().stream()
                .map(filme -> {
                    FilmeDTO filmeDTO = new FilmeDTO();
                    filmeDTO.setId(filme.getId());
                    filmeDTO.setTitulo(filme.getTitulo());
                    filmeDTO.setFaixaEtaria(filme.getFaixaEtaria());
                    filmeDTO.setSinopse(filme.getSinopse());
                    return filmeDTO;
                })
                .collect(Collectors.toList())
        );
        return atorDTO;
    }
}
