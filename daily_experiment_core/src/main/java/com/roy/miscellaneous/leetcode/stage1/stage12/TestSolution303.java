package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/13
 *
 *
 *
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 *
 */
public class TestSolution303 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution303.class);


    static class NumArray {
        private int[] nums;
        private int[] numSums;//每个元素之前（包括自己）的汇总和

        public NumArray(int[] nums) {
            this.nums = nums;
            int length = nums.length;
            numSums = new int[length];

            //重复计算了，O(n^2) 可以优化~~
            /*for (int i = 0; i < length; i++) {
                int tmpSum = 0;
                for (int j = i; j >= 0; j--) {
                    tmpSum += nums[j];
                }
                numSums[i] = tmpSum;
            }*/

            //上面的优化， 算法复杂度 O(n)
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    numSums[0] = nums[0];
                } else
                    numSums[i] = numSums[i - 1] + nums[i];
            }
        }

        /**
         *
         * 初始版本
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 80 ms, 在所有 Java 提交中击败了24.55%
         * 的用户
         * 内存消耗：
         * 43 MB
         * , 在所有 Java 提交中击败了
         * 10.56%的用户
         *
         * @param i
         * @param j
         * @return
         */
        public int sumRange(int i, int j) {
            int sum = 0;
            for (int k = i; k <= j ; k++) {
                sum += nums[k];
            }
            return sum;
        }

        /**
         *
         * 借鉴扣友的思路，比较巧妙，优化中还有优化点
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 10 ms, 在所有 Java 提交中击败了98.81%
         * 的用户
         * 内存消耗：
         * 42.7 MB, 在所有 Java 提交中击败了51.17%的用户
         * @param i
         * @param j
         * @return
         */
        public int sumRange1(int i, int j) {
            return numSums[j] - (i > 0  ? numSums[i-1] : 0) ;
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});

        logger.info("{}", numArray.sumRange1(0, 2));//1
        logger.info("{}", numArray.sumRange1(2, 5));//-1
    }
}
