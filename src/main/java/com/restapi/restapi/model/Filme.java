package com.restapi.restapi.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "filme")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_filme")
    private Integer id;

    @Column(name = "nr_faixa_etaria")
    private int faixaEtaria;

    @Column(name = "nm_filme")
    private String titulo;

    @Column(name = "ds_sinopse")
    private String sinopse;

    @ManyToMany(mappedBy = "filmes")
    private List<Ator> atores;
}
