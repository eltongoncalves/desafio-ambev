package com.ambev.revenda.service;

import com.ambev.revenda.controller.dto.ItemPedidoRequest;
import com.ambev.revenda.controller.mapper.PedidoClienteMapper;
import com.ambev.revenda.integration.PedidoFornecedorRequest;
import com.ambev.revenda.integration.PedidoFornecedorResponse;
import com.ambev.revenda.integration.SolicitacaoRevendaClient;
import com.ambev.revenda.model.ItemPedido;
import com.ambev.revenda.model.PedidoCliente;
import com.ambev.revenda.model.Revenda;
import com.ambev.revenda.repository.RevendaRepository;
import com.ambev.revenda.utils.CnpjValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RevendaService {

    private final RevendaRepository revendaRepository;
    private final CnpjValidator cnpjValidator;


    public RevendaService(RevendaRepository revendaRepository,
                          CnpjValidator cnpjValidator,
                          PedidoClienteMapper pedidoClienteMapper) {
        this.revendaRepository = revendaRepository;
        this.cnpjValidator = cnpjValidator;

    }

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
