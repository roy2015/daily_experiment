package com.roy.miscellaneous.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/13
 */
public class TestSolution172 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution172.class);


    static class Solution {
        /**
         * 扣友反映是小红书的题目
         * 借鉴了一点思路，但是实现自己写的，好巧妙的思路
         * 思路： 统计因子5的个数，2不用统计(因为2的个数远远大于5)
         *   5， 5*5， 5*5*5， 5*5*5*5
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.89%的用户
         * 内存消耗：35.4 MB, 在所有 Java 提交中击败了99.14%的用户
         *
         * @param n
         * @return
         */
        public int trailingZeroes(int n) {
            int count = 0;
            int factor = 5;
            while (factor <= n) {
                count += n / factor;
                factor *= 5;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().trailingZeroes(30));
    }
}
