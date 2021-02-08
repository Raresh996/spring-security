package io.raresconea.resourceserver.repository;

import io.raresconea.resourceserver.entity.PortofolioToStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortofolioToStockRepository extends JpaRepository<PortofolioToStock, Integer> {
}
