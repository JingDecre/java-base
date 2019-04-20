package com.decre.improve.base.javabase.synchronize;

import java.util.stream.IntStream;

/**
 * <p>Title: Thread1</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/31 0031 16:14
 */
public class Thread1 implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            IntStream.range(0, 5).forEach(i -> System.out.println(Thread.currentThread().getName() + " synchronized loop " + i));
        }
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread ta = new Thread(t1, "A");
        Thread tb = new Thread(t1, "B");
        ta.start();
        tb.start();

    }
}
