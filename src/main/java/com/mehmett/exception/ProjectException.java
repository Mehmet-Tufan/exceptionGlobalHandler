package com.mehmett.exception;

import lombok.Getter;

@Getter
public class ProjectException extends RuntimeException {
	private ErrorType errorType;
	public ProjectException(ErrorType errorType) {
		super(errorType.getMessage());
		this.errorType=errorType;
	}
}