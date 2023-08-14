package com.ksyun.train;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.ksyun.train.akka.client.ClientActor;
import com.ksyun.train.akka.server.ServerActor;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestAkka {
    @Test
    public void test() {
        System.out.println("hello world");
    }

    @Test
    public void testServer() {
        Map<String, Object> map = new HashMap<>();
        map.put("akka.actor.provider", "remote");
        map.put("akka.remote.transport", "akka.remote.netty.NettyRemoteTransport");
        map.put("akka.remote.netty.tcp.hostname", "127.0.0.1");
        map.put("akka.remote.netty.tcp.port", 2551);

        Config config = ConfigFactory.parseMap(map).withFallback(ConfigFactory.load());

        ActorSystem system = ActorSystem.create("ServerSystem", config);
        ActorRef serverActorRef = system.actorOf(Props.create(ServerActor.class), "ServerActor");
        System.out.println("ServerActor started at: " + serverActorRef.path().toString());
    }

    @Test
    public void testClient() {
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