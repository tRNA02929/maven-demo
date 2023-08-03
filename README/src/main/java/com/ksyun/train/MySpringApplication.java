package com.ksyun.train;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class MySpringApplication implements DisposableBean {

    static ConfigurableApplicationContext context;
    public static void main(String[] args) {
        context = SpringApplication.run(MySpringApplication.class, args);
    }

    @Override
    public void destroy() {
        log.info("destroy spring application");
    }
}
