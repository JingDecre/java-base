package com.decre.improve.base.javabase.proxy;

/**
 * <p>Title: StaticPro</p>
 * <p>Description: 静态代理,编译时就已加载</p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/23 0023 16:15
 */
public class StaticPro {

    public static void main(String args[]) {
        RealSubject subject = new RealSubject();
        Proxy p = new Proxy(subject);
        p.request();
    }

}


class Proxy implements Subject {
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    public void request() {
        System.out.println("PreProcess");
        subject.request();
        System.out.println("PostProcess");
    }
}

