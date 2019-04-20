package com.decre.improve.base.javabase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: ThreadMain</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/24 0024 21:34
 */
public class ThreadMain {

    public static void main(String[] args) {
       /* //线程是继承Thread类
        ExtendThread t1 = new ExtendThread();
        t1.run();

        // 实现Runnable接口
        ImplRunnable tt = new ImplRunnable();
        Thread t2 = new Thread(tt);
        t2.run();*/

       /* // 1.newFixedThreadPool创建一个可重用固定线程数，以共享的无界队列方式来运行这些线程
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            ImplRunnable syncRun = new ImplRunnable();
            executorService.execute(syncRun);
        }

        // 2.newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            ImplRunnable syncRun = new ImplRunnable();
            executorService1.execute(syncRun);
        }*/


       // 3.newScheduledThreadPool创建一个定长线程池，支持定时及周期性任务执行,
        ScheduledExecutorService executorService2 = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 20; i++) {
            ImplRunnable syncRun = new ImplRunnable();
            // 和newFixedThreadPool类似,只是延时进行
            executorService2.schedule(syncRun, 5000, TimeUnit.MILLISECONDS);
            // 创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；也就是将在 initialDelay 后开始执行，然后在initialDelay+period 后执行，接着在 initialDelay + 2 * period 后执行
            executorService2.scheduleAtFixedRate(syncRun, 5000, 3000, TimeUnit.MILLISECONDS);
            //创建并执行一个在给定初始延迟后首次启用的定期操作，随后，在每一次执行终止和下一次执行开始之间都存在给定的延迟
            executorService2.scheduleWithFixedDelay(syncRun, 5000, 3000, TimeUnit.MILLISECONDS);
        }

        // 4.newSingleThreadExecutor创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            ImplRunnable syncRun = new ImplRunnable();
            executorService3.execute(syncRun);
        }

    }
}
