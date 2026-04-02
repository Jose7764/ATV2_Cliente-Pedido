package com.example.atv2.service;

import com.example.atv2.dto.Cliente.ClienteRequest;
import com.example.atv2.dto.Cliente.ClienteResponse;
import com.example.atv2.mapper.ClienteMapper;
import com.example.atv2.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteMapper mapper;
    private final ClienteRepository repository;

    public ClienteResponse create(ClienteRequest dto){
        return mapper.toResponse(repository.save(mapper.toEntity(dto)));
    }

    public List<ClienteResponse> listAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public ClienteResponse listById(long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não achado!")));
    }


}
