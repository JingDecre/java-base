package com.decre.improve.base.javabase.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: ZKTest</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2019/4/22 0022 23:50
 */
public class ZKTest {

    private static final String CONNECT_STRING = "hadoop1:2181,hadoop2:2181,hadoop3:2181";
    private static final int SESSION_TIMEOUT = 5000;
    private static ZooKeeper zk = null;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        zk = new ZooKeeper(CONNECT_STRING, SESSION_TIMEOUT, null);
        //1、级联查看某节点下所有节点及节点值
        Map<String, String> map = new HashMap<>();
        Map<String, String> maps = ZKUtil.getChildNodeAndValue("/a", zk, map);
        maps.forEach((key, value) -> System.out.println(key + "\t" + value));
        //2、删除一个节点，不管有有没有任何子节点
        boolean flag = ZKUtil.rmr("/x", zk);
        if (flag) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败");
        }
        //3、级联创建任意节点
        boolean createZNode = ZKUtil.createZNode("/x/y/z/bb", "bb", zk);
        if (createZNode) {
            System.out.println("创建成功！");
        } else {
            System.out.println("创建失败");
        }
        //4、清空子节点
        boolean clearChildNode = ZKUtil.clearChildNode("/x", zk);
        if (clearChildNode) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败");
        }

        zk.close();
    }
}
