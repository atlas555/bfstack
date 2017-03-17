package com.bf.blog.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PerformanceLogInterceptor extends LogInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(PerformanceLogInterceptor.class);
	
	private static ThreadLocal<Long> perf = new ThreadLocal<Long>() {
        public Long initialValue() {
            return 0l;
        }  
    };
    
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		perf.set(System.currentTimeMillis());
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
		if (perf.get() != 0){
			final StringBuilder sb = this.getLog(request, response);
			sb.append(SEPERATOR);
			sb.append(System.currentTimeMillis() - perf.get());
			logger.info(sb.toString());
		}
	}
}
