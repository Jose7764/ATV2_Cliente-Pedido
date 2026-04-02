package com.example.atv2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String descricao;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    @JsonIgnore
    private Cliente cliente;

    public Pedido(String titulo, String descricao, Cliente cliente) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cliente = cliente;
    }

    public Pedido(long id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Pedido(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }
}

