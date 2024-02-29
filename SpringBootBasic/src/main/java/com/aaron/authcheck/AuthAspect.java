package com.aaron.authcheck;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuthAspect {

    @Around("@annotation(authCheck)")
    public Object doCheck(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        String role = authCheck.role();
        if (role.equals("admin")) {
            System.out.println("权限校验成功！");
        }
        Object o = joinPoint.proceed();
        return o;
    }
}
