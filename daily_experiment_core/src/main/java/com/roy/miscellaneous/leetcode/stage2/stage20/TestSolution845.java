package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 *
 * 845. 数组中的最长山脉 把符合下列属性的数组 arr 称为 山脉数组 ：
 *
 * arr.length >= 3 存在下标 i（0 < i < arr.length - 1），满足 arr[0] < arr[1] < ... < arr[i - 1] < arr[i] arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 给出一个整数数组
 * arr，返回最长山脉子数组的长度。如果不存在山脉子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [2,1,4,7,3,2,5] 输出：5 解释：最长的山脉子数组是 [1,4,7,3,2]，长度为 5。 示例 2：
 *
 * 输入：arr = [2,2,2] 输出：0 解释：不存在山脉子数组。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 104 0 <= arr[i] <= 104
 *
 * @author guojun
 * @date 2021/1/21 10:40
 */
public class TestSolution845 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution845.class);

    static class Solution {

        /**
         *
         * 堆变量堆出来的
         *
         * 执行结果：
         * 通过
         *
         * 执行用时：2 ms, 在所有 Java 提交中击败了99.83%的用户
         * 内存消耗：41.9 MB, 在所有 Java 提交中击败了23.64%的用户
         * 
         * @param arr
         * @return
         */
        public int longestMountain(int[] arr) {
            int length = arr.length;
            if (length < 3) {
                return 0;
            }
            int store = 0;
            int k = 0;

            while (true) {
                int i;
                int currentLen = 1;
                int flag = 0;// 标志位
                int peak = 0;// 山峰
                // find peak;
                for (i = k; i < length - 1; i++) {
                    int gap = (arr[i + 1] - arr[i]);
                    if (gap == 0) {
                        flag = 1;
                        break;
                    } else if (gap < 0) {
                        flag = 2;
                        break;
                    } else {
                        currentLen++;
                    }
                }
                if (flag == 1) {
                    k = i + 1;
                    continue;
                } else if (flag == 2) {
                    if (currentLen == 1) {
                        k++;
                        continue;
                    }
                    peak = i;
                } else
                    break;

                // find valley
                int j;
                flag = 0;
                for (j = peak; j < length - 1; j++) {
                    int gap = arr[j + 1] - arr[j];
                    if (gap == 0) {
                        flag = 1;
                        break;
                    } else if (gap > 0) {
                        flag = 2;
                        break;
                    } else {
                        currentLen++;
                    }
                }
                if (j == length - 1) {
                    if (currentLen > store) {
                        store = currentLen;
                    }
                    break;
                }
                if (currentLen > store) {
                    store = currentLen;
                }
                if (flag == 1) {
                    k = j + 1;
                } else if (flag == 2) {
                    k = j;
                } else {
                }
            }
            return store;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().longestMountain(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }));// 0
        logger.info("{}", new Solution().longestMountain(new int[] { 0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 }));// 11
        logger.info("{}", new Solution().longestMountain(new int[] { 2, 1, 4, 7, 3, 2, 5 }));// 5
        logger.info("{}", new Solution().longestMountain(new int[] { 2, 2, 2 }));// 0
        logger.info("{}", new Solution().longestMountain(new int[] { 1, 3, 2, 2, 4, 5 }));// 3
    }
}
