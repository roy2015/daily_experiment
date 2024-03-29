package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/17.
 *给定一个带有头结点 head 的非空单链表，返回链表的中间结点。

 如果有两个中间结点，则返回第二个中间结点。

  

 示例 1：

 输入：[1,2,3,4,5]
 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 示例 2：

 输入：[1,2,3,4,5,6]
 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution876 {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution876.class);

    //Definition for singly-linked list.
    static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode fast =head;
            ListNode slow = head;

            while (fast.next != null) {
                slow = slow.next;
                if (fast.next.next != null) {
                    fast = fast.next.next;
                } else {
                    fast = fast.next;
                }
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next= new ListNode(4);
        head.next.next.next.next= new ListNode(5);
        head.next.next.next.next.next= new ListNode(6);
        ListNode listNode = new Solution().middleNode(head);
        logger.info("123");
    }
}
