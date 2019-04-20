package com.decre.improve.base.javabase.synchronize;

import java.util.stream.IntStream;

/**
 * <p>Title: Thread2</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/31 0031 16:25
 */
public class Thread3 {

    // 有同步代码块
    public void t1() {
        synchronized (this) {
            IntStream.iterate(7, e -> e - 1).limit(7).forEach(i -> {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            });
        }
    }

    // y有同步代码块
    public void t2() {
        synchronized (this) {
            IntStream.iterate(5, e -> e - 1).limit(7).forEach(i -> {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            });
        }
    }


    public static void main(String[] args) {
        final Thread3 test = new Thread3();
        Thread ta = new Thread(() -> test.t1(), "ta");
        Thread tb = new Thread(() -> test.t2(), "tb");
        ta.start();
        tb.start();
    }

}
