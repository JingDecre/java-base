package com.decre.improve.base.javabase.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.Charset;

/**
 * <p>Title: ActiveKeyValueStore</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2019/1/8 0008 22:36
 */
public class ActiveKeyValueStore extends ConnectionWatcher {

    private static final Charset CHARSET = Charset.forName("UTF-8");

    /**
     * 写入节点信息
     *
     * @param path
     * @param value
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void write(String path, String value) throws KeeperException, InterruptedException {
        Stat stat = zk.exists(path, false);
        if (stat == null) {
            zk.create(path, value.getBytes(CHARSET), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } else {
            zk.setData(path, value.getBytes(CHARSET), -1);
        }
    }

    /**
     * 读取节点信息
     *
     * @param path
     * @param watcher
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public String read(String path, Watcher watcher) throws KeeperException, InterruptedException {

        byte[] data = zk.getData(path, watcher, null);
        return new String(data, CHARSET);
    }
}
