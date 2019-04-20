package com.decre.improve.base.javabase.test;

/**
 * <p>Title: SubStringTest</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2019/3/8 0008 22:04
 */
public class SubStringTest {

    public static void main(String[] args) {
        String str = "xxxx.pdf".substring(0, "xxxx.pdf".lastIndexOf(".pdf"));
        System.out.println(str);
    }
}
