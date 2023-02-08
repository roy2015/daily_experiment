package com.roy.leetcode.stage1.stage12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/24
 *
 * 506. 相对名次
给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。

(注：分数越高的选手，排名越靠前。)

示例 1:

输入: [5, 4, 3, 2, 1]
输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
提示:

N 是一个正整数并且不会超过 10000。
所有运动员的成绩都不相同。
 *
 */
public class TestSolution506 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution506.class);


    static class Solution {

        /**
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :8 ms, 在所有 Java 提交中击败了80.82%的用户
         内存消耗 :40.7 MB, 在所有 Java 提交中击败了33.33%的用户
         *
         * @param nums
         * @return
         */
        public String[] findRelativeRanks(int[] nums) {
            int len = nums.length;
            int[] newNums = new int[len];
            int k =0;
            for (int num : nums) {
                newNums[k ++] = num;
            }

            Arrays.sort(newNums);
            int rank =1;
            Map<Integer, String> rankMap = new HashMap<>();
            for (int i = len -1; i >= 0 ; i--) {
                int val = newNums[i];
                if (i == len -1) {
                    rankMap.put(val, "Gold Medal");
                } else if (i == len -2 ) {
                    rankMap.put(val, "Silver Medal");
                } else if (i == len -3) {
                    rankMap.put(val, "Bronze Medal");
                } else {
                    rankMap.put(val, String.valueOf(rank));
                }
                rank ++;
            }

            String[] retRanks = new String[len];
            for (int i = 0; i < len; i++) {
                retRanks[i] = rankMap.get(nums[i]);
            }
            return retRanks;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findRelativeRanks(new int[]{1,4,3,5,2}));
    }
}
