package com.roy.leetcode.stage2.stage20;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * 646. 最长数对链
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 *
 *
 * 示例：
 *
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *
 *
 * 提示：
 *
 * 给出数对的个数在 [1, 1000] 范围内。
 *
 * @author guojun
 * @date 2021/1/21 10:40
 */
public class TestSolution646 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution646.class);


    static class Solution {
        /**
         *
         *
         * 先排序后dp，一次过
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：34 ms, 在所有 Java 提交中击败了27.49%的用户
         * 内存消耗：41.9 MB, 在所有 Java 提交中击败了5.04%的用户
         * 通过测试用例：
         * 205 / 205
         *
         * @param pairs
         * @return
         */
        public int findLongestChain(int[][] pairs) {
            int len = pairs.length;
            Triple[] data = new Triple[len];
            for (int i = 0; i < len; i++) {
                int[] pair = pairs[i];
                data[i] = new Triple(pair[0], pair[1]);
            }
            Arrays.sort(data);
            int[] dp = new int[len];
            dp[0] = 1;
            for (int i = 1; i < len; i++) {
                Triple currPair = data[i];
                int count = 0;
                for (int j = i -1; j >= 0 ; j--) {
                    Triple prePair = data[j];
                    if (currPair.d1 > prePair.d2 && dp[j] > count) {
                        count = dp[j];
                    }
                }
                dp[i] = count + 1;
            }
            int ret = 0;
            for (int i : dp) {
                if (i > ret) {
                    ret  = i;
                }
            }
            return ret;
        }

        class Triple implements Comparable<Triple> {
            private int d1;
            private int d2;

            public Triple(int d1, int d2) {
                this.d1 = d1;
                this.d2 = d2;
            }

            @Override
            public int compareTo(Triple o) {
                if (this.d1 < o.d1) {
                    return -1;
                } else if (this.d1 > o.d1) {
                    return 1;
                } else if (this.d2 < o.d2) {
                    return -1;
                } else if (this.d2 < o.d2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findLongestChain(new int[][]{
            {3,4},{1,2},{2,3},
        }));//2
    }
}
