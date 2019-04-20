package com.decre.improve.base.javabase.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * <p>Title: ReentrantLockTest</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/31 0031 17:11
 */
public class ReentrantLockTest implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        IntStream.range(0, 2000).forEach(n -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " " + i);
                i++;
            } finally {
                lock.unlock();
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest test = new ReentrantLockTest();
        Thread t1 = new Thread(test, "t1");
        Thread t2 = new Thread(test, "t2");
        t1.start();
        t2.start();
        t1.join(); // 在当前线程中按顺序执行
        t2.join(); // 在当前线程中按顺序执行
        System.out.println(i);

    }
}
