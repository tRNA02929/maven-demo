package com.ksyun.train.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
public class TestApiController {

    @RequestMapping("/")
    @ResponseStatus(value = HttpStatus.OK, reason = "ok")
    public Object hello() {
        log.info("hello world");
        return "hello world";
    }

    @RequestMapping("/1")
    public Object hello1() {
        log.info("hello world 1");
        return ResponseEntity.ok().body("hello world");
    }

    @RequestMapping("/2")
    public Object hello2() {
        log.error("hello world 2");
        return ResponseEntity.status(203).body("hello world");
    }

}
