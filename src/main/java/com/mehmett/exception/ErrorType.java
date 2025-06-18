package com.mehmett.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorType {
	
	PASSWORD_MISMATCH(5001, "Girilen şifreler uyuşmuyor.", HttpStatus.BAD_REQUEST),
	VALIDATION_ERROR (400, "Girilen parametreler hatalıdır..",HttpStatus.BAD_REQUEST),
	INVALID_SERVER_ERROR (500,"Sunucuda beklenmeyen hata",HttpStatus.INTERNAL_SERVER_ERROR);
	
	private int code;
	private String message;
	private HttpStatus httpStatus;
}