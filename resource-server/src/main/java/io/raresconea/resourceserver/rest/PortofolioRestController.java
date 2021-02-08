package io.raresconea.resourceserver.rest;

import io.raresconea.resourceserver.converter.PortofolioConverter;
import io.raresconea.resourceserver.converter.PortofolioToStockConverter;
import io.raresconea.resourceserver.dto.PortofolioDto;
import io.raresconea.resourceserver.dto.PortofolioToStockDto;
import io.raresconea.resourceserver.service.PortofolioService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/portofolios")
public class PortofolioRestController {
	private final PortofolioService portofolioService;
	private final PortofolioConverter portofolioConverter;
	private final PortofolioToStockConverter portofolioToStockConverter;

	public PortofolioRestController(PortofolioService portofolioService, PortofolioConverter portofolioConverter,
			PortofolioToStockConverter portofolioToStockConverter) {
		this.portofolioService = portofolioService;
		this.portofolioConverter = portofolioConverter;
		this.portofolioToStockConverter = portofolioToStockConverter;
	}

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public PortofolioDto getAuthenticatedUserPortofolio(Authentication authentication) {
		return portofolioConverter.convertToDto(portofolioService.findByUsername(authentication.getName()));
	}

	@GetMapping("/{username}")
	@PreAuthorize("hasRole('ADMIN')")
	public PortofolioDto getPortofolioByUsername(@PathVariable String username) {
		return portofolioConverter.convertToDto(portofolioService.findByUsername(username));
	}

	@PostMapping
	@PreAuthorize("isAuthenticated()")
	public void createEmptyPortofolioForUser(Authentication authentication) {
		portofolioService.createEmptyPortofolioForUserWithUsername(authentication.getName());
	}

	@PostMapping("/{username}")
	@PreAuthorize("hasRole('ADMIN') or authentication.name == #username")
	public void addStockToPortofolio(@PathVariable("username") String username, @RequestBody List<PortofolioToStockDto> stocks) {
		portofolioService.addStocksToPortofolio(username,
				stocks.stream()
						.map(portofolioToStockConverter::convertToEntity)
						.collect(Collectors.toList()));
	}

}
