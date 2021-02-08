package io.raresconea.resourceserver.converter;

import io.raresconea.resourceserver.dto.StockDto;
import io.raresconea.resourceserver.entity.Stock;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ExtendWith(MockitoExtension.class)
public class StockConverterTest {
	private final Integer STOCK_ID = 1;
	private final String STOCK_NAME = "AAPL";
	private final Double STOCK_PRICE = 10D;
	private final Double STOCK_DIVIDEND = 5D;

	private final StockConverter stockConverter = new StockConverter();

	@Test
	@DisplayName("WHEN converting from entity to dto THEN all fields must be copied")
	public void test1() throws Exception {
		StockDto stock = stockConverter.convertToDto(createStockEntity(STOCK_ID, STOCK_NAME, STOCK_PRICE, STOCK_DIVIDEND));

		Assert.assertEquals(STOCK_ID, stock.getId());
		Assert.assertEquals(STOCK_NAME, stock.getName());
		Assert.assertEquals(STOCK_PRICE, stock.getPrice());
		Assert.assertEquals(STOCK_DIVIDEND, stock.getDividend());
	}

	@Test
	@DisplayName("WHEN converting from dto to entity THEN all fields must be copied")
	public void test2() throws Exception {
		Stock stock = stockConverter.convertToEntity(createStockDto(STOCK_ID, STOCK_NAME, STOCK_PRICE, STOCK_DIVIDEND));

		Assert.assertEquals(STOCK_ID, stock.getId());
		Assert.assertEquals(STOCK_NAME, stock.getName());
		Assert.assertEquals(STOCK_PRICE, stock.getPrice());
		Assert.assertEquals(STOCK_DIVIDEND, stock.getDividend());
	}

	private Stock createStockEntity(Integer id, String name, Double price, Double dividend) {
		Stock stock = new Stock();

		stock.setId(id);
		stock.setName(name);
		stock.setPrice(price);
		stock.setDividend(dividend);

		return stock;
	}

	private StockDto createStockDto(Integer id, String name, Double price, Double dividend) {
		StockDto stock = new StockDto();

		stock.setId(id);
		stock.setName(name);
		stock.setPrice(price);
		stock.setDividend(dividend);

		return stock;
	}
}
