package com.ksyun.train;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        Properties properties = System.getProperties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
        String address = properties.getProperty("zookeeper.addr");

        ZooKeeper zk = new ZooKeeper(address, 20000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                String path = watchedEvent.getPath();
                Watcher.Event.KeeperState state = watchedEvent.getState();
                Watcher.Event.EventType type = watchedEvent.getType();
            }
        });
        List<String> list = zk.getChildren("/", true);
        zk.getEphemerals("/");

        System.out.println(list);
    }
}