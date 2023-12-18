package com.sprint.saleshistory.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CountryExceptionHandler {

    @ExceptionHandler(CountryServiceException.class)
	public ResponseEntity<String> handleCountryServiceException(CountryServiceException ex) {
        return new ResponseEntity<>("Error in country service: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
    
    @ExceptionHandler(InvalidCountryNameException.class)
    public ResponseEntity<String> handleCountryServiceException(InvalidCountryNameException ex) {
    	return new ResponseEntity<>("Error in country service: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(InvalidRegionNameException.class)
    public ResponseEntity<String> handleCountryServiceException(InvalidRegionNameException ex) {
    	return new ResponseEntity<>("Error in country service: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
    @ExceptionHandler(DuplicateCountryException.class)
    public ResponseEntity<String> handleCountryServiceException(DuplicateCountryException ex) {
    	return new ResponseEntity<>("Error in country service: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
    
    @ExceptionHandler(CountryDeleteException.class)
    public ResponseEntity<String> handleCountryServiceException(CountryDeleteException ex) {
    	return new ResponseEntity<>("Error in country service for deleting: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
   
    
    
    @ExceptionHandler(CostsServiceException.class)
    public ResponseEntity<String> handleCountryServiceException(CostsServiceException ex) {
    	return new ResponseEntity<>("Error in costs service :" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
    
    
}
