package com.ksyun.train.thrift.service;


import com.ksyun.train.thrift.HelloMsg;
import com.ksyun.train.thrift.MyRequestMsg;
import com.ksyun.train.thrift.MyResponseMsg;
import com.ksyun.train.thrift.Service;

public class ServiceImpl implements Service.Iface {

    @Override
    public HelloMsg sayHello() {
        HelloMsg helloMsg = new HelloMsg();
        helloMsg.setMsg("Hello from the server!");
        return helloMsg;
    }

    @Override
    public MyResponseMsg ask(MyRequestMsg request) {
        MyResponseMsg response = new MyResponseMsg();
        response.setStatus(true);
        response.setNo(request.getNo());
        response.setMsg("Server received message: " + request.getMsg());
        return response;
    }
}
