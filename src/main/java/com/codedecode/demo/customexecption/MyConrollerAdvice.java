package com.codedecode.demo.customexecption;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyConrollerAdvice {
	
	@ExceptionHandler(EmptyIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleEmptyIdExceptionException(
    		EmptyIdException exception
    ) {
         return ResponseEntity
           .status(HttpStatus.BAD_REQUEST)
           .body(exception.getMessage());
      }
	

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException exception) {
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body("No Data is available in the DB with the ID");
	}
			
}
