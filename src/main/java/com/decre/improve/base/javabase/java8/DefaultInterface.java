package com.decre.improve.base.javabase.java8;

/**
 * <p>Title: DefaultInterface</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/27 0027 23:21
 */
public interface DefaultInterface {

    public static void main(String[] args) {
        Vehicle vehicle = new CarTest();
        vehicle.print();
    }

    interface Vehicle {
        default void print(){
            System.out.println("我是一辆车!");
        }

        static void blowHorn(){
            System.out.println("按喇叭!!!");
        }
    }

    interface FourWheeler {
        default void print(){
            System.out.println("我是一辆四轮车!");
        }
    }

    class CarTest implements Vehicle, FourWheeler {
        public void print(){
            Vehicle.super.print();
            FourWheeler.super.print();
            Vehicle.blowHorn();
            System.out.println("我是一辆汽车!");
        }
    }

}


