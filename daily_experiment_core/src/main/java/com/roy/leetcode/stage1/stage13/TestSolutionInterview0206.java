package com.roy.leetcode.stage1.stage13;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/3
 *
 *
 *
 * 面试题 02.06. 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 *
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 *
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */
public class TestSolutionInterview0206 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0206.class);

    static  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * 借鉴下思路，还是不错的， 链表逆序输出用递归，顺序输出用循环
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 8 ms
         * , 在所有
         * Java 提交中击败了
         * 5.77%
         * 的用户
         * 内存消耗：
         * 51.2 MB,
         * 在所有
         * Java 提交中击败了5.09%的用户
         *
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            //先排除调特殊情况
            if (head == null) {
                return true;
            }
            //start
            List<Integer> shunxuList = new ArrayList<Integer>();
            List<Integer> nixuList = new ArrayList<Integer>();

            fetchShunxuList(head , shunxuList);
            fetchNixuList(head , nixuList);

            int size = shunxuList.size();
            for (int i = 0; i < size; i++) {
                Integer shunVal = shunxuList.get(i);
                Integer niVal = nixuList.get(i);
                if (shunVal.compareTo(niVal) != 0) {
                    return false;
                }
            }
            return true;

        }

        private void fetchShunxuList(ListNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            list.add(node.val);
            fetchShunxuList(node.next, list);
        }

        private void fetchNixuList(ListNode node, List<Integer> list) {
            if (node.next == null) {
                list.add(node.val);
                return;
            }
            fetchNixuList(node.next, list);
            list.add(node.val);
        }
    }

    public static void main(String[] args) {
        ListNode head;
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        logger.info("{}", new Solution().isPalindrome(head));//false


        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        logger.info("{}", new Solution().isPalindrome(head));//true

        head.next.next = null;
        logger.info("{}", new Solution().isPalindrome(head));//false
    }

}
