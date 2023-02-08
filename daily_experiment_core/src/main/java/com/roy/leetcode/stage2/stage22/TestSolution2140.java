package com.roy.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * 2140. 解决智力问题
 * 给你一个下标从 0 开始的二维整数数组 questions ，其中 questions[i] = [pointsi, brainpoweri] 。
 *
 * 这个数组表示一场考试里的一系列题目，你需要 按顺序 （也就是从问题 0 开始依次解决），针对每个问题选择 解决 或者 跳过 操作。解决问题 i 将让你 获得  pointsi 的分数，但是你将 无法 解决接下来的 brainpoweri 个问题（即只能跳过接下来的 brainpoweri 个问题）。如果你跳过问题 i ，你可以对下一个问题决定使用哪种操作。
 *
 * 比方说，给你 questions = [[3, 2], [4, 3], [4, 4], [2, 5]] ：
 * 如果问题 0 被解决了， 那么你可以获得 3 分，但你不能解决问题 1 和 2 。
 * 如果你跳过问题 0 ，且解决问题 1 ，你将获得 4 分但是不能解决问题 2 和 3 。
 * 请你返回这场考试里你能获得的 最高 分数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：questions = [[3,2],[4,3],[4,4],[2,5]]
 * 输出：5
 * 解释：解决问题 0 和 3 得到最高分。
 * - 解决问题 0 ：获得 3 分，但接下来 2 个问题都不能解决。
 * - 不能解决问题 1 和 2
 * - 解决问题 3 ：获得 2 分
 * 总得分为：3 + 2 = 5 。没有别的办法获得 5 分或者多于 5 分。
 * 示例 2：
 *
 * 输入：questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
 * 输出：7
 * 解释：解决问题 1 和 4 得到最高分。
 * - 跳过问题 0
 * - 解决问题 1 ：获得 2 分，但接下来 2 个问题都不能解决。
 * - 不能解决问题 2 和 3
 * - 解决问题 4 ：获得 5 分
 * 总得分为：2 + 5 = 7 。没有别的办法获得 7 分或者多于 7 分。
 *
 *
 * 提示：
 *
 * 1 <= questions.length <= 10^5
 * questions[i].length == 2
 * 1 <= pointsi, brainpoweri <= 10^5
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution2140 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution2140.class);


    static class Solution {
        /**
         *
         * 早上想了没想出来，下午看了下提示(主要第三条，第四条)受到启发，立马写出，以下五条英文的，考验英文了哈，也算90%达成吧
         * 1.For each question, we can either solve it or skip it. How can we use Dynamic Programming to decide the most optimal option for each problem?
         * 2.We store for each question the maximum points we can earn if we started the exam on that question.
         * 3.If we skip a question, then the answer for it will be the same as the answer for the next question.
         * 4.If we solve a question, then the answer for it will be the points of the current question 加上 the answer for the next solvable question.
         * 5.The maximum of these two values will be the answer to the current question.
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：5 ms, 在所有 Java 提交中击败了96.30%的用户
         * 内存消耗：90.1 MB, 在所有 Java 提交中击败了75.43%的用户
         * 通过测试用例：54 / 54
         *
         * @param questions
         * @return
         */
        public long mostPoints(int[][] questions) {
            int length = questions.length;
            long[] dp = new long[length];
            dp[length -1] = questions[length-1][0];

            for (int i = length -2; i >= 0; i--) {
                int point = questions[i][0];
                int skipIdx = questions[i][1];
                //不选
                long notSkipVal = dp[i + 1];
                long skipVal = 0;
                int targetIdx = i + skipIdx + 1;
                //选
                if (targetIdx < length) {//超界
                    skipVal = dp[targetIdx] + point;
                } else {//未超界
                    skipVal = point;
                }
                dp[i] = Math.max(skipVal, notSkipVal);
            }
            return dp[0];
        }

    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().mostPoints(new int[][]{
            {12,46},{78,19},{63,15},{79,62},{13,10}
        }));//5

        logger.info("{}", new Solution().mostPoints(new int[][]{
            {3,2},{4,3},{4,4},{2,5}}));//5

        logger.info("{}", new Solution().mostPoints(new int[][]{
            {1,1},{2,2},{3,3},{4,4},{5,5}
        }));//7


    }
}
