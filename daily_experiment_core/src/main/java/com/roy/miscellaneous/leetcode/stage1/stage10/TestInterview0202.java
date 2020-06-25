package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/24
 *
 * 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 */
public class TestInterview0202 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestInterview0202.class);

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {
        /**
         *
         * 比之前那个相似的删除链表倒数K个节点的清爽多了，那个要领先N+1步，因为涉及到挂指针
         *
         * 给定的 k 保证是有效的
         *
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37.8 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param head
         * @param k
         * @return
         */
        public int kthToLast(ListNode head, int k) {
            ListNode p, q;
            p = q = head;

            //shift
            int shift =0;
            while (shift < k) {
                shift ++;
                q = q.next;
            }

            // q,q go ahead together
            while (q != null) {
                q = q.next;
                p = p.next;
            }

            return p.val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        logger.info("{}", new Solution().kthToLast(listNode1, 1));
    }
}
