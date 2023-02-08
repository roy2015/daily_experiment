package com.roy.leetcode.stage1.stage13;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/21
 *
 *
 * 594. 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 *
 *
 */
public class TestSolution594 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution594.class);


    static class Solution {
        /**
         *
         * 里面有套路， 全部相同返回0
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 23 ms, 在所有 Java 提交中击败了56.69%的用户
         * 内存消耗：
         * 41.9 MB, 在所有 Java 提交中击败了33.33%的用户
         *
         * @param nums
         * @return
         */
        public int findLHS(int[] nums) {
            //排除异常数据
            if (nums == null || nums.length == 0 || nums.length == 1) {
                return 0;
            }

            //收集数据，每个key出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int val : nums) {
                map.compute(val, (key, oldVal) -> {
                    if (oldVal == null) {
                        return Integer.valueOf(1);
                    } else {
                        return Integer.valueOf(oldVal.intValue() + 1);
                    }
                });
            }

            //取相邻最大的key
            int maxHs = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key = entry.getKey();
                int val = entry.getValue();
                Integer keyP1 = key.intValue() + 1;
                Integer keyM1 = key.intValue() - 1;
                int valP1 = map.getOrDefault(keyP1, -1);
                int valM1 = map.getOrDefault(keyM1, -1);
                if (valP1 == -1 && valM1 == -1) {
                    continue;
                }
                int sumP1 = val + valP1;
                int sumM1 = val + valM1;

                int sum = Math.max(sumP1, sumM1);
                if (sum > maxHs) {
                    maxHs = sum;
                }
            }
            return maxHs;
        }
    }

    public static void main(String[] args) {
        logger.info("=================分隔符===============================");

        logger.info("{}", new Solution().findLHS(new int[]{2,2,2,2,2,2,2,3,1,0,0,0,3,1,-1,0,1,1,0,0,1,1,2,2,2,0,1,2,2,3,2}));//20
        logger.info("{}", new Solution().findLHS(new int[]{1,3,5,7,9,11,13,15,17}));//0
        logger.info("{}", new Solution().findLHS(new int[]{1,2,2,3,4,5,1,1,1,1}));//7
        logger.info("{}", new Solution().findLHS(new int[]{1,3,2,2,5,2,3,7}));//5
        logger.info("{}", new Solution().findLHS(new int[]{3}));//0
        logger.info("{}", new Solution().findLHS(new int[]{1,1,1,1}));//0
    }
}
