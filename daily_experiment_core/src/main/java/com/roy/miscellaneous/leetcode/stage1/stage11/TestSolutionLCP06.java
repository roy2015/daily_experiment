package com.roy.miscellaneous.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/21 10:40
 *
 *
 * LCP 06. 拿硬币
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 *
 * 示例 1：
 *
 * 输入：[4,2,1]
 *
 * 输出：4
 *
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 *
 * 示例 2：
 *
 * 输入：[2,3,10]
 *
 * 输出：8
 *
 * 限制：
 *
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 *
 *
 */
public class TestSolutionLCP06 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionLCP06.class);


    static class Solution {

        /**
         * 
         * LCP: Leetcode cup?
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.3 MB, 在所有 Java 提交中击败了53.79%的用户
         *
         * @param coins
         * @return
         */
        public int minCount(int[] coins) {
            int minCount = 0;
            for (int coin : coins) {
                minCount += Math.ceil(coin / 2.0);
            }
            return minCount;

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().minCount(new int[]{4,2,1}));//4
        logger.info("{}", new Solution().minCount(new int[]{2,3,10}));//8
    }
}
