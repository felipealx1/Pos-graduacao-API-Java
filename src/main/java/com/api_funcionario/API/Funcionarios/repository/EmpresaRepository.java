package com.api_funcionario.API.Funcionarios.repository;

import com.api_funcionario.API.Funcionarios.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
