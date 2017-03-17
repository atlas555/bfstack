package com.bf.blog.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessLogInterceptor extends LogInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(AccessLogInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
        logger.info(this.getLog(request, response).toString());
		return super.preHandle(request, response, handler);
	}

}
