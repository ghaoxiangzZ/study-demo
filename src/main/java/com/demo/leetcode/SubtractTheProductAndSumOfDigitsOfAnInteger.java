package com.demo.leetcode;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName SubtractTheProductAndSumOfDigitsOfAnInteger.java
 * @Description 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * 示例 2：
 * <p>
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @createTime 2020年06月12日 16:50:00
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public static int subtractProductAndSum(int n) {
        int multiResult = 1;
        int addResult = 0;
        while (n > 0) {
            int num = n % 10;
            multiResult *= num;
            addResult += num;
            n /= 10;
        }
        return multiResult - addResult;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(705));
    }
}
