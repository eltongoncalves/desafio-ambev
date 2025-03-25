package com.ambev.revenda.repository;


import com.ambev.revenda.model.Cliente;
import com.ambev.revenda.model.PedidoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
