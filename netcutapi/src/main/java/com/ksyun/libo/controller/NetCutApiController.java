package com.ksyun.libo.controller;

import com.ksyun.libo.service.NetCutApiService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NetCutApiController {
    @Autowired
    private NetCutApiService netCutApiService;

    @RequestMapping("")
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("test")
    public String test() {
        return "test";
    }

    /**
     * 从服务器获取文本
     *
     * @param key
     * @return 文本内容
     */
    @GetMapping("{key}")
    public String getFile(@PathVariable("key") String key) {
        return netCutApiService.getFile(key);
    }


    /**
     * 上传文本到服务器
     *
     * @param key    键
     * @param upload 值
     * @return
     */
    @GetMapping("{key}/{upload}")
    public String postFile(@PathVariable("key") String key, @PathVariable("upload") String upload) {
        return netCutApiService.postFile(key, upload);
    }
}
