package com.bf.blog.controller;


import com.bf.blog.enums.ErrorCodeEnum;

public class ResponseData<T> {
	private final int status;
	private final String message;
	private final T data;
	
	public static <T> ResponseData<T> get(int status, String message, T data){
		return new ResponseData<T>(status, message, data);
	}
	
	public static <T> ResponseData<T> getOKResult(T data){
		return new ResponseData<T>(ErrorCodeEnum.OK.getErrorCode(), ErrorCodeEnum.OK.getErrorMsg(), data);
	}
	
	public static <T> ResponseData<String> getErrorResult(){
		return getErrorResult(ErrorCodeEnum.UNKNOWN_ERROR, "");
	}
	
	public static <T> ResponseData<T> getErrorResult(ErrorCodeEnum error, T data){
		return new ResponseData<T>(error.getErrorCode(), error.getErrorMsg(), data);
	}
	
	public static <T> ResponseData<String> getErrorResult(ErrorCodeEnum error){
		return getErrorResult(error, "");
	}
	
	public static <T> ResponseData<String> getErrorResult(int code, String message){
		return new ResponseData<String>(code, message, "");
	}
	
	private ResponseData(int status, String message, T data){
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}
	
	
}
