package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/19 10:40
 *
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 */
public class TestSolutionJZoffer06 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionJZoffer06.class);


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * 关键点： 链表逆序
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 40.4 MB, 在所有 Java 提交中击败了53.33%的用户
         *
         * @param head
         * @return
         */
        public int[] reversePrint(ListNode head) {
            ListNode node = head;
            ListNode preNode = null;//给下一个迭代准备的node
            ListNode nextNode =null;
            int i = 0;//记录节点长度

            //链表逆序
            while (node != null) {
                nextNode = node.next;//暂存next
                node.next = preNode;
                preNode = node;
                node = nextNode;
                i ++;
            }

            //遍历逆序的链表，依次输入到数组
            int[] rets = new int[i];
            int k = 0;
            node = preNode;
            while (node != null) {
                rets[k ++] = node.val;
                node = node.next;
            }
            return rets;
        }


    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(2);


        logger.info("{}", new Solution().reversePrint(node1));
    }
}
