package com.sprint.saleshistory.controllers;

import java.util.stream.Collectors;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.sprint.saleshistory.exception.DuplicateRecordException;
import com.sprint.saleshistory.exception.EmptyListException;
import com.sprint.saleshistory.exception.RecordNotFoundException;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DuplicateRecordException.class)
	public ResponseEntity<String> handleDuplicateDataException(DuplicateRecordException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(RecordNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<String> handleEmptyListException(EmptyListException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	

//	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.joining(", "));
//		return new ResponseEntity<>(ex.getMessage(),status);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		
	}

}