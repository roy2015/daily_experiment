package com.guo.roy.research.leetcode.stage2.stage21;

import java.util.ArrayDeque;
import java.util.Deque;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/17
 *
 *
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 *
 */
public class TestSolution445 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution445.class);

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        /**
         *
         * 题目要求不用反转链表，所以直接求值， testcase不过有个问题 求值求不出来换long也不work，因为链表无限node，比如63和，java无法表示，
         * 把求和的路堵死了~~,套路~，就是为了防止解题者搞幺蛾子
         *
         * eg：
         * [2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9]
         * [5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9]
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
            long l1Sum = 0, l2Sum = 0;
            ListNode l1Node = l1;
            ListNode l2Node = l2;
            //直接遍历链表，顺便把代表的数求出来
            while (l1Node != null || l2Node != null ) {
                if (l1Node != null) {
                    int l1val = l1Node.val;
                    l1Sum = l1Sum * 10 + l1val;
                    l1Node = l1Node.next;
                }
                if (l2Node != null) {
                    int l2val = l2Node.val;
                    l2Sum = l2Sum * 10 + l2val;
                    l2Node = l2Node.next;
                }
            }

            long sum = l1Sum + l2Sum;
            //转化为链表
            ListNode preNode = null, currNode;
            do {
                currNode = new ListNode((int) (sum % 10));
                currNode.next = preNode;

                preNode = currNode;
                sum /= 10;
            } while (sum != 0);
            return currNode;
        }

        /**
         *
         * 擦，一打开评论，第一眼看到stack，瞬间茅塞顿开，咋就没想到呢？？？，要的不就是反序么，用stack
         *
         * 任意长度的两个链表相加
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 4 ms, 在所有 Java 提交中击败了79.49%的用户
         * 内存消耗：
         * 38.9 MB, 在所有 Java 提交中击败了81.32%的用户
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l1Node = l1;
            ListNode l2Node = l2;

            Deque<Integer> l1Stack = new ArrayDeque<>();
            Deque<Integer> l2Stack = new ArrayDeque<>();

            while (l1Node != null || l2Node != null) {
                if (l1Node != null) {
                    l1Stack.push(l1Node.val);
                    l1Node = l1Node.next;
                }
                if (l2Node != null) {
                    l2Stack.push(l2Node.val);
                    l2Node = l2Node.next;
                }
            }

            //出栈
            int jw = 0;//进位
            ListNode preNode = null, currNode = null;
            while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
                int op1Val = 0;
                int op2Val = 0;
                if (!l1Stack.isEmpty()) {
                    op1Val = l1Stack.pop();
                }

                if (!l2Stack.isEmpty()) {
                    op2Val = l2Stack.pop();
                }

                int sum = 0;
                sum = op1Val + op2Val + jw;
                if (sum > 9) {
                    sum = sum -10;
                    jw = 1;
                } else {
                    jw = 0;
                }

                currNode = new ListNode(sum);
                currNode.next = preNode;
                preNode = currNode;
            }
            if (jw == 1) {
                currNode = new ListNode(1);
                currNode.next = preNode;
            }
            return currNode;
        }


    }

    public static void main(String[] args) {
        ListNode node1, node2, retNode;

        node1 = new ListNode(9);
        node1.next = new ListNode(9);
        node1.next.next = new ListNode(9);
        node1.next.next.next = new ListNode(9);
        node1.next.next.next.next = new ListNode(9);
        node1.next.next.next.next.next = new ListNode(9);
        node1.next.next.next.next.next.next = new ListNode(9);
        node1.next.next.next.next.next.next.next = new ListNode(9);
        node1.next.next.next.next.next.next.next.next = new ListNode(9);
        node1.next.next.next.next.next.next.next.next.next = new ListNode(9);
        node2 = new ListNode(7);
        retNode = new Solution().addTwoNumbers(node1, node2);//73

        node1 = new ListNode(0);
        node2 = new ListNode(7);
        node2.next = new ListNode(3);
        retNode = new Solution().addTwoNumbers(node1, node2);//73

        node1 = new ListNode(7);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);
        node1.next.next.next = new ListNode(3);
        node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        retNode = new Solution().addTwoNumbers(node1, node2);//7807

        logger.info("{}", new Solution());
    }
}
