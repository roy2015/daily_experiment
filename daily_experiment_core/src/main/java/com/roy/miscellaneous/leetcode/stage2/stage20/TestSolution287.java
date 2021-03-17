package com.roy.miscellaneous.leetcode.stage2.stage20;

import java.util.BitSet;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/2/3
 *
 *
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 示例 3：
 *
 * 输入：nums = [1,1]
 * 输出：1
 * 示例 4：
 *
 * 输入：nums = [1,1,2]
 * 输出：1
 *
 *
 * 提示：
 *
 * 2 <= n <= 3 * 104
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *
 *
 * 进阶：
 *
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以在不修改数组 nums 的情况下解决这个问题吗？
 * 你可以只用常量级 O(1) 的额外空间解决这个问题吗？
 * 你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？
 *
 *
 *
 */
public class TestSolution287 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution287.class);


    static class Solution {
        /**
         *
         * 不纠结了，直接BitSet搞
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：2 ms, 在所有 Java 提交中击败了63.66%的用户
         * 内存消耗：38.5 MB, 在所有 Java 提交中击败了34.43%的用户
         *
         * @param nums
         * @return
         */
        public int findDuplicate(int[] nums) {
            int n = nums.length -1;
            BitSet bitSet = new BitSet(n);
            for (int i = 0; i <= n; i++) {
                int iVal = nums[i];
                boolean b = bitSet.get(iVal);
                if (b) {
                    return iVal;
                } else {
                    bitSet.set(iVal, true);
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findDuplicate(new int[]{1,1,2}));//1
        logger.info("{}", new Solution().findDuplicate(new int[]{1,1}));//1
        logger.info("{}", new Solution().findDuplicate(new int[]{1,3,4,2,2}));//2


    }
}
