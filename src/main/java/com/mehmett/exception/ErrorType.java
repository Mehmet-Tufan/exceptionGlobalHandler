package com.mehmett.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorType {
	
	PASSWORD_MISMATCH(400, "Girilen şifreler uyuşmuyor.", HttpStatus.BAD_REQUEST);
	
	private int code;
	private String message;
	private HttpStatus httpStatus;
}