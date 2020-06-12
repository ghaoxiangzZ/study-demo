package com.demo.leetcode;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName SinistrogyrationString.java
 * @Description 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @createTime 2020年06月12日 15:36:00
 */
public class SinistrogyrationString {
    public static String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n));
        sb.append(s, 0, n);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("lrloseumgh", 6));
    }
}
