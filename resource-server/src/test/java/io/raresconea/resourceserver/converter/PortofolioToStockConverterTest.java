package io.raresconea.resourceserver.converter;

import io.raresconea.resourceserver.dto.PortofolioToStockDto;
import io.raresconea.resourceserver.entity.Portofolio;
import io.raresconea.resourceserver.entity.PortofolioToStock;
import io.raresconea.resourceserver.util.PortofolioToStockUtil;
import io.raresconea.resourceserver.util.StockUtil;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PortofolioToStockConverterTest {
	private final Integer PORTOFOLIO_ID = 1;
	private final Integer STOCK_ID = 2;
	private final String STOCK_NAME = "AAPL";
	private final Double STOCK_PRICE = 10D;
	private final Double STOCK_DIVIDEND = 5D;
	private final Integer NUMBER_OF = 10;

	private PortofolioToStockConverter converter = new PortofolioToStockConverter(new StockConverter());

	@Test
	@DisplayName("WHEN converting from entity to dto THEN all fields must be copied")
	public void test1() throws Exception {
		PortofolioToStockDto portofolioToStock = converter.convertToDto(
				PortofolioToStockUtil.createEntity(PORTOFOLIO_ID,
						createPortofolio(PORTOFOLIO_ID),
						StockUtil.createEntity(STOCK_ID, STOCK_NAME, STOCK_PRICE, STOCK_DIVIDEND),
						NUMBER_OF));

		Assert.assertEquals(PORTOFOLIO_ID, portofolioToStock.getId());
		Assert.assertEquals(STOCK_ID, portofolioToStock.getStock().getId());
		Assert.assertEquals(STOCK_NAME, portofolioToStock.getStock().getName());
		Assert.assertEquals(STOCK_PRICE, portofolioToStock.getStock().getPrice());
		Assert.assertEquals(STOCK_DIVIDEND, portofolioToStock.getStock().getDividend());
		Assert.assertEquals(NUMBER_OF, portofolioToStock.getNumberOf());
	}

	@Test
	@DisplayName("WHEN converting from dto to entity THEN all fields must be copied")
	public void test2() throws Exception {
		PortofolioToStock portofolioToStock = converter.convertToEntity(
				PortofolioToStockUtil.createDto(PORTOFOLIO_ID,
						StockUtil.createDto(STOCK_ID, STOCK_NAME, STOCK_PRICE, STOCK_DIVIDEND),
						NUMBER_OF));

		Assert.assertEquals(PORTOFOLIO_ID, portofolioToStock.getId());
		Assert.assertEquals(STOCK_ID, portofolioToStock.getStock().getId());
		Assert.assertEquals(STOCK_NAME, portofolioToStock.getStock().getName());
		Assert.assertEquals(STOCK_PRICE, portofolioToStock.getStock().getPrice());
		Assert.assertEquals(STOCK_DIVIDEND, portofolioToStock.getStock().getDividend());
		Assert.assertEquals(NUMBER_OF, portofolioToStock.getNumberOf());
	}

	private Portofolio createPortofolio(Integer id) {
		Portofolio portofolio = new Portofolio();
		portofolio.setId(id);

		return portofolio;
	}

}
