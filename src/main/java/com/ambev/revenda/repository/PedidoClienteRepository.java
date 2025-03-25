package com.ambev.revenda.repository;


import com.ambev.revenda.model.PedidoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoClienteRepository extends JpaRepository<PedidoCliente, Long> {
}
