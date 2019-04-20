package com.decre.improve.base.javabase.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: MethodReferences</p>
 * <p>Description: 方法调用</p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/27 0027 22:02
 */
public class MethodReferences {

    public static void main(String[] args) {
        // 构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
        final Car car = Car.create(Car::new);
        car.setName("BWM");
        final List<Car> cars = Arrays.asList(car);

        // 静态方法引用：它的语法是Class::static_method，实例如下：
        cars.forEach(Car::collide);

        // 特定类的任意对象的方法引用：它的语法是Class::method实例如下：
        cars.forEach(Car::repair);

        //特定对象的方法引用：它的语法是instance::method实例如下：
        final Car police = Car.create(Car::new);
        police.setName("Police");
        // 虽然用了police来调用follow，但是仍然输出BWM，因为police没有放入集合当中
        // 特定对象不能调用静态方法
        cars.forEach(police::follow);

        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}
