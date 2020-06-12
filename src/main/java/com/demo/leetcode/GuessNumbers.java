package com.demo.leetcode;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName GuessNumbers.java
 * @Description 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 *
 *  
 *
 * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @createTime 2020年06月12日 16:13:00
 */
public class GuessNumbers {
    public int game(int[] guess, int[] answer) {
        int ret = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[0] == answer[0]) {
                ret++;
            }
        }
        return ret;
    }
}
