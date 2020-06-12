package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName CountWhenSumThreeNumEqualsZero.java
 * @Description leetcode三数之和
 * @createTime 2020年06月12日 13:17:00
 */
public class CountDistinctWhenSumThreeNumEqualsZero {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    if (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    ;
                    if (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    ;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < sum) {
                    if (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;
                } else {
                    if (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    r--;
                }
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> answer = threeSum(nums);
        answer.stream().forEach(System.out::print);
    }
}
