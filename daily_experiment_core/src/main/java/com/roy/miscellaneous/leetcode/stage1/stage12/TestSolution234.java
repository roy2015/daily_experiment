package com.roy.miscellaneous.leetcode.stage1.stage12;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/20
 *
 * 234. 回文链表
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
 *
 */
public class TestSolution234 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution234.class);

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {
        /**
         * 执行用时：5 ms
         内存消耗：43.9 MB
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            //step1 把链表放到list
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head =  head.next;
            }
            //step2 list -> arrays
            int len = list.size();
            int[] ints = new int[len];
            int k =0;
            for (Integer integer :list){
                ints[k++] = integer;
            }
            //step3 双指针验证回文
            int p = 0, q = len -1;
            while (p <= q) {
                if (ints[q] != ints[p]) {
                    return false;
                }
                p ++;
                q --;
            }
            return true;
        }


        /**
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :4 ms
         , 在所有 Java 提交中击败了
         32.11%
         的用户
         内存消耗 :44 MB, 在所有 Java 提交中击败了5.41%的用户
         *
         * @param head
         * @return
         */
        public boolean isPalindrome1(ListNode head) {
            ListNode tmpHead = head;
            Stack<Integer> stack = new Stack<>();
            while (tmpHead != null) {
                stack.push(tmpHead.val);
                tmpHead =  tmpHead.next;
            }

            while (head != null) {
                Integer pop = stack.pop();
                if (pop != head.val) {
                    return false;
                }
                head =  head.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        logger.info("{}", new Solution().isPalindrome1(node1));
    }
}
