package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/22
 *
 *面试题03. 数组中重复的数字
找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3


限制：

2 <= n <= 100000
 *
 */
public class TestSolutionInterview03 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview03.class);

    static class Solution {
        /**
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :1 ms, 在所有 Java 提交中击败了92.16%的用户
         内存消耗 :47.3 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param nums
         * @return
         */
        public int findRepeatNumber(int[] nums) {
            int len = nums.length;
            int[] bitSet = new int[len];
            for(int i = 0; i< len; i++) {
                int val = nums[i];
                int existVal = bitSet[val];
                if (existVal == 1) {
                    return val;
                } else{
                    bitSet[val] =1;
                }

            }
            return 0;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution());
    }
}
