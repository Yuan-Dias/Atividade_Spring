package com.boaglio.greendogdelivery.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.boaglio.greendogdelivery.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}