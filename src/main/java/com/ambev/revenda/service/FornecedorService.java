package com.ambev.revenda.service;

import com.ambev.revenda.controller.dto.ItemPedidoRequest;
import com.ambev.revenda.controller.mapper.PedidoClienteMapper;
import com.ambev.revenda.integration.PedidoFornecedorRequest;
import com.ambev.revenda.integration.PedidoFornecedorResponse;
import com.ambev.revenda.integration.SolicitacaoRevendaClient;
import com.ambev.revenda.model.ItemPedido;
import com.ambev.revenda.model.PedidoCliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private RevendaService revendaService;

    @Autowired
    private PedidoClienteService pedidoClienteService;

    @Autowired
    private SolicitacaoRevendaClient client;

    @Autowired
    private PedidoClienteMapper pedidoClienteMapper;


    @Transactional
    public PedidoFornecedorResponse enviarPedidoFornecedorByRevenda(Long revendaId) {

        List<PedidoCliente> pedidosCliente = pedidoClienteService.listarPedidosPorRevenda(revendaId);
        if(!pedidosCliente.isEmpty()) {
            PedidoFornecedorRequest request = new PedidoFornecedorRequest();
            request.setRevenda(pedidosCliente.get(0).getRevenda());
            request.setQtdProdutos(calcularQuantidadePorProduto(pedidosCliente));
            request.setItens(recuperarTodosItens(pedidosCliente));

            if(request.getQtdProdutos() >= 1000)
                return getClient().enviarPedidoFornecedor(request);

            throw new RuntimeException("O minimo de produtos deve ser maior que 1000");
        }

        throw new RuntimeException("Revenda não encontrada");
    }


    private Integer calcularQuantidadePorProduto(List<PedidoCliente> pedidosCliente) {
        Map<Long, Integer> quantidadePorProduto = pedidosCliente.stream()
                .flatMap(pedido -> pedido.getItens().stream())
                .collect(Collectors.groupingBy(
                        ItemPedido::getProdutoId,
                        Collectors.summingInt(ItemPedido::getQuantidade)
                ));
        return  quantidadePorProduto.values().stream().mapToInt(Integer::intValue).sum();
    }

    private List<ItemPedidoRequest> recuperarTodosItens(List<PedidoCliente> pedidosCliente) {

       return pedidosCliente.stream()
               .map(pedidoClienteMapper::toDto)
               .toList().
               stream()
                .flatMap(pedido -> pedido.getItens().stream())
                .toList();

    }


    public SolicitacaoRevendaClient getClient() {
        return client;
    }

    public void setClient(SolicitacaoRevendaClient client) {
        this.client = client;
    }
}
