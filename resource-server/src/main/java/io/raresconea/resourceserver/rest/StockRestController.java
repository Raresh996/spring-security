package io.raresconea.resourceserver.rest;

import io.raresconea.resourceserver.converter.StockConverter;
import io.raresconea.resourceserver.dto.StockDto;
import io.raresconea.resourceserver.service.StockService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stocks")
public class StockRestController {
	private final StockService stockService;
	private final StockConverter stockConverter;

	public StockRestController(StockService stockService, StockConverter stockConverter) {
		this.stockService = stockService;
		this.stockConverter = stockConverter;
	}

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public List<StockDto> findAll() {
		return stockService.findAll().stream()
				.map(stockConverter::convertToDto)
				.collect(Collectors.toList());
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public void save(@RequestBody StockDto stock) {
		stockService.save(stockConverter.convertToEntity(stock));
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void update(@PathVariable Integer id, @RequestBody StockDto dto) {
		stockService.update(id, stockConverter.convertToEntity(dto));
	}

	@GetMapping("/{name}")
	@PreAuthorize("isAuthenticated()")
	public StockDto findById(@PathVariable String name) {
		return stockConverter.convertToDto(stockService.findByName(name));
	}
}
