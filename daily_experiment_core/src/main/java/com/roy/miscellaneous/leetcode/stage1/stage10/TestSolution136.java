package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/2.
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 1. 交换律：a ^ b ^ c <=> a ^ c ^ b
 * 2. 任何数于0异或为任何数 0 ^ n => n
 * 3. 相同的数异或为0: n ^ n => 0
 */
public class TestSolution136 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution136.class);

    static class Solution {
        public int singleNumber(int[] nums) {
            int singleNumer = 0;
            for (int num : nums) {
                singleNumer ^= num;
            }
            return singleNumer;
        }
    }

    public static void main(String[] args) {
        int singleNumber = new Solution().singleNumber(new int[]{-4, 1, 2, 1, 2});
        logger.info("{}", singleNumber);
    }


}
