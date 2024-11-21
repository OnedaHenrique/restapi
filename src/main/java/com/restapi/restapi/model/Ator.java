package com.restapi.restapi.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ator")
@Getter
@Setter
@ToString
public class Ator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_ator")
    private Integer id;

    @Column(name = "nm_ator")
    private String nome;

    @Column(name = "nr_idade")
    private int idade;

    @Column(name = "ds_nacionalidade")
    private String nacionalidade;

    @ManyToMany
    @JoinTable(name = "ator_filme",
                joinColumns = @JoinColumn(name = "cd_ator"),
                inverseJoinColumns = @JoinColumn(name = "cd_filme"))
    private List<Filme> filmes;
}
