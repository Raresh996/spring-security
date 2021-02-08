package io.raresconea.resourceserver.repository;

import io.raresconea.resourceserver.entity.Portofolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortofolioRepository extends JpaRepository<Portofolio, Integer> {
	Optional<Portofolio> findByUsername(String username);
}
