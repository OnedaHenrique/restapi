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
public class AtorDTO {
    private Integer id;
    private String nome;
    private int idade;
    private String nacionalidade;
    private List<FilmeDTO> filmes; // Apenas os títulos dos filmes

    // Converter de Ator (Model) para AtorDTO
    public static AtorDTO fromEntity(Ator ator) {
        AtorDTO dto = new AtorDTO();
        dto.setId(ator.getId());
        dto.setNome(ator.getNome());
        dto.setIdade(ator.getIdade());
        dto.setNacionalidade(ator.getNacionalidade());
        dto.setFilmes(ator.getFilmes() != null ? 
            ator.getFilmes().stream().map(Filme::getTitulo).toList() : null);
        return dto;
    }

    // Converter de AtorDTO para Ator (Model)
    public Ator toEntity() {
        Ator ator = new Ator();
        ator.setId(this.id);
        ator.setNome(this.nome);
        ator.setIdade(this.idade);
        ator.setNacionalidade(this.nacionalidade);
        // Filmes são ignorados na entrada
        return ator;
    }
}
