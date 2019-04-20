package com.decre.improve.base.javabase.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Title: IntegerTest</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/31 0031 20:36
 */
public class IntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}
