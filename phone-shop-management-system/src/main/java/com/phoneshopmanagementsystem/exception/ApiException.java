package com.phoneshopmanagementsystem.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ApiException extends RuntimeException{
	//private static final long serialVersionUID = -5667472393605397284L;
    private HttpStatus status;
    private String message;
}
