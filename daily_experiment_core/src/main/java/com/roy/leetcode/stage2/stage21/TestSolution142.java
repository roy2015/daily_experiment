package com.roy.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/3/19
 *
 *
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以使用 O(1) 空间解决此题？
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 *
 * 提示：
 *
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 */
public class TestSolution142 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution142.class);

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {

        /**
         *
         * 完美解决环形链表问题
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：38.3 MB, 在所有 Java 提交中击败了91.02%的用户
         *
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode f = head;
            ListNode s = head;
            //追击找到重合点
            do {
                if (f.next == null || f.next.next == null) {
                    return null;
                }
                f = f.next.next;
                s = s.next;
            } while (f != s);

            //相向而跑
            s = head;
            while (f != s) {
                f = f.next;
                s = s.next;
            }
            return f;
        }
    }

    public static void main(String[] args) {
        ListNode head, circleNode, startCircleNode;
        head = new ListNode(3);
        head.next = new ListNode(2);
        circleNode = head.next;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = circleNode;
        startCircleNode = new Solution().detectCycle(head);
        logger.info("{}", startCircleNode);

        head = new ListNode(1);
        circleNode = head;
        head.next = new ListNode(2);
        head.next.next = circleNode;
        startCircleNode = new Solution().detectCycle(head);
        logger.info("{}", startCircleNode);
    }
}
