package com.roy.miscellaneous.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/22
 *
 * 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 *
 */
public class TestSolution260 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution260.class);


    static class Solution {

        /**
         *
         * 借鉴了扣友的思路确实非常巧妙， 抑或运算具有交换律
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 40.2 MB, 在所有 Java 提交中击败了16.67%的用户
         *
         * @param nums
         * @return
         */
        public int[] singleNumber(int[] nums) {
            if (nums == null || nums.length <= 2) {
                return nums;
            }

            //先求总异或，也就是A，B的异或（那两个不同的元素记为A，B）
            int xorNums = 0;
            for (int num : nums) {
                xorNums ^= num;
            }

            //计算xorNums， 看是从哪一位开始不同的，从低位开始计算，计算出形如 1..0 ,因为AB不同，肯定有一位是不同的，不可能0
            int bitNum = 1;
            while ((bitNum & xorNums) ==0) {
                bitNum = bitNum << 1;
            }

            //分别根据这一位的不同，对传入数组做抑或计算，每种里面除开A或者B，其他都是成对出现，做抑或刚好转化为了 "求只出现一次的数字"
            int[] retInts = new int[2];
            retInts[0] = xorNums;
            retInts[1] = xorNums;

            for (int num : nums) {
                if ((num & bitNum) == 0) {
                    retInts[0] ^= num;
                } else {
                    retInts[1] ^= num;
                }
            }
            return retInts;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int[] ints = new Solution().singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        logger.info("{}", ints);
        int k =2;
    }
}
