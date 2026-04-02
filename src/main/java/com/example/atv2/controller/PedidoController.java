package com.example.atv2.controller;

import com.example.atv2.dto.Pedido.PedidoRequest;
import com.example.atv2.dto.Pedido.PedidoResponse;
import com.example.atv2.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService service;

    @PostMapping("/add")
    public PedidoResponse create(@RequestBody PedidoRequest dto){
        return service.create(dto);
    }

    @GetMapping("/listAll")
    public List<PedidoResponse> listAll(){
        return service.listAll();
    }

    @GetMapping("/list/{id}")
    public PedidoResponse listById(@PathVariable long id){
        return service.listById(id);
    }

    @GetMapping("/list/cliente/{id}")
    public List<PedidoResponse> listByClientId(@PathVariable long id){
        return service.findByClienteId(id);
    }

    @GetMapping("/list")
    public List<PedidoResponse> listByClientName(@RequestParam String nome){
        return service.findByClienteNome(nome);
    }
}
