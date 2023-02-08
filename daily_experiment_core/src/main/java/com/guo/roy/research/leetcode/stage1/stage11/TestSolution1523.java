package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/3
 *
 *
 * 1523. 在区间范围内统计奇数数目
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 * 示例 2：
 *
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 *
 *
 * 提示：
 *
 * 0 <= low <= high <= 10^9
 *
 *
 */
public class TestSolution1523 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1523.class);


    static class Solution {
        /**
         *
         * 考虑特殊情况 low== hight且为奇数
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 36.5 MB
         * , 在所有 Java 提交中击败了39.62%的用户
         *
         * @param low
         * @param high
         * @return
         */
        public int countOdds(int low, int high) {
            if ((low & 0x1) == 1) {
                return 1 + (high - low) /2;
            } else{
                if (high == low) {
                    return 0;
                }
                return 1 + (high - low - 1) /2;
            }

        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().countOdds(3,7));//3
        logger.info("{}", new Solution().countOdds(8,10));//1
        logger.info("{}", new Solution().countOdds(3,3));//1
        logger.info("{}", new Solution().countOdds(2,2));//0
    }
}
