package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

import java.util.LinkedList;

/**
 * @author guojun
 * @date 2021/3/31
 *
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 *
 */
public class TestSolutionJZoffer59_I {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionJZoffer59_I.class);


    static class Solution {
        /**
         *
         * 一个套路，直接套
         *
         * @see com.guo.roy.research.leetcode.stage1.stage12.TestSolutionJZoffer59_II
         * 执行结果：通过
         * 显示详情
         * 执行用时：11 ms, 在所有 Java 提交中击败了90.46%的用户
         * 内存消耗：47.2 MB, 在所有 Java 提交中击败了44.02%的用户
         *
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            if (len == 0) {
                return nums;
            }

            if (k == 1) {
                return nums;
            }
            int[] ret = new int[len - k + 1];

            LinkedList<Integer> maxQueue = new LinkedList<>();
            //形成长度K的窗口
            for (int i = 0; i < k; i++) {
                while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[i]) {
                    maxQueue.pollLast();
                }
                maxQueue.add(nums[i]);
            }
            ret[0] = maxQueue.peek();

            //开始计算
            for (int i = 1; i <= len - k; i++) {
                if (nums[i - 1] == maxQueue.peek()) {
                    maxQueue.poll();
                }
                int newVal = nums[i + k -1];
                while (!maxQueue.isEmpty() && maxQueue.peekLast() < newVal) {
                    maxQueue.pollLast();
                }
                maxQueue.add(newVal);
                ret[i] = maxQueue.peek();
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));//3,3,5,5,6,7

        logger.info("{}", new Solution().maxSlidingWindow(
                new int[]{1,3,1,2,0,5}, 3));//3 3 2 5

        logger.info("{}", new Solution().maxSlidingWindow(
                new int[]{1,3,-1,-3,2,3,6,7}, 3));//3, 3, 2, 3, 6, 7
    }
}
