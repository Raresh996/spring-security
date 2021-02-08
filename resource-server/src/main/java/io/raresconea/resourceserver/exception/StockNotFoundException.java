package io.raresconea.resourceserver.exception;

public class StockNotFoundException extends RuntimeException {
	public StockNotFoundException(String message) {
		super(message);
	}
}
