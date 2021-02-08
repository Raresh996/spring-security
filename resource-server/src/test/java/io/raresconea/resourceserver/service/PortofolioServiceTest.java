package io.raresconea.resourceserver.service;

import io.raresconea.resourceserver.entity.Portofolio;
import io.raresconea.resourceserver.exception.PortofolioNotFoundException;
import io.raresconea.resourceserver.repository.PortofolioRepository;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PortofolioServiceTest {
	private final Integer PORTOFOLIO_ID = 1;
	private final String PORTOFOLIO_USERNAME = "username";

	@Mock
	private PortofolioRepository portofolioRepository;

	@InjectMocks
	private PortofolioService portofolioService;

	@Test
	@DisplayName("WHEN portofolio does not exist by username THEN exception is thrown")
	public void test1() {
		Mockito.when(portofolioRepository.findByUsername(PORTOFOLIO_USERNAME)).thenReturn(Optional.empty());
		assertThrows(PortofolioNotFoundException.class, () -> portofolioService.findByUsername(PORTOFOLIO_USERNAME));
	}

	@Test
	@DisplayName("WHEN portofolio exists by username THEN return it")
	public void test2() {
		Mockito.when(portofolioRepository.findByUsername(PORTOFOLIO_USERNAME)).thenReturn(Optional.of(createPortofolio(PORTOFOLIO_ID, PORTOFOLIO_USERNAME)));

		Portofolio portofolio = portofolioService.findByUsername(PORTOFOLIO_USERNAME);

		Assert.assertEquals(portofolio.getId(), PORTOFOLIO_ID);
		Assert.assertEquals(portofolio.getUsername(), PORTOFOLIO_USERNAME);
	}

	@Test
	@DisplayName("WHEN trying to create an portofolio for an user that already has one THEN no portofolio should be created")
	public void test3() {
		Mockito.when(portofolioRepository.findByUsername(PORTOFOLIO_USERNAME)).thenReturn(Optional.of(createPortofolio(PORTOFOLIO_ID, PORTOFOLIO_USERNAME)));

		portofolioService.createEmptyPortofolioForUserWithUsername(PORTOFOLIO_USERNAME);

		Mockito.verify(portofolioRepository, Mockito.never()).save(Mockito.any(Portofolio.class));
	}

	@Test
	@DisplayName("WHEN trying to create an portofolio for an user that does not have one THEN a portofolio should be created")
	public void test4() {
		Mockito.when(portofolioRepository.findByUsername(PORTOFOLIO_USERNAME)).thenReturn(Optional.empty());

		portofolioService.createEmptyPortofolioForUserWithUsername(PORTOFOLIO_USERNAME);

		Mockito.verify(portofolioRepository).save(Mockito.any(Portofolio.class));
	}

	private Portofolio createPortofolio(Integer id, String username) {
		Portofolio portofolio = new Portofolio();

		portofolio.setId(id);
		portofolio.setUsername(username);

		return portofolio;
	}
}
