package com.example.atv2.controller;

import com.example.atv2.dto.Cliente.ClienteRequest;
import com.example.atv2.dto.Cliente.ClienteResponse;
import com.example.atv2.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    @PostMapping("add")
    public ResponseEntity<ClienteResponse> create(@RequestBody  ClienteRequest dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    @GetMapping("listAll")
    public ResponseEntity<List<ClienteResponse>> listAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listAll());
    }

    @GetMapping("list/{id}")
    public ResponseEntity<ClienteResponse> listById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listById(id));
    }

}
