package com.bf.blog.interceptor;

import com.bf.blog.annotations.AdminRequired;
import com.bf.blog.annotations.LoginRequied;
import com.bf.blog.controller.ResponseData;
import com.bf.blog.domain.User;
import com.bf.blog.enums.ErrorCodeEnum;
import com.bf.blog.mapper.UserMapper;
import com.bf.blog.utils.JacksonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("AuthenticationInterceptor");
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		LoginRequied annotation = method.getAnnotation(LoginRequied.class);
		if (annotation != null){
			String token = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null){
				for (Cookie cookie : cookies){
					if (cookie.getName().equals("token")){
						token = cookie.getValue();
					}
				}
			}
			if (StringUtils.isBlank(token)){
				token = request.getParameter("token");
			}
			logger.debug(token);
			if (StringUtils.isNotBlank(token)){
				User user = userMapper.getUserByToken(token);
				if (user != null){
					ThreadLocalContext.setCurrentUser(user);
					AdminRequired adminAnnotation = method.getAnnotation(AdminRequired.class);
					if (adminAnnotation != null){
						if (!user.getAdmin()){
							ResponseData result = ResponseData.getErrorResult(ErrorCodeEnum.NOT_ADMIN);
							response.setContentType("application/json;charset=UTF-8");
							response.getWriter().write(JacksonUtils.toJson(result));
							return false;
						}
					}
					return super.preHandle(request, response, handler);
				}
			}
			ResponseData result = ResponseData.getErrorResult(ErrorCodeEnum.USER_NOT_LOGIN);
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(JacksonUtils.toJson(result));
			return false;
		}else{
			return super.preHandle(request, response, handler);
		}
	}

}
