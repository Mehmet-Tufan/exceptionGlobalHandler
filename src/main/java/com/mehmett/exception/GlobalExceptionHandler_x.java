package com.mehmett.exception;

import com.mehmett.dto.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler_x {
	/**
	 * Tanımlaması yapılmayan tüm hataları yakalamak için RuntimeException
	 */
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorMessage> runtimeExceptionHandler(RuntimeException exception){
		
		return createResponseEntity(ErrorType.INVALID_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR,null);
	}
	
	
	@ExceptionHandler(ProjectException.class) // İstisnayı yakalayan kısım
	@ResponseBody
	public ResponseEntity<ErrorMessage> projectException (ProjectException exception){
		// ResponseEntity.ok() --> 200 OK. success her şey yolunda
		// ResponseEntity.badRequest() --> 400 gelen istek hatalı
		// ResponseEntity.internalServerError() --> Sunucu tarafında bir hata oluştu
		return createResponseEntity(exception.getErrorType(),exception.getErrorType().getHttpStatus(), null);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<ErrorMessage> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception){
		List<String> fields = new ArrayList<>();
		exception.getBindingResult().getFieldErrors().forEach(
		// f.getField() -> Hata fırlatan nesnenin değişken adı
		// f.getDefaultMessage() -> Hataya ait detay bilgisi
				f-> fields.add("Değişken adı..: "+f.getField()+" - Hatanın Detayı..: "+f.getDefaultMessage())
		);
		return createResponseEntity(ErrorType.VALIDATION_ERROR,HttpStatus.BAD_REQUEST,fields);
	}
	
	public ResponseEntity<ErrorMessage> createResponseEntity (ErrorType errorType,HttpStatus httpStatus,
	            
	                                                          List<String> errField){
	log.error("TÜM HATALARIN GETİĞİ NOKTA: "+ errField);
		return 	new ResponseEntity<>(ErrorMessage.builder()
			                               .success(false)
			                               .message(errorType.getMessage())
			                               .fields(errField)
			                               .build(),httpStatus);
	}
}