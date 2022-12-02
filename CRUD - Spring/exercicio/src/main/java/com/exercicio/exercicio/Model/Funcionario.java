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

public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_generator")
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;

    @Column(columnDefinition = "DECIMAL(8,2)")
    private Double salario; 

    @Column(length = 20, nullable = false)
    private String celular;

    @Column(length = 100, nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, 
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
            })
        @JoinTable(name = "funcionario_projeto",
            joinColumns = {@JoinColumn(name = "Funcionario_id")},
            inverseJoinColumns = {@JoinColumn(name = "Projeto_id")})
        @JsonIgnore
    private Set <Projeto> projetos = new HashSet<>();
}