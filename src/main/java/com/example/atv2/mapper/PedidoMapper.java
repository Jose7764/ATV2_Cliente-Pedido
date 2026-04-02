package com.example.atv2.mapper;

import com.example.atv2.dto.Pedido.PedidoRequest;
import com.example.atv2.dto.Pedido.PedidoResponse;
import com.example.atv2.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido toEntity(PedidoRequest dto){
        return new Pedido(
                dto.titulo(),
                dto.descricao()

        );
    }

    public PedidoResponse toResponse(Pedido pedido){
        return new PedidoResponse(
                pedido.getId(),
                pedido.getTitulo(),
                pedido.getDescricao(),
                pedido.getCliente().getNome()
        );
    }
}
