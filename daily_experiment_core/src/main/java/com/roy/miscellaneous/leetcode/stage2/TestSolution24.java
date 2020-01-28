package com.roy.miscellaneous.leetcode.stage2;

import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

/**
 * Created by apple on 2020/1/10.
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution24 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution24.class);

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    static class Solution {
        /**
         *
         *
         * 单纯的改变节点内部的值,违规了哈~~
         *
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :34.5 MB, 在所有 Java 提交中击败了82.02%的用户
         * @param head
         * @return
         */
        public ListNode swapPairs(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode tmpNode = head;
            do {
                if (tmpNode.next == null) {
                    break;
                }
                int left = tmpNode.val;
                tmpNode.val = tmpNode.next.val;
                tmpNode.next.val = left;

                tmpNode = tmpNode.next.next;
            } while (tmpNode != null);
            return head;
        }

        /**
         * 正解
         * 两两一组，再递归下去，两两一组。。。。。
         *
         *执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :34.6 MB, 在所有 Java 提交中击败了81.91%的用户
         *
         *
         *
         * @param head
         * @return
         */
        public ListNode swapPairs_1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode first = head;
            ListNode second = head.next;
            ListNode nextLoopHead = second.next;
            second.next = first;
            first.next = swapPairs_1(nextLoopHead);
            return second;
        }

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        logger.info("转换前：==============");
        ListNode printNode = node1;
        while (printNode != null) {
            logger.info(printNode.val + "");
            printNode = printNode.next;
        }

        logger.info("转换后：==============");
        printNode = new Solution().swapPairs_1(node1);
        while (printNode != null) {
            logger.info(printNode.val + "");
            printNode = printNode.next;
        }


    }


}
