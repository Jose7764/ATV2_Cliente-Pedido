package com.example.atv2.mapper;

import com.example.atv2.dto.Cliente.ClienteRequest;
import com.example.atv2.dto.Cliente.ClienteResponse;
import com.example.atv2.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequest dto){
        return new Cliente(
                dto.nome(),
                dto.email()

        );
    }

    public ClienteResponse toResponse(Cliente cliente){
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getPedidos()
        );
    }
}
