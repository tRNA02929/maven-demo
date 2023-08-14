package com.ksyun.train.akka.server;

import akka.actor.AbstractActor;

public class ServerActor extends AbstractActor {

    int count = 0;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("hello", message -> {
                    System.out.print("received hello from client, count:"+ count++ +" message:"+ message);
                    getSender().tell("Hello from Acoter Server!",getSelf());
                    count++;
                })
                .match(String.class, message -> {
                    System.out.println("Server received: " + message);
                    getSender().tell("Server response, count:"+ count +" message:"+ message , getSelf());
                    count++;
                })
                .build();
    }
}
