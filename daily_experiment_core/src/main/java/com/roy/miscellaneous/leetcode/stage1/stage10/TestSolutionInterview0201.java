package com.roy.miscellaneous.leetcode.stage1.stage10;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/19
 *
 *
 * 面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 *
 *
 */
public class TestSolutionInterview0201 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0201.class);


    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    static class Solution {

        /**
         *
         * 类似双指针
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：6 ms, 在所有 Java 提交中击败了72.63%的用户
         * 内存消耗：41.5 MB, 在所有 Java 提交中击败了10.01%的用户
         *
         * @param head
         * @return
         */
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            Set<Integer> existNodes = new HashSet<>();
            ListNode newHead = new ListNode(head.val);
            ListNode calNode = newHead;
            ListNode startNode = head.next;//第二个节点
            existNodes.add(head.val);

            while (startNode != null ) {
                if (!existNodes.contains(startNode.val)) {
                    existNodes.add(startNode.val);
                    calNode.next = new ListNode(startNode.val);
                    calNode = calNode.next;
                }
                startNode = startNode.next;
            }
            return newHead;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(2);
        node1.next.next.next.next = new ListNode(1);
        logger.info("{}", new Solution().removeDuplicateNodes(node1));
    }
}
