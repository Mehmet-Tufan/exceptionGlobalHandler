package com.mehmett.exception;

import com.mehmett.dto.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler_x {
	@ExceptionHandler(ProjectException.class)
	@ResponseBody
	public ResponseEntity<BaseResponse<Boolean>> projectException (ProjectException exception){
		return new ResponseEntity<>(BaseResponse.<Boolean>builder().build(), HttpStatus.BAD_REQUEST);
	}
}