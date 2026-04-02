package com.example.atv2.dto.Pedido;

public record PedidoResponse(
        long id,
        String titulo,
        String descricao,
        String nomeCliente
) {
}
