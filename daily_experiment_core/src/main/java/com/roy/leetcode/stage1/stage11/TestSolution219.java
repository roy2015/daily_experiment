package com.roy.leetcode.stage1.stage11;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/13 15:25
 *
 * 219. 存在重复元素 II
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。



示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false
 */
public class TestSolution219 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution219.class);


    static class Solution {

        /**
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :9 ms, 在所有 Java 提交中击败了94.43%的用户
         内存消耗 :45.3 MB, 在所有 Java 提交中击败了5.72%的用户
         *
         * @param nums
         * @param k
         * @return
         */
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            boolean ret = false;

            for (int i = 0; i < nums.length; i++) {
                int val = nums[i];
                int oldIdx ;
                if (map.containsKey(val)) {
                    oldIdx = map.get(val);
                    if (Math.abs(oldIdx - i) <= k ) {
                        return true;
                    } else {
                        map.put(val, i);
                    }
                } else {
                    map.put(val, i);
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int max = (int) Math.floor(Math.sqrt(123));

        logger.info("{}", new Solution().containsNearbyDuplicate(new int[]{1,2,3,1,0,1}, 1));//false
        logger.info("{}", new Solution().containsNearbyDuplicate(new int[]{1,2,3,1,0,1}, 2));//false
    }
}
