package com.decre.improve.base.javabase.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * <p>Title: SubjectInvocationHandler</p>
 * <p>Description: 调用处理类</p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/23 0023 16:24
 */
public class SubjectInvocationHandler implements InvocationHandler {

    private Subject subject;

    public SubjectInvocationHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*针对每个方法前后进行输出信息*/
        System.out.println("====before====");//定义预处理的工作，当然你也可以根据 method 的不同进行不同的预处理工作
        Object result = method.invoke(subject, args);
        System.out.println("====after====");

        /*可以通过方法名称对特定方法前后进行某种操作*/
        if ("request".equals(method.getName())) {
            System.out.println("request ...");
            method.invoke(subject, args);
        }

        return result;
    }
}
