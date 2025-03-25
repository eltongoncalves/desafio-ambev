package com.ambev.revenda.controller;

import com.ambev.revenda.integration.PedidoFornecedorResponse;
import com.ambev.revenda.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedor")
public class PedidoFornecedorController {

    private final FornecedorService fornecedorService;

    public PedidoFornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping("/{revendaId}")
    public ResponseEntity<PedidoFornecedorResponse> processarPedido(@PathVariable Long revendaId) {
        return ResponseEntity.ok(fornecedorService.enviarPedidoFornecedorByRevenda(revendaId));
    }
}