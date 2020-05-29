package com.roy.miscellaneous.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author guojun
 * @date 2020/5/13 10:56
 *
 * 349. 两个数组的交集
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]
说明:

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
 */
public class TestSolution349 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution349.class);


    static class Solution {

        /**
         *
         * 执行结果：通过显示详情
         * 执行用时 :2 ms, 在所有 Java 提交中击败了99.36%的用户
         * 内存消耗 :40 MB, 在所有 Java 提交中击败了5.72%的用户
         *
         * 两个bitSet负责打标
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;

            BitSet bitSet = new BitSet();
            BitSet retBitSet = new BitSet();
            for(int i =0 ; i< len1; i++) {
                bitSet.set(nums1[i]);
            }

            int[] ret =  new int[len2];
            int k =0;
            for(int i =0 ; i< len2; i++) {
                if (bitSet.get(nums2[i])) {
                    if (!retBitSet.get(nums2[i])) {
                        ret[k++] = nums2[i] ;
                        retBitSet.set(nums2[i]);
                    }

                }
            }

            return Arrays.copyOfRange(ret, 0, k);
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().intersection(
                new int[]{1,2,2,3},
                new int[]{2,2}));
    }
}
