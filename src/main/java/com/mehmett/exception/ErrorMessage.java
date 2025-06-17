package com.mehmett.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Builder
@Setter
@Getter
public class ErrorMessage {
	int code;
	String message;
	Boolean success;
	List<String> fields;
}