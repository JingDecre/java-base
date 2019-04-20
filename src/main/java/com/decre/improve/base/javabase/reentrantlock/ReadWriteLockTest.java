package com.decre.improve.base.javabase.reentrantlock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * <p>Title: ReadWriteLockTest</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/31 0031 20:06
 */
public class ReadWriteLockTest {

    private Object data = null;

    ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 读数据，可以多个线程同时读，所以上读锁即可
     */
    public void get() {
        /*上读锁*/
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 准备读数据!");
            /* 休眠 */
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + "读出的数据为 :" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * 写数据，多个线程不能同时写，必须上写锁
     * @param data
     */
    public void put(Object data) {

        /*上写锁*/
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 准备写数据!");
            /* 休眠 */
            Thread.sleep((long) (Math.random() * 1000));
            this.data = data;
            System.out.println(Thread.currentThread().getName() + "写入的数据为 :" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }

    }

    public static void main(String[] args) {
        final ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();

        IntStream.range(0, 3).forEach( i -> {
            /* 创建并启动3个读线程 */
            new Thread(() -> readWriteLockTest.get()).start();
            /*创建3个写线程*/
            new Thread(() -> readWriteLockTest.put(new Random().nextInt(8))).start();
        });



    }

}
