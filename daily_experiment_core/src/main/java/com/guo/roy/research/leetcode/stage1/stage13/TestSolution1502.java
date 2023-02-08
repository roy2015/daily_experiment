package com.guo.roy.research.leetcode.stage1.stage13;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/8
 *
 * 1502. 判断能否形成等差数列
 * 给你一个数字数组 arr 。
 *
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 *
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,5,1]
 * 输出：true
 * 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
 * 示例 2：
 *
 * 输入：arr = [1,2,4]
 * 输出：false
 * 解释：无法通过重新排序得到等差数列。
 *
 *
 * 提示：
 *
 * 2 <= arr.length <= 1000
 * -10^6 <= arr[i] <= 10^6
 *
 *
 *
 */
public class TestSolution1502 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1502.class);


    static class Solution {

        /**
         *
         *
         * 朴素的解法，看来大家都这么想啊
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了99.93%的用户
         * 内存消耗：
         * 39.4 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param arr
         * @return
         */
        public boolean canMakeArithmeticProgression(int[] arr) {
            int length = arr.length;
            if (length == 0 || length == 1 || length == 2) {
                return true;
            }
            //start
            Arrays.sort(arr);
            int diff = arr[1] - arr[0];
            for (int i = 2; i < length; i++) {
                if (arr[i] - arr[i - 1] != diff) {
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().canMakeArithmeticProgression(new int[]{ 1,3,5}));//true
        logger.info("{}", new Solution().canMakeArithmeticProgression(new int[]{ 1,3,4}));//false
    }
}
