package io.raresconea.resourceserver.service.impl;

import io.raresconea.resourceserver.entity.PortofolioToStock;
import io.raresconea.resourceserver.repository.PortofolioToStockRepository;
import io.raresconea.resourceserver.service.PortofolioToStockService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class PortofolioToStockServiceImpl implements PortofolioToStockService {
	private final PortofolioToStockRepository portofolioToStockRepository;

	public PortofolioToStockServiceImpl(PortofolioToStockRepository portofolioToStockRepository) {
		this.portofolioToStockRepository = portofolioToStockRepository;
	}

	@Override
	public PortofolioToStock save(PortofolioToStock portofolioToStock) {
		Assert.notNull(portofolioToStock, "PortofolioToStock can not be null");

		return portofolioToStockRepository.save(portofolioToStock);
	}
}
