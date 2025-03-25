package com.ambev.revenda.controller;


import com.ambev.revenda.model.PedidoCliente;
import com.ambev.revenda.service.PedidoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoClienteController {

    @Autowired
    private PedidoClienteService pedidoClienteService;

    @PostMapping
    public ResponseEntity<PedidoCliente> criarPedido(@RequestBody PedidoCliente pedido) {
        PedidoCliente pedidoCriado = pedidoClienteService.criarPedido(pedido);
        return new ResponseEntity<>(pedidoCriado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PedidoCliente>> listarPedidos() {
        List<PedidoCliente> pedidos = pedidoClienteService.listarPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
}
