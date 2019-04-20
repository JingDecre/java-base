package com.decre.improve.base.javabase.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.io.IOException;

/**
 * <p>Title: ConfigWatcher</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2019/1/8 0008 22:51
 */
public class ConfigWatcher implements Watcher {

    private ActiveKeyValueStore store;

    @Override
    public void process(WatchedEvent watchedEvent) {

    }

    public ConfigWatcher(String hosts) throws IOException, InterruptedException {
        this.store = new ActiveKeyValueStore();
        this.store.connect(hosts);
    }

    public void dispalyConfig() throws KeeperException, InterruptedException {
        String value = store.read(ConfigUpdater.PATH, this);
        System.out.printf("Read %s as %s\n", ConfigUpdater.PATH, value);
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ConfigWatcher configWatcher = new ConfigWatcher("192.168.0.125:2181");
        configWatcher.dispalyConfig();
        //stay alive until process is killed or Thread is interrupted
        Thread.sleep(Long.MAX_VALUE);
    }

}
