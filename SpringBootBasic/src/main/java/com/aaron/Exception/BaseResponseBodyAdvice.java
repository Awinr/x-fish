package com.aaron.Exception;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

@ControllerAdvice
public class BaseResponseBodyAdvice implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        AnnotatedElement annotatedElement = returnType.getAnnotatedElement();
        Class<?> declaringClass = returnType.getDeclaringClass();
        Method method = returnType.getMethod();
        Annotation[] methodAnnotations = returnType.getMethodAnnotations();
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {

        // 遇到feign接口之类的请求, 不应该再次包装,应该直接返回
        // 上述问题的解决方案: 可以在feign拦截器中,给feign请求头中添加一个标识字段, 表示是feign请求
        // 在此处拦截到feign标识字段, 则直接放行 返回body.

        System.out.println("响应拦截成功");

        if (body instanceof BaseResponse) {
            return body;
        } else if (body == null) {
            return BaseResponse.ok();
        } else {
            return BaseResponse.ok(body);
        }
    }
}
