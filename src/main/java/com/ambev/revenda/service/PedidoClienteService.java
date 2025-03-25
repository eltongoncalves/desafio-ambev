package com.ambev.revenda.service;

import com.ambev.revenda.controller.dto.PedidoClienteRequest;
import com.ambev.revenda.controller.mapper.PedidoClienteMapper;
import com.ambev.revenda.model.PedidoCliente;
import com.ambev.revenda.repository.PedidoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PedidoClienteService {

    @Autowired
    private PedidoClienteRepository pedidoClienteRepository;

    @Autowired
    private PedidoClienteMapper pedidoClienteMapper;

    @Autowired
    private RevendaService revendaService;

    @Autowired
    private ClienteService clienteService;

    public PedidoCliente criarPedido(PedidoClienteRequest pedidoClienteRequest) {
         var revenda  = revendaService.buscarPorId(pedidoClienteRequest.getRevendaId())
                .orElseThrow(() -> new RuntimeException("Revenda não encontrada"));

        var cliente  = clienteService.buscarPorId(pedidoClienteRequest.getRevendaId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        PedidoCliente pedidoCliente = pedidoClienteMapper.toEntity(pedidoClienteRequest);
        var retorno = pedidoClienteRepository.save(pedidoCliente);
        retorno.setRevenda(revenda);
        retorno.setCliente(cliente);
        return retorno;
    }

    public List<PedidoCliente> listarPedidos() {
        return pedidoClienteRepository.findAll();
    }

    public List<PedidoCliente> listarPedidosPorRevenda(Long revendaId) {
        return pedidoClienteRepository.findByRevendaId(revendaId);
    }
}