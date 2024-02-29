package com.aaron.Exception;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 在这里进行判断是否需要对当前请求进行响应体处理
        // 这里可以根据方法参数、类信息等来决定是否进行处理
        Annotation[] methodAnnotations = methodParameter.getMethodAnnotations();
        Method method = methodParameter.getMethod();
        Class<?> declaringClass = methodParameter.getDeclaringClass();
        return true; // 假设始终进行响应体处理
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 在这里进行响应体处理逻辑
        return o; // 假设直接返回原始对象
    }
}
