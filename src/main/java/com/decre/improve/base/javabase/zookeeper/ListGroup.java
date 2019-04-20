package com.decre.improve.base.javabase.zookeeper;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.List;

/**
 * <p>Title: ListGroup</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2019/1/7 0007 23:34
 */
public class ListGroup extends ConnectionWatcher{

    public void list(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        try {
            List<String> children = zk.getChildren(path, false);
            if (children.isEmpty()) {
                System.out.printf("No members in group %s\n", groupName);
                System.exit(1);
            }

            children.forEach(System.out::println);
        } catch (KeeperException.NoNodeException e) {
            System.out.printf("Group %s does not exist \n", groupName);
            System.exit(1);
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ListGroup listGroup = new ListGroup();
        listGroup.connect("192.168.0.125:2181");
        listGroup.list("zoo");
        listGroup.close();
    }
}
