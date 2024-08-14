package com.api_funcionario.API.Funcionarios.services;

import com.api_funcionario.API.Funcionarios.model.Funcionario;
import com.api_funcionario.API.Funcionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> buscarFuncionarioPorId(int id) {
        return funcionarioRepository.findById(id);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public void deletarFuncionario(int id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario atualizarFuncionario(int id, Funcionario funcionarioAtualizado) {
        return funcionarioRepository.findById(id)
                .map(funcionario -> {
                    funcionario.setNome(funcionarioAtualizado.getNome());
                    funcionario.setCargo(funcionarioAtualizado.getCargo());
                    funcionario.setSalario(funcionarioAtualizado.getSalario());
                    funcionario.setEndereco(funcionarioAtualizado.getEndereco());
                    return funcionarioRepository.save(funcionario);
                })
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + id));
    }

}
