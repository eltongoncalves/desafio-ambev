package com.ambev.revenda.integration;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@EnableFeignClients
@FeignClient(name = "pedidoFornecedorClient", url = "${fornecedor.api.url}")
public interface SolicitacaoRevendaClient {

    @PostMapping("/pedidos")
    PedidoFornecedorResponse enviarPedidoFornecedor(PedidoFornecedorRequest pedido);
}