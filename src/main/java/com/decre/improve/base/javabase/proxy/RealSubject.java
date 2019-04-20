package com.decre.improve.base.javabase.proxy;

/**
 * <p>Title: RealSubject</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/23 0023 16:34
 */
public class RealSubject  implements Subject {
    public void request() {
        System.out.println("request");
    }
}