package com.ambev.revenda.service;

import com.ambev.revenda.controller.dto.PedidoClienteRequest;
import com.ambev.revenda.controller.mapper.PedidoClienteMapper;
import com.ambev.revenda.model.PedidoCliente;
import com.ambev.revenda.repository.PedidoClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PedidoClienteService {

    private final PedidoClienteRepository pedidoClienteRepository;
    private final PedidoClienteMapper pedidoClienteMapper;
    private final RevendaService revendaService;
    private final ClienteService clienteService;

    public PedidoClienteService(PedidoClienteRepository pedidoClienteRepository,
                                PedidoClienteMapper pedidoClienteMapper,
                                RevendaService revendaService,
                                ClienteService clienteService) {
        this.pedidoClienteRepository = pedidoClienteRepository;
        this.pedidoClienteMapper = pedidoClienteMapper;
        this.revendaService = revendaService;
        this.clienteService = clienteService;
    }

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