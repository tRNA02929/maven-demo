package com.ksyun.train;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MySpringApplication implements DisposableBean {

    static ConfigurableApplicationContext context;
    public static void main(String[] args) {
        context = SpringApplication.run(MySpringApplication.class, args);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
