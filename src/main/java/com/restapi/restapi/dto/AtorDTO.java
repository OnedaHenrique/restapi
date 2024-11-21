package com.restapi.restapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtorDTO {
    private Integer id;
    private String nome;
    private int idade;
    private String nacionalidade;
    private List<FilmeDTO> filmes;
}
