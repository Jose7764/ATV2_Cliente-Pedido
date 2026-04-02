package com.example.atv2.service;

import com.example.atv2.dto.Pedido.PedidoRequest;
import com.example.atv2.dto.Pedido.PedidoResponse;
import com.example.atv2.mapper.PedidoMapper;
import com.example.atv2.model.Cliente;
import com.example.atv2.model.Pedido;
import com.example.atv2.repository.ClienteRepository;
import com.example.atv2.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;
    private final PedidoMapper mapper;

    public PedidoResponse create (PedidoRequest dto){
        Cliente cliente = clienteRepository.findById(dto.id_cliente()).orElseThrow(()-> new RuntimeException("Cliente não Existe!"));

        Pedido pedido = mapper.toEntity(dto);
        pedido.setCliente(cliente);

        return mapper.toResponse(repository.save(pedido));
    }

    public List<PedidoResponse> listAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }


    public PedidoResponse listById(long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(()->new RuntimeException("Pedido não Encontrado!")));
    }

    public List<PedidoResponse> findByClienteId(long id){
        return repository.findByClienteId(id).stream().map(mapper::toResponse).toList();
    }

    public List<PedidoResponse> findByClienteNome(String nome){
        return repository.findByClienteNome(nome).stream().map(mapper::toResponse).toList();
    }

}
