package com.roy.miscellaneous.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author guojun
 * @date 2020/8/14
 *
 *
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 *
 *
 */
public class TestSolution503 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution503.class);


    static class Solution {
        /**
         * 队列和栈一起用了，执行时间不怎么理想，待优化
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 2076 ms, 在所有 Java 提交中击败了5.04%的用户
         * 内存消耗：
         * 44.7 MB, 在所有 Java 提交中击败了5.16%的用户
         *
         *
         * @param nums
         * @return
         */
        public int[] nextGreaterElements(int[] nums) {
            if (nums.length == 0) {
                return new int[]{};
            }
            if (nums.length == 1) {
                return new int[]{-1};
            }

            LinkedList<Integer> queue = new LinkedList<>();
            for (int num : nums) {
                queue.add(num);
            }

            int len = nums.length;
            int[] retInts = new int[len];

            //开始计算
            for (int i = 0; i < len; i++) {
                Stack<Integer> tmpStack = new Stack<>();
                Integer target = queue.pop();
                tmpStack.push(target);
                //计数器
                int count = 1;
                while (count < len && queue.peek().compareTo(target) <= 0) {
                    Integer tmp = queue.pop();
                    tmpStack.push(tmp);
                    count ++;
                }
                if (count == len) {
                    retInts[i] = -1;
                } else {
                    retInts[i] = queue.peek();
                }

                while (!tmpStack.isEmpty()) {
                    queue.addFirst(tmpStack.pop());
                }
                queue.addLast(queue.pop());
            }
            return retInts;
        }

        /**
         *
         * 不用队列也不用栈
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 35 ms, 在所有 Java 提交中击败了16.22%的用户
         * 内存消耗：
         * 40.6 MB, 在所有 Java 提交中击败了92.54%
         * 的用户
         *
         * @param nums
         * @return
         */
        public int[] nextGreaterElements1(int[] nums) {
            if (nums.length == 0) {
                return new int[]{};
            }
            if (nums.length == 1) {
                return new int[]{-1};
            }

            int len = nums.length;
            int[] retInts = new int[len];

            //开始计算
            for (int i = 0; i < len; i++) {
                int targetVal = nums[i];

                int j = i + 1;
                for (; j < len; j++) {
                    int jVal = nums[j];
                    if (jVal > targetVal) {
                        retInts[i] = jVal;
                        break;
                    }
                }
                if (j == len) {
                    j = 0;
                    for (; j < i; j++) {
                        int jVal = nums[j];
                        if (jVal > targetVal) {
                            retInts[i] = jVal;
                            break;
                        }
                    }

                    if (j == i) {
                        retInts[i] = -1;
                    } else {}
                } else {}


            }
            return retInts;
        }


        /**
         *
         * 解3
         *  其他人的奇巧思路
         *
         *  执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 6 ms, 在所有 Java 提交中击败了96.30%的用户
         * 内存消耗：
         * 40.9 MB, 在所有 Java 提交中击败了77.09%的用户
         * @param nums
         * @return
         */
        public int[] nextGreaterElements2(int[] nums) {
            /*队列当栈用*/
            Deque<Integer> queue = new ArrayDeque<>();
            int len = nums.length;
            int[] dp = new int[len];
            Arrays.fill(dp, -1);
            for (int i = 0; i< len * 2; i++) {
                while (!queue.isEmpty() && nums[queue.peek()] < nums[i % len] ) {
                    dp[queue.poll()] = nums[i % len];
                }
                if (i < len) {
                    queue.addFirst(i);
                }
            }
            return dp;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().nextGreaterElements2(new int[]{1,2,3,1}));//[2,3,-1,2]
        logger.info("{}", new Solution().nextGreaterElements2(new int[]{}));//[]
        logger.info("{}", new Solution().nextGreaterElements2(new int[]{1}));//[-1]
        logger.info("{}", new Solution().nextGreaterElements2(new int[]{1,2,1}));//[2,-1,2]
    }
}
