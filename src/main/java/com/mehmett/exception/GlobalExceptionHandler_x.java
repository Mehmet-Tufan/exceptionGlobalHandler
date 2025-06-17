package com.mehmett.exception;

import com.mehmett.dto.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler_x {
	@ExceptionHandler(ProjectException.class) // İstisnayı yakalayan kısım
	@ResponseBody
	public ResponseEntity<ErrorMessage> projectException (ProjectException exception){
		// ResponseEntity.ok() --> 200 OK. success her şey yolunda
		// ResponseEntity.badRequest() --> 400 gelen istek hatalı
		// ResponseEntity.internalServerError() --> Sunucu tarafında bir hata oluştu
		return new ResponseEntity<>(ErrorMessage.builder()
				                            .success(false)
				                            .message(exception.getErrorType().getMessage())
				                            .code(exception.getErrorType().getCode())
				                            .build(), exception.getErrorType().getHttpStatus());
	}
}