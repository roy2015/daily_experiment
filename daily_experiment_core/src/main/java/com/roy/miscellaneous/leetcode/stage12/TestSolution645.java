package com.roy.miscellaneous.leetcode.stage12;

import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.BitSet;

/**
 * @author guojun
 * @date 2020/5/21
 *
 * 645. 错误的集合
集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。

给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

示例 1:

输入: nums = [1,2,2,4]
输出: [2,3]
注意:

给定数组的长度范围是 [2, 10000]。
给定的数组是无序的。


 */
public class TestSolution645 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution645.class);


    //注意看题， 给定的数组是无序的！
    static class Solution {

        /**
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :5 ms
         , 在所有 Java 提交中击败了46.11%
         的用户
         内存消耗 :41.2 MB
         , 在所有 Java 提交中击败了14.29%
         的用户
         *
         * @param nums
         * @return
         */
        public int[] findErrorNums(int[] nums) {
            int length = nums.length;
            int[] retInts = new int[2];
            BitSet bitSet = new BitSet(length);
            for (int num : nums) {
                if (bitSet.get(num)) {
                    retInts[0] = num;
                } else {
                    bitSet.set(num);
                }
            }

            for (int i = 1; i <= length; i++) {
                if (!bitSet.get(i)) {
                    retInts[1] = i;
                    break;
                }
            }
            return retInts;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findErrorNums(new int[]{1,2,2,3,4}));//2,5
        logger.info("{}", new Solution().findErrorNums(new int[]{2,2,3}));//2,1
        logger.info("{}", new Solution().findErrorNums(new int[]{1,3,4,4}));//4,2
        logger.info("{}", new Solution().findErrorNums(new int[]{1,2,2,4}));//2,3
        logger.info("{}", new Solution().findErrorNums(new int[]{1,2,3,3}));//3,4

    }
}
