package com.ambev.revenda.repository;


import com.ambev.revenda.model.PedidoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoClienteRepository extends JpaRepository<PedidoCliente, Long> {
    List<PedidoCliente> findByRevendaId(Long revendaId);
}
