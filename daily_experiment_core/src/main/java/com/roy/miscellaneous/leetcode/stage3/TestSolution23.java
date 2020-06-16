package com.roy.miscellaneous.leetcode.stage3;

import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

/**
 * Created by apple on 2019/9/9.
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

 示例:

 输入:
 [
   1->4->5,
   1->3->4,
   2->6
 ]
 输出: 1->1->2->3->4->4->5->6

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution23 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution23.class);

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

    /**
     *
     * 执行用时 :6 ms, 在所有 java 提交中击败了76.95%的用户
     * 内存消耗 :39.3 MB, 在所有 java 提交中击败了91.68%的用户
     *
     */
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length ==0) {
                return null;
            }

            PriorityQueue<Integer> pQueue = new PriorityQueue<>();
            for (ListNode node : lists) {
                if (node == null) {
                    continue;
                }
                do {
                    pQueue.offer(node.val);
                    node = node.next;

                } while (node != null);
            }

            ListNode retNode, headNode;
            Integer top ;
            top = pQueue.poll();
            if (top == null) {
                return null;
            }
            retNode = new ListNode(top);//头结点
            headNode = retNode;

            while ((top = pQueue.poll()) != null) {
                retNode.next = new ListNode(top);
                retNode = retNode.next;
            }
            return headNode;
        }

        public void printList(ListNode listNode) {
            while (listNode != null) {
                logger.info("{}", listNode.val);
                listNode = listNode.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        listNodes[0] = node1;
        listNodes[1] = node2;
        listNodes[2] = node3;

        ListNode node = new Solution().mergeKLists(listNodes);
        new Solution().printList(node);

    }


}
