package com.decre.improve.base.javabase.java8;

import java.util.function.Supplier;

/**
 * <p>Title: Car</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/27 0027 22:04
 */
public class Car {

    //Supplier是jdk1.8的接口，这里和lamda一起使用了，其接口如下
    /*@FunctionalInterface
    public interface Supplier<T> {
        T get();
    }*/
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.getName());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.getName());
    }

    public void repair() {
        System.out.println("Repaired " + this.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
