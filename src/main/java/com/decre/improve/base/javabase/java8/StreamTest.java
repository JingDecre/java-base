package com.decre.improve.base.javabase.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * <p>Title: StreamTest</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/28 0028 21:50
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 创建串行流
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        // 创建并行流
        List<String> filterParallel = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        // 'forEach' 来迭代流中的每个数据
        // limit 方法用于获取指定数量的流
        // sorted 方法用于对流进行排序
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // map 方法用于映射每个元素到对应的结果, 跟平时 用的Map对象要区分开
        List<Integer> squqresList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());

        // Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        // 一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果
        IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("列表最大数： " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }
}
