package io.raresconea.resourceserver.rest;

import io.raresconea.resourceserver.exception.StockNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StockErrorHandler {

	@ExceptionHandler(StockNotFoundException.class)
	public ResponseEntity<String> stockNotFoundException(final StockNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}
