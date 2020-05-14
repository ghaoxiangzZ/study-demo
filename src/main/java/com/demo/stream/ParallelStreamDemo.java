package com.demo.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName ParallelStreamDemo.java
 * @Description 并行流demo
 * @createTime 2020年04月20日 21:40:00
 */
public class ParallelStreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
                19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42);
        list.parallelStream().forEach(System.out::println);
        System.out.println("wait parallel all done or print this first?");
    }
}
