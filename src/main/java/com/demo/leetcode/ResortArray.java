package com.demo.leetcode;

import java.util.stream.Stream;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName ResortArray.java
 * @Description 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * <p>
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-the-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @createTime 2020年06月12日 14:15:00
 */
public class ResortArray {
    public static int[] shuffle(int[] nums, int n) {
        int[] copy = new int[nums.length];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                copy[i] = nums[i];
                copy[i + 1] = nums[n + i];
            } else {
                copy[2 * i] = nums[i];
                copy[2 * i + 1] = nums[n + i];
            }

        }
        return copy;
    }

    public static void main(String[] args) {
        System.out.println("case 1");
        Stream.of(shuffle(new int[]{1, 1, 2, 2}, 2)).forEach(System.out::println);
        System.out.println("case 2");
        Stream.of(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)).forEach(System.out::println);
        System.out.println("case 3");
        Stream.of(shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)).forEach(System.out::println);
    }
}
