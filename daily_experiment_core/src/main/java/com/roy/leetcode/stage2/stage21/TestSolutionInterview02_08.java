package com.roy.leetcode.stage2.stage21;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/3
 * <p>
 * 面试题 02.08. 环路检测
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
public class TestSolutionInterview02_08 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview02_08.class);

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
         *
         * 暴力破解，1. 记住走过的轨迹，当前接口在历史轨迹里，2. 遇到null说明是无环结束
         * 有相似题目，那个只需判断是否有环不用返回环头，
         * 所以可以采用快慢指针类似追击问题
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：456 ms, 在所有 Java 提交中击败了6.32%的用户
         * 内存消耗：39.7 MB, 在所有 Java 提交中击败了72.15%的用户
         *
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            ListNode currentNode = head;
            List<ListNode> existsList = new ArrayList<>();
            while (true) {
                if (currentNode == null) {
                    return null;
                }

                if (existsList.contains(currentNode)) {
                    return currentNode;
                } else {
                    existsList.add(currentNode);
                }

                currentNode = currentNode.next;
            }
        }

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(0);
        node1.next.next.next = new ListNode(-4);
        node1.next.next.next.next = node1.next;

        ListNode retNode = new Solution().detectCycle(node1);
        logger.info("{}", retNode);


    }
}
