package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/9
 *
 *1550. 存在连续三个奇数的数组
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 * 示例 2：
 *
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 *
 */
public class TestSolution1550 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1550.class);


    static class Solution {
        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.4 MB, 在所有 Java 提交中击败了46.90%的用户
         *
         * @param arr
         * @return
         */
        public boolean threeConsecutiveOdds(int[] arr) {
            int length = arr.length;
            if (length < 3) return false;
            int maxI = length -3;
            for (int i = 0; i <= maxI; i++) {
                boolean checkRes = true;
                for (int j = 0; j < 3; j++) {
                    checkRes = checkRes && ((arr[i + j] & 0x1) == 1);
                    if (!checkRes) {
                        break;
                    }
                }
                if (checkRes) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().threeConsecutiveOdds(
                new int[]{1,1,1}));//true


        logger.info("{}", new Solution().threeConsecutiveOdds(
                new int[]{2,6,4,1}));//false

        logger.info("{}", new Solution().threeConsecutiveOdds(
                new int[]{1,2,34,3,4,5,7,23,12}));//true
    }
}
