package com.ambev.revenda.service;

import com.ambev.revenda.model.Revenda;
import com.ambev.revenda.repository.RevendaRepository;
import com.ambev.revenda.utils.CnpjValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RevendaService {
    @Autowired
    private RevendaRepository revendaRepository;

    @Autowired
    private CnpjValidator cnpjValidator;

    public Revenda salvar(Revenda revenda) {
        if (!cnpjValidator.isValid(revenda.getCnpj())) {
            throw new IllegalArgumentException("CNPJ inválido");
        }
        if (revendaRepository.existsByCnpj(revenda.getCnpj())) {
            throw new IllegalArgumentException("CNPJ já cadastrado");
        }
        return revendaRepository.save(revenda);
    }

    public List<Revenda> listarTodas() {
        return revendaRepository.findAll();
    }

    public Optional<Revenda> buscarPorId(Long id) {
        return revendaRepository.findById(id);
    }

    public void excluir(Long id) {
        revendaRepository.deleteById(id);
    }
}
