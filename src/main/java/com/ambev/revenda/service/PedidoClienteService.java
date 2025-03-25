package com.ambev.revenda.service;

import com.ambev.revenda.model.PedidoCliente;
import com.ambev.revenda.repository.PedidoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoClienteService {

    @Autowired
    private PedidoClienteRepository pedidoClienteRepository;

    public PedidoCliente criarPedido(PedidoCliente pedido) {
        return pedidoClienteRepository.save(pedido);
    }

    public List<PedidoCliente> listarPedidos() {
        return pedidoClienteRepository.findAll();
    }
}