package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/13 11:58
 *
 * 1304. 和为零的N个唯一整数
给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。



示例 1：

输入：n = 5
输出：[-7,-1,1,3,4]
解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
示例 2：

输入：n = 3
输出：[-1,0,1]
示例 3：

输入：n = 1
输出：[0]


提示：

1 <= n <= 1000
 */
public class TestSolution1304 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1304.class);


    static class Solution {

        /**
         *
         * 这是开放题，答案不唯一
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :38 MB, 在所有 Java 提交中击败了6.67%的用户
         *
         * @param n
         * @return
         */
        public int[] sumZero(int n) {
            int[]  ret = new int[n];
            for(int i =0; i< n -1; i++) {
                ret[i] = i;
            }
            if (n >1) {
                ret [n -1] = (n-1)*(n-2) /2 * -1;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution());
    }
}
