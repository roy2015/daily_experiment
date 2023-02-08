package com.roy.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/25.
 *将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution21 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution21.class);

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     */
    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            if (l1 == null && l2==null) {
                return null;
            }

            ListNode retNode = new ListNode(0);
            ListNode l1Node = l1, l2Node = l2;
//1,2,4  1, 3,4
            if (l2 == null || ( l1 != null && l1.val <= l2.val)) {
                retNode = new ListNode(l1.val);
                l1Node = l1.next;
            } else  {
                retNode = new ListNode(l2.val);
                l2Node = l2.next;
            }
            ListNode tmpNode = retNode;

            while (l1Node != null || l2Node != null) {
                if ( l2Node == null || ( l1Node != null && l1Node.val<= l2Node.val)) {
                    tmpNode.next = new ListNode(l1Node.val);
                    l1Node = l1Node.next;
                } else {
                    tmpNode.next = new ListNode(l2Node.val);
                    l2Node = l2Node.next;
                }
                tmpNode = tmpNode.next;
            }
            return retNode;
        }
    }

    /**
     * 1->2->4, 1->3->4
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        logger.info("{}", new Solution().mergeTwoLists(l1, l2));
    }

}
