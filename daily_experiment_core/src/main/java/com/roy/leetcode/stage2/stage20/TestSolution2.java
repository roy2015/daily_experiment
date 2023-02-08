package com.roy.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2020/1/14.
 *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class TestSolution2 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution2.class);

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    static class Solution {
        /**
         * 执行结果：
         * 通过显示详情
         * 执行用时 :2 ms, 在所有 Java 提交中击败了99.96%的用户
         * 内存消耗 :44.8 MB, 在所有 Java 提交中击败了83.96%的用户
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode headNode = null;
            ListNode nextNode = null;

            ListNode nextL1 = l1;
            ListNode nextL2 = l2;
            int jw = 0;
            int sum = 0;

            while (nextL1 != null || nextL2 != null || jw > 0) {
                sum =0;
                if (nextL1 != null) {
                    sum += nextL1.val;
                    nextL1 = nextL1.next;
                }
                if (nextL2 != null) {
                    sum += nextL2.val;
                    nextL2 = nextL2.next;
                }
                sum += jw;
                if (sum > 9) {
                    sum -= 10;
                    jw =1;
                } else {
                    jw =0;
                }

                if (headNode == null) {
                    nextNode = new ListNode(sum);
                    headNode = nextNode;
                } else {
                    nextNode.next = new ListNode(sum);
                    nextNode = nextNode.next;
                }
            }
            return headNode;
        }

        public void printNode(ListNode node) {
            StringBuilder sb = new StringBuilder();
            while (node != null) {
                sb.append(node.val);
                node = node.next;
            }

            logger.info(sb.reverse().toString());

        }

    }

    public static void main(String[] args) {
        ListNode nodeL1 = new ListNode(2);
        nodeL1.next = new ListNode(4);
//        nodeL1.next.next = new ListNode(3);

        ListNode nodeL2 = new ListNode(5);
        nodeL2.next = new ListNode(6);
        nodeL2.next.next = new ListNode(4);

        Solution solution = new Solution();
        solution.printNode(nodeL1);
        solution.printNode(nodeL2);
        ListNode addNode = solution.addTwoNumbers(nodeL1, nodeL2);
        solution.printNode(addNode);
    }


}
