package com.neosoft.poctask.exception;

import javax.naming.AuthenticationException;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<String> handeAuthentication(Exception a)
	{
		
		return new ResponseEntity<String>("BAD CREDENTIALS",HttpStatus.OK);
		
	}

}
