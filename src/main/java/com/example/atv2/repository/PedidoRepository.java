package com.example.atv2.repository;

import com.example.atv2.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId(long id_cliente);
    List<Pedido> findByClienteNome(String nome);
}
