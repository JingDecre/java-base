package com.decre.improve.base.javabase.java8;

/**
 * <p>Title: LambdaExpression</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/27 0027 21:43
 */
public class LambdaExpression {

    public static void main(String[] args) {
        LambdaExpression tester = new LambdaExpression();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 用括号
        GreetingService greetingService = message -> {
            System.out.println("Hello " + message);
        };

        // 不用括号
        GreetingService greetingService1 = message -> System.out.println("Hello " + message);

        greetingService.sayMessage("Today");
        greetingService1.sayMessage("Tomorrow");

        final int num = 1;
        Converter<Integer, Integer> converter =  a -> System.out.println(a + num);
        converter.convert(3);
    }

    interface MathOperation {
        int operation(int a, int b);

    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface Converter<T1, T2> {
        void convert(int i);
    }
}
