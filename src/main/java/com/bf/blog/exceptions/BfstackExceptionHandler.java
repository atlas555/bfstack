package com.bf.blog.exceptions;


import com.bf.blog.controller.ResponseData;
import com.bf.blog.enums.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;


@ControllerAdvice
public class BfstackExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(BfstackExceptionHandler.class);
	
	@ExceptionHandler(value = NoSuchElementException.class)
    @ResponseBody
    public ResponseData<?> noSuchElementExceptionHandler(HttpServletRequest req, NoSuchElementException e) throws Exception {
		logger.error(e.toString(), e);
		return ResponseData.getErrorResult(ErrorCodeEnum.USER_NOT_LOGIN);
    }
	
	@ExceptionHandler(value = BfstackServiceException.class)
    @ResponseBody
    public ResponseData<?> snsServiceExceptionHandler(HttpServletRequest req, BfstackServiceException e) throws Exception {
		logger.error(e.toString(), e);
		return ResponseData.getErrorResult(e.getErrorCode(), e.getErrorMsg());
    }
	
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData<?> exceptionHandler(HttpServletRequest req, Exception e) throws Exception {
		logger.error(e.toString(), e);
		return ResponseData.getErrorResult(ErrorCodeEnum.UNKNOWN_ERROR);
    }
	
}
