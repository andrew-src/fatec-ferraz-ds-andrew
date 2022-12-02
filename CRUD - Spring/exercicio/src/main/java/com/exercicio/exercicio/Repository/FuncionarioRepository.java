package com.exercicio.exercicio.Repository;

import com.exercicio.exercicio.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
}
