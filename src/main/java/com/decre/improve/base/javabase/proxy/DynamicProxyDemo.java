package com.decre.improve.base.javabase.proxy;

import java.lang.reflect.Proxy;

/**
 * <p>Title: DynamicProxyDemo</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/23 0023 16:37
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        //1.创建委托对象
        RealSubject realSubject = new RealSubject();
        //2.创建调用处理器对象
        SubjectInvocationHandler handler = new SubjectInvocationHandler(realSubject);
        // 3.动态生成代理对象
        Subject proxySubject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), handler);
        // 4.通过代理对象调用方法
        proxySubject.request();
    }
}
