package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/22
 *
 * 面试题 08.03. 魔术索引
魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。

示例1:

输入：nums = [0, 2, 3, 4, 5]
输出：0
说明: 0下标的元素为0
示例2:

输入：nums = [1, 1, 1]
输出：1
提示:

nums长度在[1, 1000000]之间
 *
 */
public class TestSolutionInterview0803 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0803.class);

    static class Solution {
        /**
         *
         * 执行结果：通过显示详情
         执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :40.7 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param nums
         * @return
         */
        public int findMagicIndex(int[] nums) {
            int len = nums.length;
            int i;
            for(i = 0 ; i < len ; i++) {
                if(nums[i]==i) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findMagicIndex(new int[]{0, 2, 3, 4, 5}));
    }
}
