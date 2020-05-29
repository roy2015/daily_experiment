package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/15 14:54
 *
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution328 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution24.class);

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    static class ListNode {
        int                     val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {
        /**
         *
         *
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :36.4 MB, 在所有 Java 提交中击败了94.05%的用户
         *
         * @param head
         * @return
         */
        public ListNode oddEvenList(ListNode head) {
            //无节点/一个节点/两个节点
            if (head == null || head.next == null || head.next.next == null ) {
                return head;
            }

            //odd奇, even偶
            ListNode evenHeadNode = head.next;

            ListNode currOddNode = head.next.next;//head走到第三个节点
            ListNode  currEvenNode = head.next;//head走到第二个
            head.next = currOddNode;

            while (true) {
                if (currOddNode.next == null) {//奇节点是最后一个节点
                    currOddNode.next = evenHeadNode;//挂头偶节点
                    currEvenNode.next = null;
                    break;
                } else if (currOddNode.next.next == null) {//奇节点下一节点只有一个节点（偶节点是最后一个节点）
                    currEvenNode.next = currOddNode.next;
                    currOddNode.next = evenHeadNode;////挂头偶节点
                    break;
                } else {
                    ListNode tmp;
                    tmp = currEvenNode.next.next;
                    currEvenNode.next = tmp;
                    currEvenNode = tmp;
                    tmp = currOddNode.next.next;
                    currOddNode.next = tmp;
                    currOddNode = tmp;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode listNode = solution.oddEvenList(head);
        int k =0;
    }

}
