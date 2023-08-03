package com.ksyun.train.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
public class TestApiController {

    @RequestMapping("/")
    public Object hello() {
        log.info("hello world");
        return "hello world";
    }

}
