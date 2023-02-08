package com.roy.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/14
 *
 *
 * 1344. 时钟指针的夹角
 * 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：hour = 12, minutes = 30
 * 输出：165
 * 示例 2：
 *
 *
 *
 * 输入：hour = 3, minutes = 30
 * 输出；75
 * 示例 3：
 *
 *
 *
 * 输入：hour = 3, minutes = 15
 * 输出：7.5
 * 示例 4：
 *
 * 输入：hour = 4, minutes = 50
 * 输出：155
 * 示例 5：
 *
 * 输入：hour = 12, minutes = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * 与标准答案误差在 10^-5 以内的结果都被视为正确结果。
 *
 */
public class TestSolution1344 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1344.class);


    static class Solution {
        /**
         *
         *
         * easy的为啥是 medium difficulty
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 36.4 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param hour
         * @param minutes
         * @return
         */
        public double angleClock(int hour, int minutes) {
            if (hour == 12) {
                hour = 0;
            }
            double hourDegree = 30* hour;
            double minDegree = 6 * minutes;
            hourDegree += minutes /60.0 *30  ;

            double kk = Math.abs(minDegree - hourDegree);
            if (kk > 180) {
                return 360- kk;
            } else {
                return kk;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().angleClock(12, 30));//165
        logger.info("{}", new Solution().angleClock(3, 30));//75
        logger.info("{}", new Solution().angleClock(3, 15));//7.5
        logger.info("{}", new Solution().angleClock(4, 50));//155
        logger.info("{}", new Solution().angleClock(12, 0));//0
    }
}
