package com.ksyun.train;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.utils.CloseableUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestListener {

    //    private static final String ZK_ADDR = "localhost:2181";
    // 使用远程的ZK
    private static final String ZK_ADDR = "hot:80";

    @Test
    public void testConnet() {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDR,
                new RetryNTimes(10, 5000));
        client.start();
        client.close();
    }

    @Test
    public void test() throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDR,
                new RetryNTimes(10, 5000));
        client.start();
        TreeCache treeCache = new TreeCache(client, "/libo14");
        List<TreeCacheEvent> events = new ArrayList<>();
        List<CuratorFramework> clients = new ArrayList<>();
        List<Long> times = new ArrayList<>();
        AtomicBoolean init = new AtomicBoolean(false);
        treeCache.getListenable().addListener((client1, event) -> {
            if (event.getType() == TreeCacheEvent.Type.INITIALIZED) {
                init.set(true);
                return;
            }
            if (!init.get()) {
                return;
            }
            clients.add(client1);
            events.add(event);
            times.add(System.currentTimeMillis());
            System.out.println("event: " + event.getType());
            System.out.println("data: " + Optional.ofNullable(event.getData())
                    .map(ChildData::getData)
                    .map(String::new)
                    .orElse("null"));
            if (event.getType().equals(TreeCacheEvent.Type.NODE_REMOVED)) {
                treeCache.close();
                client.close();
                CloseableUtils.closeQuietly(treeCache);
            }
        });
        treeCache.start();

        while (!client.getState().equals(CuratorFrameworkState.STOPPED)) {
            Thread.sleep(1000);
        }

        System.out.println("events: " + events.size());
        clients.stream().forEach(c -> System.out.println(c.getNamespace()));
        System.out.println("====================================");
        events.stream().forEach(event -> {
            System.out.println("event: " + event.getType());
            ChildData d = event.getData();
            if (d != null) {
                System.out.println("data:" + new String(d.getData())
                        + "\npath:" + d.getPath());
            }
            System.out.println("====================================");
        });
        System.out.println("====================================");
        times.stream().forEach(System.out::println);
    }
}
