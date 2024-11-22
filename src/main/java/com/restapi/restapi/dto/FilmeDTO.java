package com.restapi.restapi.dto;

import java.util.List;

import com.restapi.restapi.model.Ator;
import com.restapi.restapi.model.Filme;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmeDTO {
    private Integer id;
    private String titulo;
    private int faixaEtaria;
    private String sinopse;
    private List<AtorDTO> atores; // Apenas os nomes dos atores

    // Converter de Filme (Model) para FilmeDTO
    public static FilmeDTO fromEntity(Filme filme) {
        FilmeDTO dto = new FilmeDTO();
        dto.setId(filme.getId());
        dto.setTitulo(filme.getTitulo());
        dto.setFaixaEtaria(filme.getFaixaEtaria());
        dto.setSinopse(filme.getSinopse());
        dto.setAtores(filme.getAtores() != null ? 
            filme.getAtores().stream().map(Ator::getNome).toList() : null);
        return dto;
    }

    // Converter de FilmeDTO para Filme (Model)
    public Filme toEntity() {
        Filme filme = new Filme();
        filme.setId(this.id);
        filme.setTitulo(this.titulo);
        filme.setFaixaEtaria(this.faixaEtaria);
        filme.setSinopse(this.sinopse);
        // Atores são ignorados na entrada
        return filme;
    }
}
