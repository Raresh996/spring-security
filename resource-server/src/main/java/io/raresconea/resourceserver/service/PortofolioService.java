package io.raresconea.resourceserver.service;

import io.raresconea.resourceserver.entity.Portofolio;
import io.raresconea.resourceserver.entity.PortofolioToStock;

import java.util.List;

public interface PortofolioService {
	Portofolio findByUsername(String username);

	void createEmptyPortofolioForUserWithUsername(String username);

	void addStocksToPortofolio(String username, List<PortofolioToStock> stocks);
}
