package com.guo.roy.research.leetcode.stage1.stage13;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/14
 *
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */
public class TestSolution448 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution448.class);


    static class Solution {

        /**
         *
         * 参考官方题解看，比较巧妙, 乘-1打标还不丢失数据，也弄清楚了另一个概念 O(n) + O(n) + ...+O(n) 还是能算O(n)
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 6 ms, 在所有 Java 提交中击败了88.94%的用户
         * 内存消耗：
         * 48.8 MB, 在所有 Java 提交中击败了45.83%的用户
         *
         * @param nums
         * @return
         */
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int newIdx;
                newIdx = nums[i];
                if (nums[i] < 0) {
                    newIdx = - newIdx;
                }
                newIdx = newIdx - 1;
                int val = nums[newIdx ];
                if (val > 0) {
                    nums[newIdx ] = - val;
                }
            }

            List<Integer> retList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    retList.add(i + 1);
                }
            }
            return retList;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
