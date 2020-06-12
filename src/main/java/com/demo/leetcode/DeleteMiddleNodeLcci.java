package com.demo.leetcode;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName DeleteMiddleNodeLcci.java
 * @Description 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * 示例：
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-middle-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @createTime 2020年06月12日 15:54:00
 */
public class DeleteMiddleNodeLcci {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
     * 将入参节点的值设置为后继节点的值
     * 将入参的后继设置为后继的后继
     * 即可视为删除了node节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
