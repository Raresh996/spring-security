package io.raresconea.resourceserver.rest;

import io.raresconea.resourceserver.exception.PortofolioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PortofolioErrorHandler {

	@ExceptionHandler(PortofolioNotFoundException.class)
	public ResponseEntity<String> portofolioNotFoundException(final PortofolioNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

}
