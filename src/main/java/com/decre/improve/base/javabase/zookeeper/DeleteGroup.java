package com.decre.improve.base.javabase.zookeeper;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.List;

/**
 * <p>Title: DeleteGroup</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2019/1/7 0007 23:57
 */
public class DeleteGroup extends ConnectionWatcher {

    public void delete(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        List<String> children;

        children = zk.getChildren(path, false);
        children.forEach(s -> {
            try {
                zk.delete(path + "/" +s, -1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (KeeperException e) {
                System.out.printf("Group %s does not exist\n", groupName);
                System.exit(1);
            }
        });
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        DeleteGroup deleteGroup = new DeleteGroup();
        deleteGroup.connect("192.168.0.125:2181");
        deleteGroup.delete("zoo");
        deleteGroup.close();
    }

}
