package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 *
 * 747. 至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 示例 1:
 *
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *
 *
 * 示例 2:
 *
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *
 *
 * 提示:
 *
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 100].
 */
public class TestSolution747 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution747.class);


    static class Solution {

        /**
         *
         * 新增一个变量，记录第二大的元素值
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37.6 MB, 在所有 Java 提交中击败了6.25%的用户
         *
         * @param nums
         * @return
         */
        public int dominantIndex(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return 0;
            }
            int firstBigIdx = 0;
            int firstBigVal = nums[0];
            int secondBigVal = nums[0];

            for (int i = 0; i < length; i++) {
                int iVal = nums[i];
                if (iVal > firstBigVal) {
                    secondBigVal = firstBigVal;
                    firstBigVal = iVal;
                    firstBigIdx = i;
                } else if (iVal < firstBigVal) {
                    if ( secondBigVal == firstBigVal || iVal > secondBigVal ) {
                        secondBigVal = iVal;
                    } else {}
                } else {}
            }

            if (firstBigVal == secondBigVal) {
                return 0;
            } else {
                return firstBigVal >= secondBigVal * 2 ? firstBigIdx : -1;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().dominantIndex(new int[]{3,0,0,2}));//-1
        logger.info("{}", new Solution().dominantIndex(new int[]{-1,0,2,2,2}));//2
        logger.info("{}", new Solution().dominantIndex(new int[]{1,1}));//0
        logger.info("{}", new Solution().dominantIndex(new int[]{3,6,1,0}));//1
        logger.info("{}", new Solution().dominantIndex(new int[]{1,0}));//0
        logger.info("{}", new Solution().dominantIndex(new int[]{0,0}));//0
        logger.info("{}", new Solution().dominantIndex(new int[]{0,1}));//1
        logger.info("{}", new Solution().dominantIndex(new int[]{-1,0,0}));//1
    }
}
