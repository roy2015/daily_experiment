package com.roy.miscellaneous.leetcode.stage2.stage21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 *
 * 面试题 17.08. 马戏团人塔
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 *
 * 示例：
 *
 * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * 输出：6
 * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 * 提示：
 *
 * height.length == weight.length <= 10000
 *
 * @author guojun
 * @date 2020/10/21
 *
 */
public class TestSolutionInterview17_08 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview17_08.class);

    static class Solution {
        /**
         *
         * 其实问题实质是求最长递增子序列
         *
         * dp超出时间限制？？？
         *
         * @param height
         * @param weight
         * @return
         */
        public int bestSeqAtIndex(int[] height, int[] weight) {
            int heightLen = height.length;
            int[][] array = new int[heightLen][2];
            for (int i = 0; i < heightLen; i++) {
                array[i] = new int[2];
                array[i][0] = height[i];
                array[i][1] = weight[i];
            }
            Arrays.sort(array, (o1, o2) -> o1[0] - o2[0]);
            int max = 0;
            int[] dp = new int[heightLen];
            for (int i = heightLen -1; i >= 0; i--) {
                int maxTemp =0;
                int iWeight = array[i][1];
                int iHight = array[i][0];
                for (int j = i +1; j < heightLen; j++) {
                    //为什么需要两个条件，防止出现相同值的情况
                    if (array[j][1] > iWeight && array[j][0] > iHight) {
                        if (dp[j] > maxTemp) maxTemp = dp[j];
                    }
                }
                dp[i] = maxTemp + 1;
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            return max;
        }

        /**
         *
         * 求最长递增子序列算法
         * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/dong-tai-gui-hua-dong-tu-fu-zhu-li-jie-ru-you-bang/
         * dp超出时间限制*2 ？？？
         * @param height
         * @param weight
         * @return
         */
        public int bestSeqAtIndex1(int[] height, int[] weight) {
            int heightLen = height.length;
            int[][] array = new int[heightLen][2];
            for (int i = 0; i < heightLen; i++) {
                array[i] = new int[2];
                array[i][0] = height[i];
                array[i][1] = weight[i];
            }
            Arrays.sort(array, (o1, o2) -> {
                int gap = o1[0]- o2[0];
                if (gap == 0) {
                    return o2[1]- o1[1];
                } else
                    return gap;
            });
            int[] sortWeights = new int[heightLen];
            for (int i = 0; i < array.length; i++) {
                int[] k = array[i];
                sortWeights[i] = k[1];
            }
            int[] dp = new int[heightLen];
            Arrays.fill(dp, 1);
            int max = 0;
            //5000万次循环
            for (int i = 1; i < sortWeights.length; i++) {
                for (int j = 0; j < i ; j++) {
                    int jVal = dp[j] +1;
                    if ((sortWeights[j] < sortWeights[i]) && (jVal  > dp[i]) ) {
                        dp[i] = jVal;
                    }
                }
                if (dp[i] > max) max = dp[i];
            }
            return max;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().bestSeqAtIndex1(new int[]{65,70,70,75,60,68},
                new int[]{100,150,90,190,95,110}));//5

        logger.info("{}", new Solution().bestSeqAtIndex1(new int[]{65,70,56,75,60,68},
                new int[]{100,150,90,190,95,110}));//6

        logger.info("{}", new Solution().bestSeqAtIndex1(new int[]{65,70,56,75,60,68},
                new int[]{100,100,100,100,100,100}));//1

        logger.info("{}", new Solution().bestSeqAtIndex1(new int[]{65,65,65,65,65,65},
                new int[]{100,150,90,190,95,110}));//1

        logger.info("{}", new Solution().bestSeqAtIndex1(new int[]{65,65,65,65,65,65},
                new int[]{100,100,100,100,100,100}));//1


    }
}
