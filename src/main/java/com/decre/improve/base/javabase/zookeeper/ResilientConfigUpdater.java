package com.decre.improve.base.javabase.zookeeper;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: ResilientConfigUpdater</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2019/1/8 0008 23:25
 */
public class ResilientConfigUpdater {

    public static final String PATH = "/config";
    private ChangedActiveKeyValueStore store;
    private Random random = new Random();

    public ResilientConfigUpdater(String hosts) throws IOException, InterruptedException {
        store = new ChangedActiveKeyValueStore();
        store.connect(hosts);
    }

    public void run() throws InterruptedException, KeeperException {
        while (true) {
            String value = random.nextInt(100) + "";
            store.write(PATH, value);
            System.out.printf("Set %s to %s\n", PATH, value);
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        }
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            try {
                ResilientConfigUpdater configUpdater = new ResilientConfigUpdater("192.168.0.125:2181");
                configUpdater.run();
            } catch (KeeperException.SessionExpiredException e) {
                // start a new session
            } catch (KeeperException e) {
                // already retried ,so exit
                e.printStackTrace();
                break;
            }
        }
    }
}
