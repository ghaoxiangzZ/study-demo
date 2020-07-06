package com.demo.leetcode;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName LeetCodeTestDemo.java
 * @Description LeetCode测试专用
 * @createTime 2020年06月12日 19:15:00
 */
public class LeetCodeTestDemo {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /*   3
       / \
       9  20
       /  \
       15   7    */
    public static void main(String[] args) {
        TreeNode node_1 = new TreeNode(3);
        TreeNode node_2 = new TreeNode(9);
        node_1.left = node_2;
        TreeNode node_3 = new TreeNode(20);
        node_1.right = node_3;
        TreeNode node_4 = new TreeNode(15);
        node_3.left = node_4;
        TreeNode node_5 = new TreeNode(7);
        node_3.right = node_5;
        System.out.println(maxDepth(node_1));
    }
}
