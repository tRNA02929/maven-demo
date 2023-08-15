package com.ksyun.test;

import com.ksyun.test.thrift.Service;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

public class TestServer {
    public static void main(String[] args) throws Exception {
        try {
            ServiceImpl service = new ServiceImpl();
            // 创建Service的处理器，并关联到ServiceImpl的实现。
            Service.Processor<ServiceImpl> processor = new Service.Processor<>(service);
            // 使用TServerSocket进行TCP传输，设置服务端口为9091
            TServerSocket serverSocket = new TServerSocket(9091);
            // 使用特定的序列化协议
            TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();
            // 创建并启动Thrift服务器
            TServer server = new TSimpleServer(
                    new TServer.Args(serverSocket).processor(processor).protocolFactory(protocolFactory));
            System.out.println("Server started on port 9091...");
            server.serve();
            service.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
