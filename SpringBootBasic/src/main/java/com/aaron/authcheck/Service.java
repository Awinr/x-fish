package com.aaron.authcheck;

import org.springframework.stereotype.Component;

@Component
public class Service {

    @AuthCheck(role = "admin")
    public String serviceExecute() {
        System.out.println("开始执行业务。");
        return "业务执行成功！";
    }
}
