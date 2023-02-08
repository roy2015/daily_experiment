package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/2.
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

 示例 1:

 输入: 1->1->2
 输出: 1->2
 示例 2:

 输入: 1->1->2->3->3
 输出: 1->2->3

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 1. 采用了双指针,快慢指针 p1 ,p2
 * 2. 直接指针法
 */
public class TestSolution83 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution83.class);

    static class  ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    /**
     *
     *
     */
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode p1 = head;
            ListNode p2 = head;
            while ( p2 != null ) {
                if (p1.val == p2.val) {
                    p2 = p2.next;
                    if (p2 == null) {
                        p1.next = null;
                    }
                } else {
                    p1.next = p2;
                    p1 = p2;
                }
            }
            return head;
        }

        public ListNode deleteDuplicates_1(ListNode head) {
            ListNode current = head;
            while (current != null && current.next != null) {
                if (current.next.val == current.val) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);
//        listNode.next.next.next = new ListNode(3);
//        listNode.next.next.next.next = new ListNode(3);

        ListNode node = new Solution().deleteDuplicates(listNode);
        logger.info("{}");
    }

}
