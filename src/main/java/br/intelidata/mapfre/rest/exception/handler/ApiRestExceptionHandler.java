package br.intelidata.mapfre.rest.exception.handler;

import static br.intelidata.mapfre.rest.util.Constants.ERROR_INTERNO_DEL_SERVIDOR;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.intelidata.mapfre.rest.error.ApiRestErrorResponse;
import br.intelidata.mapfre.rest.exception.ApiRestException;

@ControllerAdvice
public class ApiRestExceptionHandler {

	private static final Logger LOGGER = LogManager.getLogger(ApiRestExceptionHandler.class);

	@ExceptionHandler
	public ResponseEntity<ApiRestErrorResponse> handleException(ApiRestException ex) {
		LOGGER.error(ex.getMessage(), ex);
		ApiRestErrorResponse error = new ApiRestErrorResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ERROR_INTERNO_DEL_SERVIDOR);
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler
	public ResponseEntity<ApiRestErrorResponse> handleException(ConfigurationException ex) {
		LOGGER.error(ex.getMessage(), ex);
		ApiRestErrorResponse error = new ApiRestErrorResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler
	public ResponseEntity<ApiRestErrorResponse> handleException(Exception ex) {
		LOGGER.error(ex.getMessage(), ex);
		ApiRestErrorResponse error = new ApiRestErrorResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setDetails(ex.getMessage());
		error.setMessage(ERROR_INTERNO_DEL_SERVIDOR);
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
