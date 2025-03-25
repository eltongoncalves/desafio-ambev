package com.ambev.revenda.service;

import com.ambev.revenda.controller.dto.PedidoClienteRequest;
import com.ambev.revenda.controller.mapper.PedidoClienteMapper;
import com.ambev.revenda.model.PedidoCliente;
import com.ambev.revenda.model.Revenda;
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



    public PedidoCliente criarPedido(PedidoClienteRequest pedidoClienteRequest) {
         revendaService.buscarPorId(pedidoClienteRequest.getRevendaId())
                .orElseThrow(() -> new RuntimeException("Revenda não encontrada"));
        PedidoCliente pedidoCliente = pedidoClienteMapper.toEntity(pedidoClienteRequest);
        return pedidoClienteRepository.save(pedidoCliente);
    }

    public List<PedidoCliente> listarPedidos() {
        return pedidoClienteRepository.findAll();
    }

    public List<PedidoCliente> listarPedidosPorRevenda(Long revendaId) {
        return pedidoClienteRepository.findByRevendaId(revendaId);
    }
}