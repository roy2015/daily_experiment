package com.roy.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/29
 *
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class TestSolution141 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution141.class);


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    static class Solution {

        /**
         *
         *
         * 快慢指针，快指针一次走两步，慢指针一次走一步，最终相遇则有环，走到null节点无环
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :39.8 MB, 在所有 Java 提交中击败了5.49%的用户
         *
         * @param head
         * @return
         */
        public boolean hasCycle(ListNode head) {
            //空链表没有环
            if (head == null) {
                return false;

            }
            //快慢指针
            ListNode fNode;
            ListNode sNode;
            fNode = sNode = head;
            while (true) {
                sNode = sNode.next;
                if (fNode.next != null){
                    fNode = fNode.next.next;
                } else {
                    return false;
                }
                if (fNode == null) {
                    return false;
                }
                if (sNode == fNode) {
                    return true;
                }
            }
        }






        /**
         * 练习  20210309 追击问题
         * @param head
         * @return
         */
        public boolean hasCycle1(ListNode head) {
            ListNode fastNode, slowNode;
            fastNode = slowNode = head;
            while (true) {
                if (fastNode == null || fastNode.next == null) {
                    return false;
                }
                //走两步，走一步
                fastNode = fastNode.next.next;
                slowNode = slowNode.next;
                if (fastNode == slowNode) {
                    return true;
                }
            }
        }

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(10);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = listNode3;

        logger.info("{}", new Solution().hasCycle1(listNode1));//true
        listNode1 = new ListNode(1);
        logger.info("{}", new Solution().hasCycle1(listNode1));//false
        listNode1 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = null;
        logger.info("{}", new Solution().hasCycle1(listNode1));//false

    }
}
