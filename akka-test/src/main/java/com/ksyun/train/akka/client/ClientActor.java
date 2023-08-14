package com.ksyun.train.akka.client;

import akka.actor.AbstractActor;

public class ClientActor extends AbstractActor {


    @Override
    public  void preStart() throws Exception {
        System.out.println("preStart");
        super.preStart();
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    //使用 黄色字体 打印 response2
                    System.out.println("\033[33;4m" + message + "\033[0m");
                    System.out.print("Please input your message:");
                    int ch;
                    StringBuilder sb = new StringBuilder();
                    while ((ch = System.in.read()) != '\n') {
                        sb.append((char) ch);
                    }
                    // sb 转换为 utf-8 string
                    String msg = new String(sb.toString().getBytes("ISO-8859-1"),"UTF-8");
                    if (msg.equals("exit")) {
                        System.exit(0);
                    }
                    getSender().tell(msg, getSelf());

                })
                .matchEquals("start", message -> {
                    getSender().tell("", getSelf());
                })
                .build();
    }
}
