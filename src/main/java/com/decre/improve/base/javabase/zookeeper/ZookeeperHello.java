package com.decre.improve.base.javabase.zookeeper;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * <p>Title: ZookeeperHello</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2019/1/6 0006 22:46
 */
public class ZookeeperHello {

    private static final String CONNECT_STRING = "hadoop1:2181,hadoop2:2181,hadoop3:2181";
    //如果zookeeper使用的是默认端口的话，此处可以省略端口号
    //private static final String CONNECT_STRING = "hadoop1,hadoop2,hadoop3";

    //设置超时时间
    private static final int SESSION_TIMEOUT = 5000;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper(CONNECT_STRING, SESSION_TIMEOUT, new DemoWatcher());
        String node = "/aa";
        Stat stat = zk.exists(node, false);
        if (stat == null) {
            String createResult = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createResult);
        }
        //获取节点的值
        byte[] b = zk.getData(node, false, stat);
        System.out.println("----------" + new String(b));
        zk.close();
    }


    static class DemoWatcher implements Watcher {

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println("----->");
            System.out.println("path: " + watchedEvent.getPath());
            System.out.println("type: " + watchedEvent.getType());
            System.out.println("state: " + watchedEvent.getState());
            System.out.println("<---------------");
        }
    }
}
