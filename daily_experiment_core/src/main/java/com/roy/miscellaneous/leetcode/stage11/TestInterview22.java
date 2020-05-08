package com.roy.miscellaneous.leetcode.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/8 15:40
 *
 * 面试题22. 链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。



示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
 */
public class TestInterview22 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestInterview22.class);


    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * 1.计算链表长度算出要求的节点正着数是第一个元素
         * 2.遍历链表
         *
         * 执行结果：通过显示详情
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :38.1 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         *
         * @param head
         * @param k
         * @return
         */
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode temp = head;
            int len =0;
            while(temp != null) {
                len ++;
                temp = temp.next;
            }
            int pos = len +1 - k;
            int p =1;
            while (true) {
                if (p == pos) {
                    return head;
                } else{
                    head = head.next;
                    p ++;
                }

            }


        }
    }

    public static void main(String[] args) {

    }
}
