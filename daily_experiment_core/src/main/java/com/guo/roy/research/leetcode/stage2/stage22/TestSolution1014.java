package com.guo.roy.research.leetcode.stage2.stage22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * 1014. 最佳观光组合
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * 示例 2：
 *
 * 输入：values = [1,2]
 * 输出：2
 *
 *
 * 提示：
 *
 * 2 <= values.length <= 5 * 104
 * 1 <= values[i] <= 1000
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution1014 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1014.class);



    static class Solution {
        class Tuple {
            private int maxDpVal;
            private List<Integer> idxLIst;

            public Tuple(int maxDpVal, List<Integer> idxLIst) {
                this.maxDpVal = maxDpVal;
                this.idxLIst = idxLIst;
            }
        }

      /**
       * 执行结果：通过
       * 显示详情
       * 添加备注
       *
       * 执行用时：12 ms, 在所有 Java 提交中击败了8.10%的用户
       * 内存消耗：49.9 MB, 在所有 Java 提交中击败了39.84%的用户
       * 通过测试用例：53 / 53
       * @param values
       * @return
       */
        public int maxScoreSightseeingPair(int[] values) {
            int len = values.length;
            int[] dp = new int[len];
            for(int i= 1;i< len; i++) {
                dp[i] = values[i] - values[0] -(i-0);
            }
            //记录数据 从后往前     Tuple ( maxGap, 相同gap的idx[] )
            int max = 0;
          Tuple preMaxTuple = new Tuple(dp[len -1],  Collections.singletonList(len - 1));

            for (int i = len -2; i >= 0 ; i--) {
                //求max
                int iVal = values[i];
                int preMaxDpVal = preMaxTuple.maxDpVal;

                for (Integer idx : preMaxTuple.idxLIst) {
                    int candidate = values[idx] + iVal;
                    candidate -= idx - i;
                    if (candidate > max) {
                        max = candidate;
                    }
                }
                int iDpVal = dp[i];
                if (iDpVal > preMaxDpVal) {
                    preMaxTuple = new Tuple(iDpVal, Collections.singletonList(i));
                } else if (iDpVal == preMaxDpVal) {
                  preMaxTuple.idxLIst = new ArrayList(preMaxTuple.idxLIst);
                }
            }
            return max;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxScoreSightseeingPair(new int[]{4,8,3,8,3,10,7,8,8}));//16
        logger.info("{}", new Solution().maxScoreSightseeingPair(new int[]{2,7,7,2,1,7,10,4,3,3}));//16
        logger.info("{}", new Solution().maxScoreSightseeingPair(new int[]{1,2}));//2
        logger.info("{}", new Solution().maxScoreSightseeingPair(new int[]{8,1,5,2,6}));//11
        logger.info("{}", new Solution().maxScoreSightseeingPair(new int[]{1,2,2}));//3
    }
}
