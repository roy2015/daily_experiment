package com.roy.miscellaneous.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guojun
 * @date 2020/11/5
 *
 *
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class TestSolution560 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution560.class);


    static class Solution {
        /**
         * 我去，想出来写了个DP,居然是5.05%， 看官方题解，可以考虑用前缀和 todo
         *  dp[i] = dp[i-1] + times，i个数和i-1个数的dp值有关系，利用这点就可以用dp动态规划
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1162 ms, 在所有 Java 提交中击败了5.05%的用户
         * 内存消耗：40.9 MB, 在所有 Java 提交中击败了15.12%的用户
         *
         * @param nums
         * @param k
         * @return
         */
        public int subarraySum(int[] nums, int k) {
            int length = nums.length;
            int[] dp = new int[length +1];
            dp[0] = 0;
            for (int i = 1; i <= length; i++) {
                int sumI =0;
                int times = 0;
                for (int j = i -1; j >= 0 ; j--) {
                    sumI += nums[j];
                    if (sumI == k) {
                        times++;
                    }
                }
                dp[i] = dp[i-1] + times;
            }
            return dp[length];
        }

        /**
         *
         * 参考官方的前缀和算法
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1609 ms
         * , 在所有 Java 提交中击败了
         * 5.02%
         * 的用户
         * 内存消耗：
         * 40.9 MB
         * , 在所有 Java 提交中击败了
         * 18.33%
         * 的用户
         * @param nums
         * @param k
         * @return
         */
        public int subarraySum1(int[] nums, int k) {
            int length = nums.length;
            int[] prefixSum = new int[length +1];
            prefixSum[0] =0;//虚拟一个0，把原数组看做从1开始，N结束
            for (int i = 1; i <= length; i++) {
                prefixSum[i] = prefixSum[i -1] + nums[i-1];
            }

            int times = 0;
            for (int i = 0; i < length; i++) {
                for (int j = i +1; j <= length ; j++) {
                    if (prefixSum[j] - prefixSum[i] == k) {
                        times ++;
                    }
                }
            }
            return times;
        }


        /**
         * 参考 @link{https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/}
         * 前缀和+hash优化
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 28 ms
         * , 在所有 Java 提交中击败了
         * 46.03%
         * 的用户
         * 内存消耗：
         * 41.2 MB
         * , 在所有 Java 提交中击败了
         * 7.24%
         * 的用户
         *
         * @param nums
         * @param k
         * @return
         */
        public int subarraySum2(int[] nums, int k) {
            int length = nums.length;
            int[] prefixSum = new int[length +1];
            prefixSum[0] =0;//虚拟一个0，把原数组看做从1开始，N结束

            int ret =0;
            Map<Integer, Integer> dic = new HashMap<>();

            for (int i = 1; i <= length; i++) {
                prefixSum[i] = prefixSum[i -1] + nums[i-1];
                int prefixSumIval = prefixSum[i];
                if (prefixSumIval == k) {
                    ret ++;
                }
                if (dic.containsKey(prefixSumIval - k )){
                    ret += dic.get(prefixSumIval - k );
                }
                dic.put(prefixSumIval, dic.getOrDefault(prefixSumIval, 0) +1);
            }
            return ret;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().subarraySum2(new int[]{1,1,1}, 2));//2
        logger.info("{}", new Solution().subarraySum2(new int[]{1,2,1,-1,3,-2,5}, 3));//7
    }
}
