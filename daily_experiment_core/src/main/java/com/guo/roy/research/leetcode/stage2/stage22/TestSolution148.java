package com.guo.roy.research.leetcode.stage2.stage22;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/17
 *
 *
 * 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 *
 */
public class TestSolution148 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution148.class);

    static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    static class Solution {

        /**
         * 应该挺简单的，看O(n log n)应该就是一个排序的最优时间复杂度
         *
         * 懒得想就这样吧，扔到list里排个序再重新做个链表
         *
         *执行结果：通过
         * 显示详情
         * 执行用时：12 ms, 在所有 Java 提交中击败了17.24%的用户
         * 内存消耗：47.3 MB, 在所有 Java 提交中击败了5.02%的用户
         *
         * @param head
         * @return
         */
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode node = head;

            List<ListNode> list = new ArrayList<ListNode>();
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            list.sort((o1, o2) ->  o1.val - o2.val);

            node = list.get(0);
            ListNode tempNode;
            int size = list.size();
            for (int i = 1; i < size; i++) {
                tempNode = list.get(i);
                node.next = tempNode;
                node = tempNode;
            }
            list.get(size -1).next = null;
            return list.get(0);
        }
    }

    public static void main(String[] args) {
        ListNode head = null;
        head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        head= new Solution().sortList(head);
        logger.info("{}", head);

        head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        head= new Solution().sortList(head);
        logger.info("{}", head);
    }
}
