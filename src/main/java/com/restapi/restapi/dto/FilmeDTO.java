package com.restapi.restapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmeDTO {
    private Integer id;
    private String titulo;
    private int faixaEtaria;
    private String sinopse;
    private List<AtorDTO> atores;
}
