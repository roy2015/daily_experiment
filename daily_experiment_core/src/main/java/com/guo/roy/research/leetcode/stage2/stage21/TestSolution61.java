package com.guo.roy.research.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/17
 *
 *61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 *
 *
 */
public class TestSolution61 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution61.class);

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
         * 两次遍历链表，复杂度O(n)
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：38.5 MB, 在所有 Java 提交中击败了58.25%的用户
         *
         *
         * @param head
         * @param k
         * @return
         */
        public ListNode rotateRight(ListNode head, int k) {
            if (k == 0 || head == null || head.next == null) {
                return head;
            }

            //求链表长度，顺便把最后一个node记下,tailNode
            ListNode tailNode ;
            int len = 1;
            ListNode processNode = head;
            while (processNode.next != null) {
                len ++;
                processNode = processNode.next;
            }
            tailNode = processNode;

            //找到新的尾
            int move = len - (k % len);
            int i = 1;
            processNode = head;
            while (i < move) {
                processNode =  processNode.next;
                i ++;
            }
            tailNode.next = head;//接头
            ListNode newHead = processNode.next;//新头
            processNode.next = null;//断尾
            return newHead;
        }
    }

    public static void main(String[] args) {
        ListNode newHead;

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        newHead = new Solution().rotateRight(head1, 2);
        logger.info("{}", new Solution());
    }
}
