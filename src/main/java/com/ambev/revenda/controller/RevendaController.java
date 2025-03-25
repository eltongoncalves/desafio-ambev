package com.ambev.revenda.controller;

import com.ambev.revenda.model.Revenda;
import com.ambev.revenda.service.RevendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/revenda")
public class RevendaController {

    private final RevendaService revendaService;

    public RevendaController(RevendaService revendaService) {
        this.revendaService = revendaService;
    }

    @PostMapping
    public ResponseEntity<Revenda> criar(@RequestBody Revenda revenda) {
        return ResponseEntity.ok(revendaService.salvar(revenda));
    }

    @GetMapping
    public ResponseEntity<List<Revenda>> listarTodas() {
        return ResponseEntity.ok(revendaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Revenda>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(revendaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        revendaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}