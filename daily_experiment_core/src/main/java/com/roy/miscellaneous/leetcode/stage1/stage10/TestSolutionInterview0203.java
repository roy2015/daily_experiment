package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/18
 *
 * 面试题 02.03. 删除中间节点
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 *
 *
 *
 * 示例：
 *
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 * 通过次数24,688提交次数29,116
 *
 */
public class TestSolutionInterview0203 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0203.class);


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    static class Solution {
        /**
         *
         * 神一样的的题目，主要是理解题目，"删除"：可以是取代
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.5 MB, 在所有 Java 提交中击败了21.11%的用户
         *
         *
         * @param node
         */
        public void deleteNode(ListNode node) {
            ListNode nextNode = node.next;
            node.val = nextNode.val;
            node.next = nextNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        ListNode toDeleteNode = new ListNode(3);
        node1.next.next = toDeleteNode;
        toDeleteNode.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        new Solution().deleteNode(toDeleteNode);
        logger.info("{}", node1);
    }
}
