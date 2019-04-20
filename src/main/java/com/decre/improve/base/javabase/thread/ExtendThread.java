package com.decre.improve.base.javabase.thread;

/**
 * <p>Title: ExtendThread</p>
 * <p>Description: 使用继承java.lang.Thread类的方式创建一个线程</p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/24 0024 21:31
 */
public class ExtendThread extends Thread {

    /**
     * 重写（Override）run()方法 JVM会自动调用该方法
     */
    @Override
    public void run() {
        System.out.println("It's running");
    }

    /**
     * 重载（Overload）run()方法 和普通的方法一样，并不会在该线程的start()方法被调用后被JVM自动运行
     */
    public void run(int times) {
        System.out.println("I'm running!(Overload)");
    }
}
