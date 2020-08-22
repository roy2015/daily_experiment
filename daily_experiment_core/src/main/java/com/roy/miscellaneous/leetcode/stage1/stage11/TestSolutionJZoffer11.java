package com.roy.miscellaneous.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/20
 *
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 *
 *
 */
public class TestSolutionJZoffer11 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionJZoffer11.class);


    static class Solution {

        /**
         *
         * 不用二分查找，直接查第一个递减的元素， 再和numbers[0]求min
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.4 MB, 在所有 Java 提交中击败了82.73%的用户
         *
         * @param numbers
         * @return
         */
        public int minArray(int[] numbers) {
            int candidateMin = numbers[0];
            int length = numbers.length;

            int idx = 0;
            while (idx < length -1 && numbers[idx] <= numbers[idx + 1] ) {
                idx ++;
            }
            if (idx < length -1) {
                return Math.min(candidateMin, numbers[idx + 1]);
            } else {
                return candidateMin;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().minArray(new int[]{2,2,2,0,1}));//0
        logger.info("{}", new Solution().minArray(new int[]{3,4,5,1,2}));//1
    }
}
