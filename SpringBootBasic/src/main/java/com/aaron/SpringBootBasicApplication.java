package com.aaron;

import com.aaron.config.MPConfig;
import com.aaron.designPattern.PayChannelEnum;
import com.aaron.designPattern.PayFactory;
import com.aaron.designPattern.PayHandler;
import com.aaron.pojo.Book;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@Import(MPConfig.class)
@SpringBootApplication
public class SpringBootBasicApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootBasicApplication.class, args);

    }

}
