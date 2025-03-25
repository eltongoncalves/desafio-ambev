package com.ambev.revenda.integration;

import com.ambev.revenda.controller.dto.ItemPedidoRequest;
import com.ambev.revenda.model.Revenda;
import java.util.List;

public class PedidoFornecedorRequest {

    private Revenda revenda;
    private List<ItemPedidoRequest> itens;
    private Integer qtdProdutos;

    public Revenda getRevenda() {
        return revenda;
    }

    public void setRevenda(Revenda revenda) {
        this.revenda = revenda;
    }

    public List<ItemPedidoRequest> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoRequest> itens) {
        this.itens = itens;
    }

    public Integer getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(Integer qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }
}
