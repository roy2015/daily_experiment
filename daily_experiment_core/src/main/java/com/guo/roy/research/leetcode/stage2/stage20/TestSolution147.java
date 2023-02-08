package com.guo.roy.research.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/19
 *
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 *
 *
 */
public class TestSolution147 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution147.class);


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
         * 五个指针变量，各种debug出来，虽然执行用时比较不理想
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：28 ms, 在所有 Java 提交中击败了25.74%的用户
         * 内存消耗：39.5 MB, 在所有 Java 提交中击败了46.38%的用户
         *
         * @param head
         * @return
         */
        public ListNode insertionSortList(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode currHead;
            ListNode preCalNode;//附加指针
            ListNode calNode;
            ListNode toSortNode;
            ListNode preToSortNode;

            currHead = head;
            toSortNode = currHead.next;
            preToSortNode = currHead;

            while (toSortNode != null) {
                preCalNode = null;
                calNode = currHead;//从头开始

                //find insert point(寻找插入点)
                while (calNode.val <= toSortNode.val && calNode != toSortNode) {
                    preCalNode = calNode;
                    calNode = calNode.next;
                }
                //do insert
                if (calNode.val > toSortNode.val) {
                    if (preCalNode == null) {
                        currHead = toSortNode;//换头节点
                    } else {
                        preCalNode.next = toSortNode;
                    }
                    preToSortNode.next = toSortNode.next;
                    toSortNode.next = calNode;
                    toSortNode =  preToSortNode.next;
                } else {
                    preToSortNode = toSortNode;
                    toSortNode = toSortNode.next;
                }
            }
            return currHead;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(1);
        node1.next.next.next = new ListNode(3);
        ListNode head = new Solution().insertionSortList(node1);

        logger.info("{}", head);
    }
}
