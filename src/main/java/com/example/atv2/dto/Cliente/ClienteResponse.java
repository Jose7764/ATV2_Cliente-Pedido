package com.example.atv2.dto.Cliente;

import com.example.atv2.dto.Pedido.PedidoResponse;
import com.example.atv2.model.Pedido;

import java.util.List;

public record ClienteResponse(
        long id,
        String nome,
        String email,
        List<Pedido> pedidos
) {
}
