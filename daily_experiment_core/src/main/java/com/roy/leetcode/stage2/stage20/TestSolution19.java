package com.roy.leetcode.stage2.stage20;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/22
 *
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 *
 */
public class TestSolution19 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution19.class);

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 前提条件 给定的 n 保证是有效的
     *
     */
    static class Solution {

        /**
         *
         * 一趟扫描，但记住了长度，感觉是换汤不换药
         * 1ms or 0ms？
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了28.48%的用户
         * 内存消耗：38 MB, 在所有 Java 提交中击败了5.43%的用户
         *
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            List<ListNode> listNodes = new ArrayList<>();
            ListNode currentNode = head;
            int i ;
            while (currentNode != null) {
                listNodes.add(currentNode);
                currentNode = currentNode.next;
            }
            i = listNodes.size() -1;

            //挂节点
            if (i - n == -1) {//删头结点
                return head.next;
            } else {
                ListNode inNode = listNodes.get(i - n);
                inNode.next = inNode.next.next;
            }

            return head;
        }


        /**
         *
         *
         * 思想源于力扣 有点奇妙，双指针，先挪开距离成为前后指针，再一起往前走
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：37.9 MB, 在所有 Java 提交中击败了5.43%的用户
         *
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd1(ListNode head, int n) {
            ListNode p = head;
            ListNode q = head.next;
            int i = 0;
            while (i < n && q != null) {
                q = q.next;
                i ++;
            }
            if (i < n) {//特殊情况，没能挪开指定的距离n
                return p.next;
            }

            //一起走，直到q为NULL
            while (q != null) {
                p = p.next;
                q = q.next;
            }
            if (p.next != null) {
                p.next = p.next.next;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        logger.info("{}", new Solution().removeNthFromEnd1(listNode1, 2));
        listNode1.next = null;
        logger.info("{}", new Solution().removeNthFromEnd1(listNode1, 1));

        int k = 0;
    }
}
