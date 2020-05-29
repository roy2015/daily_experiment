package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/29
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

        logger.info("{}", new Solution().hasCycle(listNode1));//true
        listNode1 = new ListNode(1);
        logger.info("{}", new Solution().hasCycle(listNode1));//false
        listNode1 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = null;
        logger.info("{}", new Solution().hasCycle(listNode1));//false

    }
}
