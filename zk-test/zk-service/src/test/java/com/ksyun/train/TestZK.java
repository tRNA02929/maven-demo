package com.ksyun.train;

import com.google.common.collect.Lists;
import com.ksyun.train.conf.PropertiesConf;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
@Import(PropertiesConf.class)
public class TestZK {
    private static final String ZK_ADDR = "hot:80";

    @Test
    public void testGet() {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDR,
                new RetryNTimes(10, 5000));
        client.start();
        List<String> list;
        try {
            list = client.getChildren().forPath("/");
            System.out.println(list);
        } catch (Exception e) {
            list = Lists.newArrayList();
            System.out.println("no node");
        }
        client.close();
        list.forEach(System.out::println);
    }

    @Test
    public void testCreate() {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDR,
                new RetryNTimes(10, 5000));
        client.start();
        try {
            if (client.checkExists().forPath("/libo14") == null) {
                client.create().withMode(CreateMode.EPHEMERAL).forPath("/libo14", "hello".getBytes());
                System.out.println("create node");
            } else {
                System.out.println(System.currentTimeMillis());
                client.setData().forPath("/libo14", "hello".getBytes());
                System.out.println(System.currentTimeMillis());
                System.out.println("node exists");
            }
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
