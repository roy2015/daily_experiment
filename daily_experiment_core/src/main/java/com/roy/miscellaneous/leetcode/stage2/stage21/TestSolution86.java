package com.roy.miscellaneous.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 *
 * 86. 分隔链表
 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

 你应当 保留 两个分区中每个节点的初始相对位置。



 示例 1：


 输入：head = [1,4,3,2,5,2], x = 3
 输出：[1,2,2,4,3,5]
 示例 2：

 输入：head = [2,1], x = 2
 输出：[1,2]


 提示：

 链表中节点的数目在范围 [0, 200] 内
 -100 <= Node.val <= 100
 -200 <= x <= 200

 *
 *
 * @author guojun
 * @date 2021/10/19
 */
public class TestSolution86 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution86.class);


//    Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    static class Solution {

        /**
         *
         * 执行结果：通过 显示详情添加备注
         执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗：37.4 MB, 在所有 Java 提交中击败了96.56%的用户
         通过测试用例：
         168 / 168
         *
         * @param head
         * @param x
         * @return
         */
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return head;
            }
            ListNode last = null;
            ListNode newHead , preNode ,currentNode;
            //求头
            if (head.val < x) {
                newHead = head;
            } else {
                currentNode = head;
                preNode = null;
                while (currentNode != null && currentNode.val >= x ) {
                    preNode = currentNode;
                    currentNode = currentNode.next;
                }
                //没有比x小的node,不动返回
                if (currentNode == null) {
                    return head;
                }
                preNode.next = currentNode.next;
                newHead = currentNode;
                currentNode.next = head;
            }

            currentNode = newHead.next;
            last = newHead;
            preNode = newHead;
            while (currentNode != null) {
                if (currentNode.val < x ) {
                    if (last != preNode) {
                        preNode.next = currentNode.next;
                        currentNode.next = last.next;
                        last.next = currentNode;
                        last = currentNode;
                        currentNode = preNode.next;
                    } else {
                        last = currentNode;
                        preNode = currentNode;
                        currentNode = currentNode.next;
                    }

                } else {
                    preNode = currentNode;
                    currentNode = currentNode.next;
                }
            }
            return newHead;
        }

        public void print(ListNode head) {
            StringBuffer stringBuffer = new StringBuffer();
            while (head != null) {
                stringBuffer.append(head.val).append("->");
                head = head.next;
            }
            logger.info(stringBuffer.substring(0, stringBuffer.length() -2));
        }

    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode partition = null;

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        new Solution().print(head);//123
        partition = new Solution().partition(head, 4);
        new Solution().print(partition);//123

        head = new ListNode(1);
        head.next = new ListNode(1);
        new Solution().print(head);//11
        partition = new Solution().partition(head, 2);
        new Solution().print(partition);//11

        head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);
        new Solution().print(head);//34251
        partition = new Solution().partition(head, 3);
        new Solution().print(partition);//21345

        head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);
//        new Solution().print(head);//34251
        partition = new Solution().partition(head, 4);
        new Solution().print(partition);//32145

        head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);
//        new Solution().print(head);//34251
        partition = new Solution().partition(head, 1);
        new Solution().print(partition);//34251

        head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);
//        new Solution().print(head);//34251
        partition = new Solution().partition(head, 2);
        new Solution().print(partition);//13425

    }
}
