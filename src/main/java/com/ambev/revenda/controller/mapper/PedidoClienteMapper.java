package com.ambev.revenda.controller.mapper;


import com.ambev.revenda.controller.dto.PedidoClienteRequest;
import com.ambev.revenda.model.PedidoCliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PedidoClienteMapper {

    PedidoClienteMapper INSTANCE = Mappers.getMapper(PedidoClienteMapper.class);

    @Mapping(source = "revendaId", target = "revenda.id")
    @Mapping(source = "clienteId", target = "cliente.id")
    PedidoCliente toEntity(PedidoClienteRequest pedidoClienteRequest);

    PedidoClienteRequest toDto(PedidoCliente pedidoCliente);
}
