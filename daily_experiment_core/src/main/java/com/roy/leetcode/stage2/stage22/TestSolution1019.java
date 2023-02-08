package com.roy.leetcode.stage2.stage22;

import java.util.*;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/14
 *
 *
 * 1019. 链表中的下一个更大节点
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *
 *
 * 提示：
 *
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 *
 *
 *
 */
public class TestSolution1019 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1019.class);

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {

        /**
         * 举一反三，和 {@link com.roy.leetcode.stage2.stage22.TestSolution503}  相似
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 42 ms, 在所有 Java 提交中击败了34.25%的用户
         * 内存消耗：
         * 48 MB, 在所有 Java 提交中击败了5.19%的用户
         *
         * @param head
         * @return
         */
        public int[] nextLargerNodes(ListNode head) {
            Deque<Integer> stack = new ArrayDeque<>();
            Map<Integer, Integer> dicMap = new HashMap<>();
            Map<Integer, Integer> dataMap = new HashMap<>();
            int idx = 0;
            do {
                dicMap.put(idx, head.val);
                while (!stack.isEmpty() && dicMap.get(stack.peek()).compareTo(head.val) < 0 ) {
                    dataMap.put(stack.poll(), head.val);
                }
                stack.push(idx);
                idx ++;
                head = head.next;
            } while (head != null);
            int[] retInts = new int[idx];
            for (int i = 0; i < idx; i++) {
                retInts[i] = dataMap.getOrDefault(i, 0);
            }
            return retInts;
        }

        /**
         *
         * 优化，相比与 {@link #nextLargerNodes(ListNode)}, 把两个map换成了数组
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 17 ms, 在所有 Java 提交中击败了88.49%的用户
         * 内存消耗：
         * 43.7 MB, 在所有 Java 提交中击败了77.92%的用户
         *
         * @param head
         * @return
         */
        public int[] nextLargerNodes1(ListNode head) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] nums = new int[1000];
            int[] data = new int[1000];
            int idx = 0;
            do {
                nums[idx] = head.val;
                while (!stack.isEmpty() && nums[stack.peek()] < head.val ) {
                    data[stack.poll()] = head.val;
                }
                stack.push(idx);
                idx ++;
                head = head.next;
            } while (head != null);
            return Arrays.copyOfRange(data, 0 ,idx);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        logger.info("{}", new Solution().nextLargerNodes1(head));//[5,5,0]
        logger.info("{}", new Solution().nextLargerNodes1(new ListNode(9)));//[0]
    }
}
