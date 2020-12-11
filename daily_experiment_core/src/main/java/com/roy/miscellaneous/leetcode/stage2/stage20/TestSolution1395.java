package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/12/11
 *
 * 1395. 统计作战单位数
 *  n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 *
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 *
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：rating = [2,5,3,4,1]
 * 输出：3
 * 解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
 * 示例 2：
 *
 * 输入：rating = [2,1,3]
 * 输出：0
 * 解释：根据题目条件，我们无法组建作战单位。
 * 示例 3：
 *
 * 输入：rating = [1,2,3,4]
 * 输出：4
 *
 *
 * 提示：
 *
 * n == rating.length
 * 1 <= n <= 200
 * 1 <= rating[i] <= 10^5
 *
 */
public class TestSolution1395 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1395.class);


    static class Solution {
        /**
         * 思路整理：
         * 1. 题意 三个点， index递增， value单调递增或递减
         * 2. 暴力破解  O(n^3)
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：25 ms, 在所有 Java 提交中击败了17.35%的用户
         * 内存消耗：36 MB, 在所有 Java 提交中击败了74.04%的用户
         *
         *
         * @param rating
         * @return
         */
        public int numTeams(int[] rating) {
            int ret = 0;
            boolean asc = true;
            int length = rating.length;
            if (length < 3) {
                return 0;
            }
            for (int i = 0; i < length - 2; i++) {
                int first = rating[i];
                for (int j = i +1 ; j < length - 1; j++) {
                    int second = rating[j];
                    if (second < first) {
                        asc = false;
                    } else asc = true;
                    for (int k = j + 1; k <length ; k++) {
                        if (asc && rating[k] > second) {
                            ret ++;
                        } else if (!asc && rating[k] < second) {
                            ret ++;
                        }
                    }
                }
            }
            return ret;
        }

        /**
         *
         * 借鉴了一句，说可以从三个数 中间那个数着手就马上想到了，算法是自己想的
         * 官网的启发，可以O(n^2)复杂度，先确定中间节点N，
         * 1.求左边小于N的个数i,右边大于N的个数j
         * 2.求左边大于N的个数m,右边小于N的个数n
         * 
         * 求和 i*j + m*n
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 2 ms
         * , 在所有 Java 提交中击败了
         * 95.63%
         * 的用户
         * 内存消耗：
         * 36.2 MB
         * , 在所有 Java 提交中击败了
         * 44.81%
         * 的用户
         * 
         * @param rating
         * @return
         */
        public int numTeams1(int[] rating) {
            int ret = 0;
            int length = rating.length;
            if (length < 3) {
                return 0;
            }
            for (int i = 1; i < length -1; i++) {
                int leftLeCnt = 0;//左边小的个数
                int leftGtCnt = 0;//左边大的个数

                int rightLeCnt = 0;//右边小的个数
                int rightGtCnt = 0;//右边大的个数

                int ival = rating[i];
                for (int j = i -1; j >= 0; j--) {
                    if (rating[j] < ival) {
                        leftLeCnt ++;
                    } else {
                        leftGtCnt ++;
                    }
                }

                for (int j = i +1; j < length; j++) {
                    if (rating[j] < ival) {
                        rightLeCnt ++;
                    } else {
                        rightGtCnt ++;
                    }
                }

                ret += leftGtCnt * rightLeCnt;
                ret += leftLeCnt * rightGtCnt;

            }
            return ret;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().numTeams1(new int[]{5,2,7,1}));//1
        logger.info("{}", new Solution().numTeams1(new int[]{2,5,3,4,1}));//3
        logger.info("{}", new Solution().numTeams1(new int[]{1,2,3,4}));//4
        logger.info("{}", new Solution().numTeams1(new int[]{2,1,3}));//0
    }
}
