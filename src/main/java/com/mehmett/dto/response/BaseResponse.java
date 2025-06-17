package com.mehmett.dto.response;

import lombok.Builder;

@Builder
public class BaseResponse <T> {
	Boolean success;
	T data;
	String message;
	Integer code;
}