package com.boaglio.greendogdelivery.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.boaglio.greendogdelivery.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}