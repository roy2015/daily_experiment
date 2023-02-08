package com.roy.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/7
 *
 *       面试题 02.07. 链表相交 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 *
 *
 *       示例 1：
 *
 *       输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3 输出：Reference of the node with value = 8 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为
 *       0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 *       示例 2：
 *
 *       输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1 输出：Reference of the node with value = 2 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A
 *       为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 *       示例 3：
 *
 *       输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2 输出：null 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和
 *       skipB 可以是任意值。 解释：这两个链表不相交，因此返回 null。
 *
 *       注意：
 *
 *       如果两个链表没有交点，返回 null 。 在返回结果后，两个链表仍须保持原有的结构。 可假定整个链表结构中没有循环。 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 *
 *
 *
 */
public class TestSolutionInterview0207 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0207.class);

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {


        /**
         *
         * 最简单扣友的骚思路，如此简洁，不解释
         * （c,d分别是链表A,B中头结点到相交节点的距离, a,b代码A，B的长度），有a-c= b-d =>  a +d = b +c A走完就走B, A走完就走A, 没有没有焦点，
         * 会走到对方末尾 满足null == null
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 99.94%
         * 的用户
         * 内存消耗：
         * 42.7 MB
         * , 在所有 Java 提交中击败了
         * 41.03%
         * 的用户
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode h1 = headA;
            ListNode h2 = headB;

            while (h1 != h2) {
                h1 = (h1 == null ? headB : h1.next);
                h2 = (h2 == null ? headA : h2.next);
            }
            return h1;
        }

    }

    public static void main(String[] args) {
        ListNode node8 = new ListNode(8);
        ListNode h1 = new ListNode(4);
        h1.next = new ListNode(1);
        h1.next.next = node8;
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next = new ListNode(5);

        ListNode h2 = new ListNode(5);
        h2.next = new ListNode(0);
        h2.next.next = new ListNode(1);
        h2.next.next.next = node8;
        logger.info("{}", new Solution().getIntersectionNode(h1, h2).val);
    }
}
