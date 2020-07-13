package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/13
 *
 *
 * 面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 *
 *
 *
 *
 */
public class TestSolutionInterview1611 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview1611.class);

    static class Solution {

        /**
         * so easy, 双百
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 47.7 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param shorter
         * @param longer
         * @param k
         * @return
         */
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0) {
                //定义空数组
                return new int[0];
            }

            //如果两个数相等，都是重复的
            if (shorter == longer) {
                return new int[]{k * shorter};
            }

            //不相等的，不会重复
            int[] ret = null;
            ret = new int[k + 1];
            int gap = longer - shorter;
            int minVal = k * shorter;
            int maxVal = k * longer;

            int idx = 0;
            for (int val = minVal; val <= maxVal ; val += gap) {
                ret[idx ++] = val ;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().divingBoard(1,1 ,0));//[]
        logger.info("{}", new Solution().divingBoard(1,2 ,3));//[3,4,5,6]
        logger.info("{}", new Solution().divingBoard(1,1 ,100000));//[100000]
    }

}
