package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/5.
 *
 *
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

 现有一个链表 -- head = [4,5,1,9]，它可以表示为:

 输入: head = [4,5,1,9], node = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

 说明:

 链表至少包含两个节点。
 链表中所有节点的值都是唯一的。
 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 不要从你的函数中返回任何结果。


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution237 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution237.class);

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {
        public void deleteNode(ListNode node, int x) {
            ListNode preNode = node;
            ListNode curNode = node.next;

            if (preNode.val == x) {
                node.val = curNode.val;
                node.next = curNode.next;
                return;
            }

            while ( curNode.val != x ) {//给定的节点为非末尾节点并且一定是链表中的一个有效节点
                preNode = curNode;
                curNode = curNode.next;
            }
            preNode.next = curNode.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        solution.deleteNode(listNode, 1);
        logger.info("123");
    }

}
