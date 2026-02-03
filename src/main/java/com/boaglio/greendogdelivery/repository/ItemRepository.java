package com.boaglio.greendogdelivery.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.boaglio.greendogdelivery.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}