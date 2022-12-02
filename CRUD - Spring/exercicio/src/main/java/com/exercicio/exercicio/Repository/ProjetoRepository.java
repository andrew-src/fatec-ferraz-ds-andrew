package com.exercicio.exercicio.Repository;

import com.exercicio.exercicio.Model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
    
}