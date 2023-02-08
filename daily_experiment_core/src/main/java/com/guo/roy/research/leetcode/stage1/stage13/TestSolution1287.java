package com.guo.roy.research.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/17
 *
 * 1287. 有序数组中出现次数超过25%的元素
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * 请你找到并返回这个整数
 *
 *
 *
 * 示例：
 *
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 */
public class TestSolution1287 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1287.class);


    /**
     * 前提条件：已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%
     *
     *
     *
     *
     *
     */
    static class Solution {

        /**
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了45.43%的用户
         * 内存消耗：
         * 40.3 MB, 在所有 Java 提交中击败了8.33%的用户
         *
         * @param arr
         * @return
         */
        public int findSpecialInteger(int[] arr) {
            int len = arr.length;
            int bound = len / 4 +1; //超过25%， 用"/"刚好
            for (int i = 0; i < len  ; i++) {
                int times = 1;
                int iVal = arr[i];
                for (int j = i+1; j < len; j++) {
                    int jVal = arr[j];
                    if (jVal != iVal) {
                        break;
                    } else times ++;
                }
                if (times >= bound) {
                    return iVal;
                }
            }
            return -1;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findSpecialInteger(new int[]{ 1,2}));
        logger.info("{}", new Solution().findSpecialInteger(new int[]{ 2}));
        logger.info("{}", new Solution().findSpecialInteger(new int[]{ 1,2,2,6,6,6,6,7,10 }));//6
    }
}
