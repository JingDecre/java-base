package com.decre.improve.base.javabase.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * <p>Title: IntegerArrayTest</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/31 0031 20:45
 */
public class IntegerArrayTest {

    static int[] value = new int[] {1, 2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
