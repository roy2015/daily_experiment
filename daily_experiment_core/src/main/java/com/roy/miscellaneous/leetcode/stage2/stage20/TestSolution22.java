package com.roy.miscellaneous.leetcode.stage2.stage20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/23
 *
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 */
public class TestSolution22 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution22.class);


    static class Solution {

        /**
         *
         * 一脸懵逼，后借鉴了扣友的思路，算法思路比较新奇，估计没有第二家了,代码实现是自己写的，动态规划
         * ，到底了都是数学的思维~, 一行公式就知道怎么写代码了
         * https://leetcode-cn.com/problems/generate-parentheses/solution/zui-jian-dan-yi-dong-de-dong-tai-gui-hua-bu-lun-da/
         * "(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
         * 其中 p + q = n-1，且 p q 均为非负整数。
         *
         * 总结公式为：
         * 两个组合的笛卡尔积 0- n-1，举例：f0=1（""） f1=f0*f0=1（"()"） f2=f0*f1+f1*f0=2("(())","()()") f3= f0*f2(02=2) + f1*f1(11=1) + f2*f0(20=2)
         *
         *
         * 动态规划
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 2 ms
         * , 在所有 Java 提交中击败了
         * 37.22%
         * 的用户
         * 内存消耗：
         * 38.7 MB
         * , 在所有 Java 提交中击败了
         * 83.93%
         * 的用户
         *
         * @param n
         * @return
         */
        public List<String> generateParenthesis(int n) {
            //0的情况直接排除
            if (n == 0) {
                return Collections.emptyList();
            }
            //初始化dp数组
            List<String>[] dp = new ArrayList[n+1];
            for (int i = 0; i <= n; i++) {
                dp[i] = new ArrayList<>();
            }
            dp[0].add("");
            //计算
            for (int i = 1; i <= n; i++) {
                int pqSum = i -1;
                for (int p = 0; p <= pqSum; p++) {
                    int q = pqSum - p;
                    List<String> pStrings = dp[p];
                    List<String> qStrings = dp[q];

                    for (String pString : pStrings) {
                        for (String qString : qStrings) {
                            dp[i].add(new StringBuffer().append("(").append(pString).append(")").append(qString).toString());
                        }
                    }
                }
            }
            return  dp[n];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().generateParenthesis(2));//2个括号
        logger.info("{}", new Solution().generateParenthesis(1));//1个括号
        logger.info("{}", new Solution().generateParenthesis(0));//0
        logger.info("{}", new Solution().generateParenthesis(3));//5 个括号
        logger.info("{}", new Solution().generateParenthesis(4));//5 个括号
    }
}
