package com.roy.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/2/2
 *
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 *
 *
 */
public class TestSolution343 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution343.class);


    /**
     *
     * 2=   11  1
     * 3=   21  2
     * 4=   22  4
     * 5=   32  6
     * 6=   33  9
     * 7=  322  12
     * 8=  332  18
     * 9=  333  27
     * 10=3322  36
     * 11=3332  54
     * 12=3333  81
     * 13=33322 108
     * 14=33332 162
     *
     */
    static class Solution {
        /**
         *
         * 凑3？？想法清奇，原创
         *
         * 2=   11  1
         * 3=   21  2
         * 4=   22  4
         * 5=   32  6
         * 6=   33  9
         * 7=  322  12
         * 8=  332  18
         * 9=  333  27
         * 10=3322  36
         * 11=3332  54
         * 12=3333  81
         * 13=33322 108
         * 14=33332 162
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：19 ms, 在所有 Java 提交中击败了9.60%的用户
         * 内存消耗：36.6 MB, 在所有 Java 提交中击败了5.26%的用户
         *
         * @param n
         * @return
         */
        public int integerBreak(int n) {
            if (n <= 2) {
                return 1;
            }

            String predictionStr = "11";
            for (int i = 3; i <= n ; i++) {
                //特殊情况处理
                if (i == 4) {
                    predictionStr = "22";
                    continue;
                }

                int index = predictionStr.lastIndexOf("3");
                int length = predictionStr.length();
                if (index == -1) {
                    int anInt = Integer.parseInt(predictionStr.substring(0, 1));
                    predictionStr = (anInt + 1) + predictionStr.substring(1);
                } else if (index == length -1) {
                    predictionStr = predictionStr.substring(0, length -1) + "22";
                } else {
                    int anInt = Integer.parseInt(predictionStr.substring(index +1, index +2));
                    predictionStr = predictionStr.substring(0, index +1 )
                            + (anInt + 1) + predictionStr.substring(index + 2);
                }
            }
            //计算predictionStr代表的值
            char[] chars = predictionStr.toCharArray();
            int ret = 1;
            for (char aChar : chars) {
                ret = ret * (aChar - '0');
            }
            return ret;
        }

        /**
         * 自我净化版本，只要统计3和2个数，不用拼接字符串
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：35.3 MB, 在所有 Java 提交中击败了36.67%的用户
         *
         *
         * @param n
         * @return
         */
        public int integerBreak1(int n) {
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }
            if (n == 4) {
                return 4;
            }
            int threeNums = 0;
            int twoNums = 2;
            //从5开始
            for (int i = 5; i <= n ; i++) {
                if (twoNums != 0) {
                    threeNums++;
                    twoNums--;
                } else {
                    threeNums--;
                    twoNums = 2;
                }
            }
            return (int) (Math.pow(3, threeNums) * Math.pow(2, twoNums));
        }


    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().integerBreak1(4));//4
        logger.info("{}", new Solution().integerBreak1(58));//1549681956
    }
}
