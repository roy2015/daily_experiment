package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/2/22
 *
 * 1608. 特殊数组的特征值
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 *
 * 注意： x 不必 是 nums 的中的元素。
 *
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,5]
 * 输出：2
 * 解释：有 2 个元素（3 和 5）大于或等于 2 。
 * 示例 2：
 *
 * 输入：nums = [0,0]
 * 输出：-1
 * 解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
 * 如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
 * 如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
 * 如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
 * x 不能取更大的值，因为 nums 中只有两个元素。
 * 示例 3：
 *
 * 输入：nums = [0,4,3,0,4]
 * 输出：3
 * 解释：有 3 个元素大于或等于 3 。
 * 示例 4：
 *
 * 输入：nums = [3,6,7,7,0]
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 *
 */
public class TestSolution1608 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1608.class);

    static class Solution {

        /**
         *
         * 思路比较新奇， 从后往前的思路， 比如满足4个大于等于4，必然不会满足3个大于等于3，因为至少是4个大约等于3
         * 记录history即可
         * 1. 构造出现次数的数组  2. 遍历1数组
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了94.57%的用户
         * 内存消耗：36.7 MB, 在所有 Java 提交中击败了5.04%的用户
         *
         *
         * @param nums
         * @return
         */
        public int specialArray(int[] nums) {
            int MAX_SIZE = 1000;
            int[] timesArray = new int[MAX_SIZE + 1];

            //because 1 <= nums.length <= 100
            for (int num : nums) {
                timesArray[num] += 1;
            }
            //find first non-zero element
            int start = MAX_SIZE;
            while (timesArray[start] == 0 && start > -1) {
                start --;
            }
            //all element is zero
            if (start == -1) {
                return -1;
            }

            int history = 0;
            for (int i = start; i >= 0 ; i--) {
                int current = timesArray[i] + history;
                if (current == i) {
                    return i;
                }
                history = current;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().specialArray(new int[]{3,4,4,4,5}));//4
        logger.info("{}", new Solution().specialArray(new int[]{3,4,4,4,4}));//4
        logger.info("{}", new Solution().specialArray(new int[]{1,2,3}));//2
        logger.info("{}", new Solution().specialArray(new int[]{0,0,0}));//-1
    }
}
