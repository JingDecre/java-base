package com.decre.improve.base.javabase.zookeeper;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: ConfigUpdater</p>
 * <p>Description: 更新配置属性</p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2019/1/8 0008 22:42
 */
public class ConfigUpdater {

    public static final String PATH = "/config";

    private ActiveKeyValueStore store;
    private Random random = new Random();

    public ConfigUpdater(String hosts) throws IOException, InterruptedException {
        this.store = new ActiveKeyValueStore();
        this.store.connect(hosts);
    }

    /**
     * 永远在循环，在随机时间以随机值更新/config znode。
     *
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void run() throws KeeperException, InterruptedException {
        while (true) {
            String value = random.nextInt(100) + "";
            store.write(PATH, value);
            System.out.printf("Set %s to %s\n", PATH, value);
            TimeUnit.SECONDS.sleep(random.nextInt(100));
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ConfigUpdater configUpdater = new ConfigUpdater("192.168.0.125:2181");
        configUpdater.run();
    }
}
