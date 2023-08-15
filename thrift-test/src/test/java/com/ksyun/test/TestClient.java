package com.ksyun.test;

import com.ksyun.test.thrift.*;
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

            LoginReq req = new LoginReq("admin", "admin");
            LoginResp resp = client.login(req);
            if (resp != null && resp.getToken().split("@")[0].equals("admin")) {
                System.out.println("Login success! Login token: " + resp.getToken());
            } else {
                System.out.println("Login failed!");
                boolean b = client.register(new RegisterReq("admin", "admin"));
                if (b) {
                    System.out.println("Register success!");
                } else {
                    System.out.println("Register failed!");
                }
                resp = client.login(req);
            }

            while (true) {
                System.out.print("input 'exit' to logout:");
                int ch;
                StringBuilder sb = new StringBuilder();
                while ((ch = System.in.read()) != '\n') {
                    sb.append((char) ch);
                }
                // sb 转换为 utf-8 string
                String msg = new String(sb.toString().getBytes("ISO-8859-1"), "UTF-8");
                if (msg.equals("exit")) {
                    client.logout(new LogoutReq(resp.getToken()));
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
