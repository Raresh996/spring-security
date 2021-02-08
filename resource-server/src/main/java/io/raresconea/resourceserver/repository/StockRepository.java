package io.raresconea.resourceserver.repository;

import io.raresconea.resourceserver.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
	Optional<Stock> findByNameIgnoreCase(String name);
}
