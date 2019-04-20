package com.decre.improve.base.javabase.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Title: ThreadPoolExecutorTest</p>
 * <p>Description: 阿里规范使用</p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/24 0024 23:53
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args){
        TestThreadFactory testThreadFactory = new TestThreadFactory();

        // 默认策略，直接抛出异常
        RejectedExecutionHandler abortPolicyHandler = new ThreadPoolExecutor.AbortPolicy();

        // 丢弃任务，不抛出异常
        RejectedExecutionHandler discardPolicyHandler = new ThreadPoolExecutor.DiscardPolicy();

        // 丢弃队列最前面的任务，重新尝试执行任务
        RejectedExecutionHandler discardOldestPolicyHandler = new ThreadPoolExecutor.DiscardOldestPolicy();

        // 由调用线程处处理该任务-移交给主线程执行(谨慎使用)
        RejectedExecutionHandler CallerRunsPolicyHandler = new ThreadPoolExecutor.CallerRunsPolicy();


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,
                10,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(
                        1),
                testThreadFactory,
                CallerRunsPolicyHandler);
        System.out.println(threadPoolExecutor.getPoolSize());
        for (int i = 0; i <= 15; i++){
            threadPoolExecutor.execute(() -> {
                System.out.println("hello Jules, I am [" + Thread.currentThread().getName() + "]");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadPoolExecutor.getPoolSize());

    }

    /**
     * 利用TestThreadFactory修改线程名称
     */
    static class TestThreadFactory implements ThreadFactory {
        private AtomicInteger threadNum = new AtomicInteger(0);
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("test-thread-pool-" + threadNum.incrementAndGet());
            return t;
        }
    }

}
