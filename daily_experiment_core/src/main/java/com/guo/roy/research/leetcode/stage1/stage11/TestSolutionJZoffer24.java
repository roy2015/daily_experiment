package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/19 10:40
 *
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 */
public class TestSolutionJZoffer24 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionJZoffer24.class);


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * 和以下这个题目相同
         * @see TestSolutionJZoffer06
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.4 MB, 在所有 Java 提交中击败了82.51%的用户
         *
         *

         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode node = head;
            ListNode preNode = null;//给下一个迭代准备的node
            ListNode nextNode ;

            //链表逆序
            while (node != null) {
                nextNode = node.next;//暂存next
                node.next = preNode;
                preNode = node;
                node = nextNode;
            }

            return preNode;
        }

        public ListNode reverseList1(ListNode head) {
            ListNode currentNode = head;
            ListNode preNode = null;//给下一个迭代准备的node

            while (currentNode != null) {
                ListNode coptOfCurrentNode = currentNode;
                currentNode = currentNode.next;
                coptOfCurrentNode.next = preNode;
                preNode = coptOfCurrentNode;
            }


            return preNode;
        }


    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(2);


        logger.info("{}", new Solution().reverseList1(node1));
    }
}
