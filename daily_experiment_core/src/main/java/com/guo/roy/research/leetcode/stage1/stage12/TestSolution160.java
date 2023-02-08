package com.guo.roy.research.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/25
 *
 *
 * 160. 相交链表
编写一个程序，找到两个单链表相交的起始节点。

如下面的两个链表：



在节点 c1 开始相交。



示例 1：



输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。


示例 2：



输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。


示例 3：



输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。


注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 */
public class TestSolution160 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution160.class);


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * 先求长度差
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :1 ms, 在所有 Java 提交中击败了99.97%的用户
         内存消耗 :42.7 MB, 在所有 Java 提交中击败了73.81%的用户
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA;
            ListNode q = headB;

            int aLen = 0;
            int bLen = 0;
            while (p != null || q != null) {
                if (p != null) {
                    aLen ++;
                    p = p.next;
                }
                if (q != null) {
                    bLen ++;
                    q = q.next;
                }
            }

            int gap = aLen - bLen;
            if (gap > 0) {
                p = headA;
                q = headB;
            } else {
                p = headB;
                q = headA;
                gap = -gap;
            }

            while (p != null || q != null) {
                if (gap != 0) {
                    p = p.next;
                    gap --;
                } else {
                    if (p == q) {
                        return p;
                    }
                    p = p.next;
                    q = q.next;
                }
            }
            return null;
        }

    }

    public static void main(String[] args) {
        //三个公共node
        ListNode listNodeC1 = new ListNode(8);
        ListNode listNodeC2 = new ListNode(4);
        ListNode listNodeC3 = new ListNode(5);
        listNodeC1.next = listNodeC2;
        listNodeC2.next = listNodeC3;

        ListNode listNode11 = new ListNode(4);
        ListNode listNode12 = new ListNode(1);
        listNode11.next = listNode12;
        listNode12.next = listNodeC1;

        ListNode listNode21 = new ListNode(5);
        ListNode listNode22 = new ListNode(0);
        ListNode listNode23 = new ListNode(1);

        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = listNodeC1;

        logger.info("{}", new Solution().getIntersectionNode(listNode11, listNode21).val);

        listNode11 = new ListNode(2);
        listNode12 = new ListNode(6);
        ListNode listNode13 = new ListNode(4);
        listNode11.next = listNode12;
        listNode12.next = listNode13;

        listNode21 = new ListNode(1);
        listNode22 = new ListNode(5);
        listNode21.next = listNode22;
        logger.info("{}", new Solution().getIntersectionNode(listNode11, listNode21));
    }
}
