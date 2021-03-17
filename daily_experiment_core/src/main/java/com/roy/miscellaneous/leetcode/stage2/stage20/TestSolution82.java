package com.roy.miscellaneous.leetcode.stage2.stage20;

import java.util.ArrayDeque;
import java.util.Deque;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/09
 *
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 *
 *
 *
 *
 */
public class TestSolution82 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution82.class);

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    static class Solution {
        /**
         * 首先这是一道好题，最终还是自己想出来了~
         * <p>
         * 思路1：
         * step1: 找head
         * step2: go on
         * <p>
         * 思路一有点复杂，想到思路2
         * 思路2: 用栈，完全是用testCase debug出来的
         * <p>
         * 时间复杂度3ms， 可以再思考下，从duplicateVal考虑吧，目前写的比较乱
         * 执行结果：通过
         * 显示详情
         * 执行用时：3 ms, 在所有 Java 提交中击败了7.42%的用户
         * 内存消耗：38.3 MB, 在所有 Java 提交中击败了91.97%的用户
         *
         * @param head
         * @return
         */
        public ListNode deleteDuplicates(ListNode head) {
            ListNode tempNode = head;

            //排除异常情况，一个节点和null
            if (tempNode == null || tempNode.next == null) {
                return tempNode;
            }

            //关键变量
            Integer duplicateVal = null;//是否已经重复过

            Deque<ListNode> stack = new ArrayDeque<>();
            while (tempNode != null) {
                //栈为空
                if (stack.isEmpty()) {
                    if (duplicateVal == null) {
                        stack.push(tempNode);
                    } else if (!duplicateVal.equals(tempNode.val)) {
                        stack.push(tempNode);
                        duplicateVal = null;
                    }
                    tempNode = tempNode.next;
                    continue;
                }

                ListNode topNode = stack.peek();
                int tempNodeVal = tempNode.val;

                if (topNode.val == tempNodeVal) {
                    //是否走过重复的
                    if (duplicateVal == null) {
                        stack.pop();
                        if (!stack.isEmpty()) {
                            stack.peek().next = null;
                        }
                        duplicateVal = Integer.valueOf(tempNodeVal);
                    } else {
                        stack.push(tempNode);
                        topNode.next = tempNode;
                        duplicateVal = null;
                    }

                } else if (duplicateVal != null && duplicateVal.equals(tempNodeVal)) {
//                    continue;
                } else {
                    duplicateVal = null;
                    topNode.next = tempNode;
                    stack.push(tempNode);
                }

                tempNode = tempNode.next;
            }
            return stack.pollLast();
        }

        /**
         *
         * 整理上面的思路，变的好理解一点（以compareVal作为if条件），代码行数减少了16；
         * 时间复杂度3ms， 可以再思考下是不是有更好的思路
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：3 ms, 在所有 Java 提交中击败了7.42%的用户
         * 内存消耗：38.3 MB, 在所有 Java 提交中击败了89.28%的用户
         * @param head
         * @return
         */
        public ListNode deleteDuplicates1(ListNode head) {
            ListNode tempNode = head;

            //排除异常情况，一个节点和null
            if (tempNode == null || tempNode.next == null) {
                return tempNode;
            }

            //关键变量
            Integer compareVal = null;//比较的参考对象

            Deque<ListNode> stack = new ArrayDeque<>();
            while (tempNode != null) {
                int tempNodeVal = tempNode.val;
                if (compareVal == null) {
                    stack.push(tempNode);
                    compareVal = Integer.valueOf(tempNodeVal);
                } else if (compareVal.equals(tempNodeVal)) {
                    if (!stack.isEmpty()) {
                        ListNode topNode = stack.peek();
                        if (topNode.val == tempNodeVal) {
                            stack.pop();
                            if (!stack.isEmpty()) {
                                stack.peek().next = null;
                            }
                        }
                    }
                } else {
                    if (!stack.isEmpty()) {
                        stack.peek().next = tempNode;
                    }
                    stack.push(tempNode);
                    compareVal = Integer.valueOf(tempNodeVal);
                }
                tempNode = tempNode.next;
            }
            return stack.pollLast();
        }


        public void print(ListNode node) {
            StringBuilder sb = new StringBuilder();
            while (node != null) {
                sb.append(node.val).append(" -> ");
                node= node.next;
            }
            logger.info(sb.length() == 0 ? "" : sb.toString().substring(0, sb.length() - 3));
        }

    }

    public static void main(String[] args) {
        ListNode head = null ;

        //1->2->2->2
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head = new Solution().deleteDuplicates1(head);//1
        new Solution().print(head);

        //1->1->1->2->3
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head = new Solution().deleteDuplicates1(head);//2->3
        new Solution().print(head);

        //1->2->3->2
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head = new Solution().deleteDuplicates1(head);//1->2->3->2
        new Solution().print(head);

        //1->1->1
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head = new Solution().deleteDuplicates1(head);//null
        new Solution().print(head);

        //1->2->3->3->4->4->5
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head = new Solution().deleteDuplicates1(head);//1->2->5
        new Solution().print(head);


    }
}
