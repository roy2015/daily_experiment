package com.roy.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/9
 *
 *
 *
 * 319. 灯泡开关
 * 初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 1
 * 解释:
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 *
 * 你应该返回 1，因为只有一个灯泡还亮着。
 *
 *
 */
public class TestSolution319 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution319.class);


    static class Solution {
        /**
         *
         * 99999999时 超出时间限制
         *
         *
         *
         * @param n
         * @return
         */
        public int bulbSwitch(int n) {
            if (n < 2) {
                return n;
            }

            boolean[] bulbRes = new boolean[n];
            for (int i = 2; i <= n; i++) {
                for (int j = i -1; j < n ; j+= i) {
                    bulbRes[j] = !bulbRes[j];
                }
            }

            int count = 0;
            for (boolean bulbRe : bulbRes) {
                if (!bulbRe) {
                    count ++;
                }
            }

            return count;
        }

        /**
         *
         * 人家巧妙的思路
         * 因式分解，奇数个因子的灯泡最终才能亮，统计奇数个因子的灯泡树  -》 平方数灯泡才能亮 ， 统计平方数个数
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 36.6 MB
         * , 在所有 Java 提交中击败了
         * 6.28%
         * 的用户
         * @param n
         * @return
         */
        public int bulbSwitch1(int n) {
            return (int) Math.sqrt(n);
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().bulbSwitch1(99999999));//9999
        logger.info("{}", new Solution().bulbSwitch1(10));//3
        logger.info("{}", new Solution().bulbSwitch1(3));//1
        logger.info("{}", new Solution().bulbSwitch1(1));//1

    }
}
