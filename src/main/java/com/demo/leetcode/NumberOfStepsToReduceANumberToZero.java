package com.demo.leetcode;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName NumberOfStepsToReduceANumberToZero.java
 * @Description 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 * 示例 1：
 * 输入：num = 14
 * 输出：6
 * 解释：
 * 步骤 1) 14 是偶数，除以 2 得到 7 。
 * 步骤 2） 7 是奇数，减 1 得到 6 。
 * 步骤 3） 6 是偶数，除以 2 得到 3 。
 * 步骤 4） 3 是奇数，减 1 得到 2 。
 * 步骤 5） 2 是偶数，除以 2 得到 1 。
 * 步骤 6） 1 是奇数，减 1 得到 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @createTime 2020年06月12日 16:37:00
 */
public class NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 1) {
            count += num % 2 != 0 ? 2 : 1;
            num /= 2;
        }
        return count + 1;
    }
}
