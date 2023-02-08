package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/19
 *
 * 面试题18. 删除链表的节点
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.


说明：

题目保证链表中节点的值互不相同
若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 *
 */
public class TestSolutionInterview18 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview18.class);

    static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    static class Solution {
        /**
         *
         * 要考虑删除的可能是头节点
         *
         *
         * 执行结果：通过显示详情
         执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :39.5 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param head
         * @param val
         * @return
         */
        public ListNode deleteNode(ListNode head, int val) {
            ListNode currNode = head;
            ListNode preNode = null;//记录当前节点的上一个节点
            while(currNode != null) {
                int nodeVal = currNode.val;
                if (val == nodeVal && preNode == null) {//delete head
                    return currNode.next;
                } else if (val == nodeVal && preNode != null) {
                    preNode.next = currNode.next;
                    return head;
                } else{
                    preNode = currNode;
                    currNode = currNode.next;
                }
            }
            //not find
            return head;
        }

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        listNode1.next = listNode2;
        ListNode deleteNode = new Solution().deleteNode(listNode1, 4);
        logger.info("{}", deleteNode);//1
    }
}
