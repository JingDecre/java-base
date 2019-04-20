package com.decre.improve.base.javabase.thread;

/**
 * <p>Title: ImplRunnable</p>
 * <p>Description: 通过实现Runnable接口创建一个线程</p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/24 0024 21:32
 */
public class ImplRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("I'm running!(Runnable)");
        System.out.println(Thread.currentThread().getName());
    }
}
