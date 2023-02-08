package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/8 19:15
 *
 * 1290. 二进制链表转整数
给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。

请你返回该链表所表示数字的 十进制值 。



示例 1：



输入：head = [1,0,1]
输出：5
解释：二进制数 (101) 转化为十进制数 (5)
示例 2：

输入：head = [0]
输出：0
示例 3：

输入：head = [1]
输出：1
示例 4：

输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
输出：18880
示例 5：

输入：head = [0,0]
输出：0


提示：

链表不为空。
链表的结点总数不超过 30。
每个结点的值不是 0 就是 1。
 */
public class TestSolutionInterview1290 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview1290.class);


    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * 执行结果：通过显示详情
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了5.00%的用户
         *
         * @param head
         * @return
         */
        public int getDecimalValue(ListNode head) {
            ListNode listNode = revertLinkTab(head);

            int decimalVal = 0;
            int shift = 0;
            while (listNode != null) {
                int val = listNode.val;
                if (val != 0) {
                    decimalVal += 1 << shift;
                }
                shift ++;
                listNode = listNode.next;
            }
            return decimalVal;
        }

        /**
         *
         * 逆序链表
         * 思路： 两个节点一起挪
         *
         * @param head
         * @return
         */
        private ListNode revertLinkTab(ListNode head) {
            ListNode p1 = head;
            ListNode p2 = head;
            ListNode p1Next = null;//给p1留的掉头指针
            ListNode tempP;
            ListNode newHead = null ;

            while(p1 != null) {
                p2 = p1.next;
                if (p2 == null) {
                    p1.next = p1Next;
                    newHead = p1;
                    break;
                }

                tempP = p2.next;
                p2.next = p1;
                p1.next = p1Next;
                p1 = tempP;
                p1Next = p2;
            }
            if (p1 == null) {
                newHead = p2;
            }

            return newHead;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        int decimalValue = new Solution().getDecimalValue(node1);
        logger.info("{}", decimalValue);

    }
}
