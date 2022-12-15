package com.phoneshopmanagementsystem.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ApiException.class)
   public ResponseEntity<?>handlHttpClientError(ApiException ex){
		ErrorRespone errorRespone=new ErrorRespone(ex.getStatus().getReasonPhrase(), ex.getMessage());
	   return ResponseEntity.status(ex.getStatus()).body(errorRespone);
   }
}
