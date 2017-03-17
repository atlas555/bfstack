package com.bf.blog.interceptor;

import com.bf.blog.utils.DateTimeUtils;
import com.google.common.base.Joiner;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class LogInterceptor extends HandlerInterceptorAdapter {

	protected static final String SEPERATOR = "|";

	protected StringBuilder getLog(HttpServletRequest request, HttpServletResponse response){
		String uri = request.getRequestURI();
        List<String> paramList = new ArrayList<String>();
        Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String param = e.nextElement();
			if (param != null) {
				String value = request.getParameter(param);
				if (value != null) {
					paramList.add(param + "=" + value);
				}
			}
		}
        Collections.sort(paramList);
        final StringBuilder sb = new StringBuilder();
        if (ThreadLocalContext.getCurrentUser() != null){
            sb.append(ThreadLocalContext.getCurrentUser().getId());
        }else{
            sb.append("0");
        }
        sb.append(SEPERATOR);
        sb.append(uri);
        sb.append(SEPERATOR);
        sb.append(Joiner.on("&").join(paramList));
        sb.append(SEPERATOR);
        sb.append(DateTimeUtils.getCurrentTime4Str());
        sb.append(SEPERATOR);
        sb.append(request.getRemoteHost());
        return sb;
	}
	
}
