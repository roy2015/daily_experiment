package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/17
 *
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class TestSolution941 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution941.class);


    static class Solution {
        /**
         *
         * O(n)的时间复杂度
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 40.8 MB, 在所有 Java 提交中击败了50.00%的用户
         *
         * @param A
         * @return
         */
        public boolean validMountainArray(int[] A) {
            int len = A.length;
            if (len < 3) {
                return false;
            }

            boolean hasPeek = false;
            int i = 1;
            //找第一个高峰(即第一个下降点的前一个)
            while(i < len -1) {
                //验证递增
                if (A[i] <= A[i-1] ) {
                    break;
                }
                i++;
            }
            if (i == 1) {
                return false;
            }
            while(i < len) {
                //验证递减
                if (A[i] >= A[i-1] ) {
                    return false;
                }
                i++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution());
    }
}
