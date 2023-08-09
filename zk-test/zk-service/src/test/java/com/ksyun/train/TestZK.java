package com.ksyun.train;

import com.ksyun.train.conf.PropertiesConf;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Import(PropertiesConf.class)
public class TestZK {

    @Autowired
    private PropertiesConf propertiesConf;

//    private static final String ZK_ADDR = "localhost:2181";
    // 使用远程的ZK
    private static final String ZK_ADDR = "hot:80";

    @Test
    public void testGet() throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDR,
                new RetryNTimes(10, 5000));
        client.start();
        try {
            List<String> list = client.getChildren().forPath("/libo13/1");
            System.out.println(list);
        } catch (Exception e) {
            System.out.println("no node");
        }
        client.close();
    }

    @Test
    public void testCreate() throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDR,
                new RetryNTimes(10, 5000));
        client.start();
        try {
            client.create().forPath("/libo14", "hello".getBytes());
        } catch (Exception e) {
            System.out.println("node exists");
        }
        client.close();
    }

    @Test
    public void testListener() throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDR,
                new RetryNTimes(10, 5000));
        client.start();

        try {
            client.create().forPath("/libo14", "hello".getBytes());
        } catch (Exception e) {
            System.out.println("node exists");
        }
        System.out.println("create node");
        client.setData().forPath("/libo14", "hello2".getBytes());
        client.setData().forPath("/libo14/1", "hello3".getBytes());
//        client.delete().forPath("/libo14");

        client.close();
    }
}
