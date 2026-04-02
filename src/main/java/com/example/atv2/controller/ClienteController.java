package com.example.atv2.controller;

import com.example.atv2.dto.Cliente.ClienteRequest;
import com.example.atv2.dto.Cliente.ClienteResponse;
import com.example.atv2.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    @PostMapping("add")
    public ClienteResponse create(@RequestBody  ClienteRequest dto){
        return service.create(dto);
    }

    @GetMapping("listAll")
    public List<ClienteResponse> listAll(){
        return service.listAll();
    }

    @GetMapping("list/{id}")
    public ClienteResponse listById(@PathVariable long id){
        return service.listById(id);
    }

}
