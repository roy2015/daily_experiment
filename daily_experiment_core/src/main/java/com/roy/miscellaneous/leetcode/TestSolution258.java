package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 2019/10/30.
 *给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

 示例:

 输入: 38
 输出: 2
 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 进阶:
 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-digits
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution258 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution258.class);

    /**
     *
     * 最简单， 对9求余数， 考虑一位数字和0即可
     *
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     内存消耗 :33.8 MB, 在所有 java 提交中击败了12.48%的用户
     */
    static class Solution {
        public int addDigits(int num) {
            if (num ==0) {
                return 0;
            }
            int k = num % 9 ;
            return k ==0 ? 9: k ;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().addDigits(18));
    }

}
