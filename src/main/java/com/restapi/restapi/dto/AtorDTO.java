package com.restapi.restapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.restapi.restapi.model.Ator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtorDTO {
    private Integer id;
    private String nome;
    private int idade;
    private String nacionalidade;
    private List<Object> filmes;

    public static AtorDTO fromEntity(Ator ator) {
        AtorDTO dto = new AtorDTO();
        dto.setId(ator.getId());
        dto.setNome(ator.getNome());
        dto.setIdade(ator.getIdade());
        dto.setNacionalidade(ator.getNacionalidade());
        dto.setFilmes(
            ator.getFilmes().stream()
                .map(filme -> filme.getTitulo())
                .collect(Collectors.toList())
);
        return dto;
    }

    public Ator toEntity() {
        Ator ator = new Ator();
        ator.setId(this.id);
        ator.setNome(this.nome);
        ator.setIdade(this.idade);
        ator.setNacionalidade(this.nacionalidade);
        return ator;
    }
}
