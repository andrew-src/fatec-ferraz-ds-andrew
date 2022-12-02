package com.exercicio.exercicio.Model;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity

public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projeto_generator")
    private Long id;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 100, nullable = false)
    private String descricao ;

    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    private Date dataFim;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double valorPrevisto;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double valorGasto;

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    },
    mappedBy = "projetos")
    @JsonIgnore
    private Set <Funcionario> funcionarios = new HashSet<>();
}