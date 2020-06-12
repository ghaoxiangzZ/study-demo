package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName MaxCandiesChild.java
 * @Description 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * <p>
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @createTime 2020年06月12日 15:05:00
 */
public class MaxCandiesChild {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int[] copy = Arrays.copyOf(candies, candies.length);
        Arrays.sort(candies);
        int max = candies[candies.length - 1];
        List list = new ArrayList<Boolean>();
        for (int i = 0; i < copy.length; i++) {
            list.add(copy[i] + extraCandies >= max);
        }
        return list;
    }
}
