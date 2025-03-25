package com.ambev.revenda.controller;


import com.ambev.revenda.controller.dto.PedidoClienteRequest;
import com.ambev.revenda.model.PedidoCliente;
import com.ambev.revenda.service.PedidoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedido-cliente")
public class PedidoClienteController {

    @Autowired
    private PedidoClienteService pedidoClienteService;

    @PostMapping
    public ResponseEntity<PedidoCliente> criarPedido(@RequestBody PedidoClienteRequest pedido) {
        return new ResponseEntity<>(pedidoClienteService.criarPedido(pedido), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PedidoCliente>> listarPedidos() {
        return new ResponseEntity<>(pedidoClienteService.listarPedidos(), HttpStatus.OK);
    }

    @GetMapping("/{revendaId}")
    public ResponseEntity<List<PedidoCliente>> listarPedidosPorRevenda(@PathVariable Long revendaId) {
        return new ResponseEntity<>(pedidoClienteService.listarPedidosPorRevenda(revendaId), HttpStatus.OK);
    }
}
