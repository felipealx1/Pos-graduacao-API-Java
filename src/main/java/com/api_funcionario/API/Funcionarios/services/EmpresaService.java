package com.api_funcionario.API.Funcionarios.services;

import com.api_funcionario.API.Funcionarios.model.Empresa;
import com.api_funcionario.API.Funcionarios.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa salvarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Optional<Empresa> buscarEmpresaPorId(int id) {
        return empresaRepository.findById(id);
    }

    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    public void deletarEmpresa(int id) {
        empresaRepository.deleteById(id);
    }

    public Empresa atualizarEmpresa(int id, Empresa empresaAtualizada) {
        return empresaRepository.findById(id)
                .map(empresa -> {
                    empresa.setNome(empresaAtualizada.getNome());
                    empresa.setEndereco(empresaAtualizada.getEndereco());
                    return empresaRepository.save(empresa);
                })
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada com o ID: " + id));
    }
}
