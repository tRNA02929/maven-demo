package com.ksyun.train;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.junit.Test;
import org.apache.curator.framework.recipes.cache.*;

import java.util.Optional;

public class TestListener {

    private static final String ZK_ADDR = "localhost:2181";

    @Test
    public void test() throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDR,
                new RetryNTimes(10, 5000));
        client.start();
        TreeCache treeCache = new TreeCache(client, "/libo14");
        treeCache.getListenable().addListener((client1, event) -> {
            System.out.println("event: " + event.getType());
            System.out.println("data: " + Optional.ofNullable(event.getData())
                    .map(ChildData::getData)
                    .map(String::new)
                    .orElse("null"));
        });
        treeCache.start();

        Thread.sleep(10000);

        treeCache.close();
        client.close();
    }
}
