package com.roy.leetcode.stage2.stage21;

import java.util.ArrayDeque;
import java.util.Deque;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/11
 *
 *
 * 456. 132模式
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000。
 *
 * 示例1:
 *
 * 输入: [1, 2, 3, 4]
 *
 * 输出: False
 *
 * 解释: 序列中不存在132模式的子序列。
 * 示例 2:
 *
 * 输入: [3, 1, 4, 2]
 *
 * 输出: True
 *
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * 示例 3:
 *
 * 输入: [-1, 3, 2, 0]
 *
 * 输出: True
 *
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 *
 *
 */
public class TestSolution456 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution456.class);


    static class Solution {
        /**
         *
         * 借鉴的思路：
         * @See @link https://leetcode-cn.com/problems/132-pattern/solution/132mo-shi-by-leetcode-2/
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 9 ms
         * , 在所有 Java 提交中击败了
         * 64.79%
         * 的用户
         * 内存消耗：
         * 40.4 MB
         * , 在所有 Java 提交中击败了
         * 42.24%
         * 的用户
         *
         * @param nums
         * @return
         */
        public boolean find132pattern(int[] nums) {
            int len = nums.length;
            if (len < 3) {
                return false;
            }

            int[] min = new int[len];//0 - i最小的元素
            min[0] = nums[0];
            for (int i = 1; i < len; i ++) {
                min[i] = nums[i] < min[i - 1] ? nums[i]  : min[i - 1] ;
            }

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = len -1 ; i >= 0; i--) {
                int iVal = nums[i];
                int minVal = min[i];
                if (iVal > minVal) {
                    while (!deque.isEmpty() && deque.peek() <= minVal) {
                        deque.pop();
                    }
                    if (!deque.isEmpty() && deque.peek() < iVal) {
                        return true;
                    }
                    deque.push(iVal);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().find132pattern(new int[]{1,2,3,4})); //false
        logger.info("{}", new Solution().find132pattern(new int[]{6,12,3,4,6,11,20})); //true
    }
}
