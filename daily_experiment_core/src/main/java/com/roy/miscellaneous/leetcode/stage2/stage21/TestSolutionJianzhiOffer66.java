package com.roy.miscellaneous.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 *
 *剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 *
 * 不能使用除法。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 *
 * 提示：
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 *
 * @author guojun
 * @date 2021/8/6
 */
public class TestSolutionJianzhiOffer66 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionJianzhiOffer66.class);


    static class Solution {
        /**
         * o(n^2) 超出时间限制，再思考
         *
         * @param a
         * @return
         */
        public int[] constructArr(int[] a) {
            int length = a.length;
            int[] retInts = new int[length];
            for (int i = 0; i < length; i++) {
                retInts[i] = 1;
            }

            for (int i = 0; i < length; i++) {
                int iVal = a[i];
                for (int j = 0; j < length; j++) {
                    if (j == i) {
                        continue;
                    }
                    retInts[j] *= iVal;
                }
            }
            return retInts;
        }

        /**
         *
         * 优化的结果，想出来以对角线隔开算两次
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 51.3 MB, 在所有 Java 提交中击败了13.73%的用户
         *
         * @param a
         * @return
         */
        public int[] constructArr1(int[] a) {
            int length = a.length;
            if (length == 0) {
                return a;
            }

            int[] intsDownHalf = new int[length];
            int[] intsUpHalf = new int[length];

            intsDownHalf[0] =1;
            intsUpHalf[length-1] =1;

            //下半部
            for (int i = 1; i < length; i++) {
                intsDownHalf[i] = intsDownHalf[i-1] * a[i-1];
            }

            //上半部
            int k =1;
            intsUpHalf[length - 1] = intsDownHalf[length-1];
            for (int i = length -2; i >= 0 ; i--) {
                k *= a[i+1];
                intsUpHalf[i] = k;
                intsUpHalf[i] *= intsDownHalf[i];

            }
            return intsUpHalf;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().constructArr1(new int[]{}));//120,60,40,30,24
        logger.info("{}", new Solution().constructArr1(new int[]{1,2,3,4,5}));//120,60,40,30,24
    }
}
