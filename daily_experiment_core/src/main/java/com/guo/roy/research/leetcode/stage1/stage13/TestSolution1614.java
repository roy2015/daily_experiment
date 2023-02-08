package com.guo.roy.research.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/21
 *
 * 1614. 括号的最大嵌套深度
 * 如果字符串满足一下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
 *
 * 字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
 * 字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。
 * 字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
 * 类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)：
 *
 * depth("") = 0
 * depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
 * depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
 * 例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
 *
 * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(1+(2*3)+((8)/4))+1"
 * 输出：3
 * 解释：数字 8 在嵌套的 3 层括号中。
 * 示例 2：
 *
 * 输入：s = "(1)+((2))+(((3)))"
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "1+(2*3)/(2-1)"
 * 输出：1
 * 示例 4：
 *
 * 输入：s = "1"
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成
 * 题目数据保证括号表达式 s 是 有效的括号表达式
 */
public class TestSolution1614 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionTemplate.class);


    static class Solution {

        /**
         *
         * 时间，空间俱佳的解放，思路就是 用")"去消灭"("
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.4 MB, 在所有 Java 提交中击败了93.52%的用户
         *
         * @param s
         * @return
         */
        public int maxDepth(String s) {
            int maxDepth = 0;
            int tempDepth = 0;
            char[] chars = s.toCharArray();

            for (char aChar : chars) {
                if (aChar == '(') {
                    tempDepth ++;
                    if (tempDepth > maxDepth) {
                        maxDepth = tempDepth;
                    }
                } else if (aChar == ')') {
                    tempDepth --;
                } else {
                }
            }
            return maxDepth;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxDepth("(1)+((2))+(((3)))"));//3
        logger.info("{}", new Solution().maxDepth("1+(2*3)/(2-1)"));//1
        logger.info("{}", new Solution().maxDepth("1"));//0
        logger.info("{}", new Solution().maxDepth("(1+(2*3)+((8)/4))+1"));//3
    }
}
