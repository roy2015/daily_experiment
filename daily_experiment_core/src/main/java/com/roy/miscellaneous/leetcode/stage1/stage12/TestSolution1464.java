package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/26
 *
 *
 * 1464. 数组中两元素的最大乘积
给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。

请你计算并返回该式的最大值。



示例 1：

输入：nums = [3,4,5,2]
输出：12
解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
示例 2：

输入：nums = [1,5,4,5]
输出：16
解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
示例 3：

输入：nums = [3,7]
输出：12


提示：

2 <= nums.length <= 500
1 <= nums[i] <= 10^3
 *
 */
public class TestSolution1464 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1464.class);


    static class Solution {

        /**
         *
         *朴素的思路是这个，不过 O(nlog(n)) 2 ms, 在所有 Java 提交中击败了66.30%
         * Arrays.sort(nums);
         int len = nums.length;
         return (nums[len-1]-1) * (nums[len-2]-1);
         *
         * 问题实质是找最大的两个数（不存在两个负数相乘，1 <= nums[i] <= 10^3），所以只要
         * 两个变量， first, second, 遍历数组，不断更新first, second， O(log(n))
         * 细节：f被更新时需要赋值给s
         *
         *
         *执行结果：
         通过
         显示详情
         执行用时：
         0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗：
         39.3 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         *
         * @param nums
         * @return
         */
        public int maxProduct(int[] nums) {
            //first second
            int f = nums[0],s = nums[1];
            if (nums[0]< nums[1]) {
                f = nums[1];
                s = nums[0];
            }
            int len = nums.length;
            for (int i = 2; i < len; i++) {
                int iVal = nums[i];
                if (iVal > f) {
                    s = f;
                    f = iVal;
                } else if (iVal > s) {
                    s = iVal;
                } else {}
            }
            return (f-1) * (s-1);
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxProduct(new int[]{
                1,5,4,5
        }));//16

        logger.info("{}", new Solution().maxProduct(new int[]{
                3,4,5,2
        }));//12
    }
}
