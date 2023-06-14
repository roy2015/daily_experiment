package com.guo.roy.research.leetcode.jzoffer;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2023/6/14
 */
public class TestSolution077 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution077.class);


//    Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    static class Solution {
        /**
         * 执行用时：
         * 2628 ms
         * , 在所有 Java 提交中击败了
         * 5.01%
         * 的用户
         * 内存消耗：
         * 49.3 MB
         * , 在所有 Java 提交中击败了
         * 19.71%
         * 的用户
         * @param head
         * @return
         */
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode newHead = new ListNode(head.val);
            ListNode node = head.next;
            while (node != null) {
                ListNode closestNode = findClosestNode(newHead, node.val);
                ListNode newNode = new ListNode(node.val);

                //closestNode == null表示比所有的都要小，作为新head
                if (closestNode == null) {
                    newNode.next = newHead;
                    newHead = newNode;
                } else {
                    ListNode tmpNode = closestNode.next;
                    closestNode.next = newNode;
                    newNode.next = tmpNode;
                }
                node = node.next;
            }
            return newHead;
        }

        /**
         * 找最近的节点（插入的位置）
         * @param newHead
         * @param val
         * @return
         */
        public ListNode findClosestNode(ListNode newHead, int val) {
            ListNode lastNode = null;
            ListNode node = newHead;
            while (node != null && val > node.val ) {
                lastNode = node;
                node = node.next;
            }
            return lastNode;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(5);
        node = new Solution().sortList(node);
        logger.info("{}");
    }
}
