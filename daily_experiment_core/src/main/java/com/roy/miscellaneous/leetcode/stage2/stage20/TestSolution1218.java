package com.roy.miscellaneous.leetcode.stage2.stage20;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.LoggerFactory;

/**
 * 1218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 *
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10w
 * -10000 <= arr[i], difference <= 10000
 *
 * @author guojun
 * @date 2021/1/21 10:40
 */
public class TestSolution1218 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1218.class);


    static class Solution {
        /**
         *
         * 大胆猜想，小心验证，第一次提交超时了，换了种猜想发现是对的
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：39 ms, 在所有 Java 提交中击败了74.92%的用户
         * 内存消耗：55.3 MB, 在所有 Java 提交中击败了54.66%的用户
         * 通过测试用例：39 / 39
         *
         * @param arr
         * @param difference
         * @return
         */
        public int longestSubsequence(int[] arr, int difference) {
            int length = arr.length;
            if (length == 1) {
                return 1;
            }
            Map<Integer, Integer> dic = new HashMap<>();
            dic.put(arr[0], 1);
            for (int i = 1; i < length; i++) {
                int iVal = arr[i];
                if (dic.containsKey(iVal - difference)) {
                    dic.put(iVal , dic.get(iVal - difference) + 1);
                } else {
                    dic.put(iVal , 1);
                }
            }
            int max = 0;
            for (Integer key : dic.keySet()) {
                Integer val = dic.get(key);
                if (val > max) {
                    max = val;
                }
            }
            return max ;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().longestSubsequence(new int[]{3,4,-3,-2,-4}, -5));//2
        logger.info("{}", new Solution().longestSubsequence(new int[]{1,2,3,4}, 1));//4
        logger.info("{}", new Solution().longestSubsequence(new int[]{1,3,5,7}, 1));//1
        logger.info("{}", new Solution().longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));//4


    }
}
