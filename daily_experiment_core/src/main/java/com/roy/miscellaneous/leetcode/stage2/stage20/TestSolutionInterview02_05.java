package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/18
 *
 * 面试题 02.05. 链表求和
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 */
public class TestSolutionInterview02_05 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview02_05.class);

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :
         * 2 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :
         * 39.9 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode retNode = null;
            ListNode linkNode = null;

            //循环两个链表（任一个非空时）
            while (l1 != null || l2!= null) {
                int l1Val = 0;
                int l2Val = 0;
                if (l1 != null) {
                    l1Val = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2Val = l2.val;
                    l2 = l2.next;
                }

                int addVal ;
                addVal = l1Val + l2Val + carry;
                if (addVal > 9) {
                    addVal = addVal - 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                ListNode currentNode = new ListNode(addVal);
                if (retNode == null) {
                    retNode = currentNode;
                } else {
                    linkNode.next = currentNode;
                }
                linkNode = currentNode;
            }//end while
            if (carry == 1) {//hightest bit has carry
                linkNode.next = new ListNode(1);
            }
            return retNode;
        }
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(7);
        ListNode node12 = new ListNode(1);
        ListNode node13 = new ListNode(6);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(4);
        ListNode node22 = new ListNode(5);
        ListNode node23 = new ListNode(9);
        ListNode node24 = new ListNode(2);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;

        ListNode addNode = new Solution().addTwoNumbers(node11, node21);
        logger.info("{}" , addNode);
        int k = 0;

    }
}
