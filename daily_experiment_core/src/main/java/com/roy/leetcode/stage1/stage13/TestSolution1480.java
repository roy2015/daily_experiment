package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/17
 *
 *
 * 1480. 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * 请返回 nums 的动态和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 *
 *
 */
public class TestSolution1480 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1480.class);


    static class Solution {
        /**
         *
         * 双百
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：40.3 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param nums
         * @return
         */
        public int[] runningSum(int[] nums) {
            int len = nums.length;
            for(int i = 1; i< len; i++) {
                nums[i] = nums[i -1] + nums[i];
            }
            return nums;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution());
    }
}
