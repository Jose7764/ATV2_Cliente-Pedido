package com.example.atv2.dto.Pedido;

public record PedidoRequest (
        String titulo,
        String descricao,
        long id_cliente
){
}
