package io.raresconea.resourceserver.service;

import io.raresconea.resourceserver.entity.Portofolio;
import io.raresconea.resourceserver.entity.PortofolioToStock;
import io.raresconea.resourceserver.exception.PortofolioNotFoundException;
import io.raresconea.resourceserver.repository.PortofolioRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PortofolioService {
	private final PortofolioRepository portofolioRepository;

	public PortofolioService(PortofolioRepository portofolioRepository) {
		this.portofolioRepository = portofolioRepository;
	}

	public Portofolio findByUsername(String username) {
		return portofolioRepository.findByUsername(username)
				.orElseThrow(() -> new PortofolioNotFoundException(String.format("Portofolio of user with username %s not found", username)));
	}

	@Transactional
	public void createEmptyPortofolioForUserWithUsername(String username) {
		Assert.notNull(username, "Username can not be null");

		try {
			findByUsername(username);
		} catch (PortofolioNotFoundException e) {
			Portofolio portofolio = new Portofolio();
			portofolio.setUsername(username);

			portofolioRepository.save(portofolio);
		}
	}

	@Transactional
	public void addStocksToPortofolio(String username, List<PortofolioToStock> stocks) {
		Assert.notNull(username, "Username can not be null");
		Assert.notNull(stocks, "Stocks can not be null");

		Portofolio portofolio = findByUsername(username);
		stocks.forEach(stock -> stock.setPortofolio(portofolio));
		portofolio.getStocks().addAll(stocks);

		portofolioRepository.save(portofolio);
	}
}
