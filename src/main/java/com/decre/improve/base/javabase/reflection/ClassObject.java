package com.decre.improve.base.javabase.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>Title: ClassObject</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/22 0022 21:09
 */
public class ClassObject {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class cla = Class.forName("java.lang.String"); //要带包名才能获取
        System.out.println(cla.getSimpleName());

        Class str = String.class;
        int modifiers = str.getModifiers(); //修饰符被打包成一个int，每个修饰符是一个标志位，可以被置位或清零
        System.out.println(modifiers); // 标志位17

        Class intClass = Integer.TYPE; // 只对于基本类型和 void 的包装类
        System.out.println(str.getSimpleName());
        System.out.println(intClass.getSimpleName());

        Class strObj = "test".getClass();
        System.out.println(strObj.getSimpleName());

        boolean instance = "test" instanceof String;
        System.out.println(instance);

        //获取String所对应的Class对象
        Class<?> c = String.class;
        String test = new String("test");
        Annotation[] annotations = c.getAnnotations();

        Field[] fields = c.getFields();

        Constructor[] constructors = c.getConstructors();

        Method[] method = c.getMethods();

        Class superclass = c.getSuperclass();
        System.out.println(superclass.getSimpleName());

        Package packageObj = c.getPackage();
        System.out.println(packageObj.getName());


        //获取String类带一个String参数的构造器
        Constructor constructor = c.getConstructor(String.class);
        //根据构造器创建实例
        Object obj = constructor.newInstance("23333");
        System.out.println(obj);




    }
}
