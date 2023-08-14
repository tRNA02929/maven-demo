package com.ksyun.train.akka.server;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.HashMap;
import java.util.Map;

public class ServerApp {
    public static void main(String[] args) {
       // Map<String, Object> map=new HashMap<>();
//        map.put("akka.actor.provider", "remote");
//        map.put("akka.remote.artery.enabled", true); // 使用 Artery
//        map.put("akka.remote.artery.transport", "tcp"); // 可以选择 "tcp" 或 "aeron-udp"
//        map.put("akka.remote.artery.canonical.hostname", "127.0.0.1");
//        map.put("akka.remote.artery.canonical.port", 2551);
        //
        Map<String, Object> map=new HashMap<>();
        map.put("akka.actor.provider","remote");
        map.put("akka.remote.transport","akka.remote.netty.NettyRemoteTransport");
        map.put("akka.remote.netty.tcp.hostname","127.0.0.1");
        map.put("akka.remote.netty.tcp.port",2551);

        Config config = ConfigFactory.parseMap(map).withFallback(ConfigFactory.load());

        ActorSystem system = ActorSystem.create("ServerSystem", config);
        ActorRef serverActorRef = system.actorOf(Props.create(ServerActor.class), "ServerActor");
        System.out.println("ServerActor started at: " + serverActorRef.path().toString());
    }
}
