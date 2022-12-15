package com.phoneshopmanagementsystem.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFoundException extends ApiException{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private Integer resourceId;
	private String resourceName;
   public ResourceNotFoundException(String resourceName ,Integer resourceId) {
	   super(HttpStatus.NOT_FOUND, String.format("%s not found for id=%d", resourceName, resourceId));
   }
}
