package com.bf.blog;

import com.bf.blog.interceptor.AccessLogInterceptor;
import com.bf.blog.interceptor.AuthenticationInterceptor;
import com.bf.blog.interceptor.PerformanceLogInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhubin on 2017/2/7.
 */
@Configuration
public class BfstackConfig extends WebMvcConfigurerAdapter {

    @Bean
    public AuthenticationInterceptor authInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Bean
    public AccessLogInterceptor accessLogInterceptor() {
        return new AccessLogInterceptor();
    }
    @Bean
    public PerformanceLogInterceptor perfLogInterceptor() {
        return new PerformanceLogInterceptor();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(perfLogInterceptor());
        registry.addInterceptor(authInterceptor());
        registry.addInterceptor(accessLogInterceptor());
    }
}