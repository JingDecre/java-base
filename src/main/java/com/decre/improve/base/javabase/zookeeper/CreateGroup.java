package com.decre.improve.base.javabase.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * <p>Title: CreateGroup</p>
 * <p>Description: 创建组</p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2019/1/7 0007 23:05
 */
public class CreateGroup implements Watcher {

    private static final int SESSION_TIMEOUT=5000;

    private ZooKeeper zk;
    private CountDownLatch countDownLatch = new CountDownLatch(1);


    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
        }
    }

    private void close() throws InterruptedException {
        zk.close();
    }

    private void create(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        if (zk.exists(path, false) == null) {
            /*
                创建节点参数：
               路径：用字符串表示。
        　　　　znode的内容：字节数组，本例中使用空值。
        　　　　访问控制列表：简称ACL，本例中使用了完全开放的ACL，允许任何客户端对znode进行读写。
        　　　　创建znode的类型：有两种类型的znode：短暂的和持久的。
            */
            zk.create(path, null/*data*/, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        System.out.println("Created: " + path);

    }

    private void connect(String hosts) throws InterruptedException, IOException {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
        countDownLatch.await();
    }

    public static void main(String[] args) throws InterruptedException, KeeperException, IOException {
        CreateGroup createGroup = new CreateGroup();
        createGroup.connect("192.168.0.125:2181,192.168.0.125:2182,192.168.0.125:2183");
        createGroup.create("zoo");
        createGroup.close();
    }
}
