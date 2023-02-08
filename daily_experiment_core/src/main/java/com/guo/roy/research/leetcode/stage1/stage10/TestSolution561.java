package com.guo.roy.research.leetcode.stage1.stage10;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/14.
 *给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。

 示例 1:

 输入: [1,4,3,2]

 输出: 4
 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 提示:

 n 是正整数,范围在 [1, 10000].
 数组中的元素范围在 [-10000, 10000].

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/array-partition-i
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution561 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution561.class);

    /**
     */
    static class Solution {
        /**
         *
         *
         * 执行用时 :18 ms, 在所有 java 提交中击败了93.47%的用户
         内存消耗 :39.8 MB, 在所有 java 提交中击败了96.91%的用户
         *
         */
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum =0;
            for(int i=0; i<= nums.length-2; i+=2) {
                sum += nums[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().arrayPairSum(new int[]{
                1,4,2,3
        }));
    }

}
