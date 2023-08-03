package com.ksyun.train;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        Properties properties = System.getProperties();
        Properties properties1 = new Properties();
        String temp = System.getProperty("zookeeper.addr");
        if (temp == null) {
            throw new Exception("zookeeper.addr is null");
        }
        System.out.println(temp);
        properties.load(Main.class.getClassLoader().getResourceAsStream("zoo.properties"));
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