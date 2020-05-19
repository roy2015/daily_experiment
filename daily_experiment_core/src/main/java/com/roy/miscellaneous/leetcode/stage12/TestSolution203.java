package com.roy.miscellaneous.leetcode.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/19
 *
 * 203. 移除链表元素
删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 *
 *
 */
public class TestSolution203 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution203.class);

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {

        /**
         * 注： 和TestSolutionInterview18不同的是这里可以有重复节点，所以要删多次知道链表结尾
         *
         * 关键点是 记录当前节点的上一个节点，因为删除节点要跨越一个节点
         *
         * <p>
         * 执行结果：通过显示详情
         * 执行用时 :1 ms, 在所有 Java 提交中击败了99.89%的用户
         * 内存消耗 :41.3 MB, 在所有 Java 提交中击败了6.25%的用户
         *
         * @param head
         * @param val
         * @return
         */
        public ListNode removeElements(ListNode head, int val) {
            ListNode currNode = head;
            ListNode preNode = null;//记录当前节点的上一个节点
            while (currNode != null) {
                int nodeVal = currNode.val;
                if (val == nodeVal) {
                    if (preNode == null) {
                        head = currNode.next;
                    } else {
                        preNode.next = currNode.next;
                    }
                } else {
                    preNode = currNode;
                }
                currNode = currNode.next;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        // 1 2 6 3 4 5 6
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);
        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        ListNode node = new Solution().removeElements(head, 6);// 1 2 3 4 5
        logger.info("{}", node);

        //1 -> 2 -> 2 -> 1
        head = new ListNode(1);
        listNode2 = new ListNode(2);
        listNode3 = new ListNode(2);
        listNode4 = new ListNode(1);
        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        node = new Solution().removeElements(head, 2);//1->1
        logger.info("{}", node);
    }
}
