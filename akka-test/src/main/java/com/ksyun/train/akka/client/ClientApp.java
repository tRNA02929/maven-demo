package com.ksyun.train.akka.client;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.time.Duration;

public class ClientApp {
    public static void main(String[] args) {
        Config config = ConfigFactory.parseString(
                        "akka.actor.provider = remote\n" +
                           "akka.remote.transport = akka.remote.netty.NettyRemoteTransport\n" +
                           "akka.remote.netty.tcp.hostname = 127.0.0.1\n" +
                           "akka.remote.netty.tcp.port = 2550\n"
        ).withFallback(ConfigFactory.load());

        ActorSystem system = ActorSystem.create("ClientSystem", config);
        ActorRef clientActorRef = system.actorOf(Props.create(ClientActor.class), "clientActor");
        System.out.println("clientActor started at: " + clientActorRef.path().toString());

        String remoteHost="127.0.0.1";
        int port= 2551;
        String serverActorPath = "akka.tcp://ServerSystem@"+remoteHost+":"+port+"/user/ServerActor";
        ActorRef serverRef = system.actorSelection(serverActorPath)
                .resolveOne(Duration.ofSeconds(3)).toCompletableFuture().join();
        serverRef.tell("hello", clientActorRef);
    }
}
