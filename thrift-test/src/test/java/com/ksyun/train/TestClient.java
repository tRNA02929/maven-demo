package com.ksyun.train;

import com.ksyun.train.thrift.Service;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class TestClient {
    public static void main(String[] args) throws Exception {
        // 初始化Thrift，使用TSocket 进行TCP传输，设置连接到
        try {
            TTransport transport = new TSocket("localhost", 9091);
            transport.open();

            // 使用TBinaryProtocol 序列化协议
             TProtocol protocol = new TBinaryProtocol(transport);
             Service.Client client = new Service.Client(protocol);

             client.sayHello();

            System.out.println("Server started on port 9091...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
