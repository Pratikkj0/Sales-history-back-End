package com.sprint.saleshistory.exception;
public class CountryServiceException extends RuntimeException {

    public CountryServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    public CountryServiceException(String message) {
        super(message);
    }
    
    
}
