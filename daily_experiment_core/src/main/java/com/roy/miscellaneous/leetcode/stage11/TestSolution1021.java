package com.roy.miscellaneous.leetcode.stage11;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author guojun
 * @date 2020/5/26
 *
 * 1021. 删除最外层的括号
有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。

如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。

给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。

对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。



示例 1：

输入："(()())(())"
输出："()()()"
解释：
输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
示例 2：

输入："(()())(())(()(()))"
输出："()()()()(())"
解释：
输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
示例 3：

输入："()()"
输出：""
解释：
输入字符串为 "()()"，原语化分解得到 "()" + "()"，
删除每个部分中的最外层括号后得到 "" + "" = ""。
 */
public class TestSolution1021 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1021.class);


    static class Solution {

        /**
         *
         * 用了栈
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :13 ms, 在所有 Java 提交中击败了22.56%
         的用户
         内存消耗 :40.1 MB
         , 在所有 Java 提交中击败了7.69%
         的用户

         * @param S
         * @return
         */
        public String removeOuterParentheses(String S) {
            char[] chars = S.toCharArray();
            Stack<Character> stack = new Stack<Character>();
            StringBuffer sb = new StringBuffer();

            int start = 0;
            for (int i = 0; i < chars.length; i++) {
                char iChar = chars[i];
                if (stack.empty()) {
                    stack.push(iChar);
                    continue;
                }

                Character top = stack.peek();
                if (stack.size() ==1 && (top == '(' && iChar == ')') ) {
                    stack.pop();
                    sb.append(new String(Arrays.copyOfRange(chars, start +1, i)));
                    start = i +1;
                } else if ((top == '(' && iChar == ')')) {
                    stack.pop();
                } else {
                    stack.push(iChar);
                }
            }
            return sb.toString();
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().removeOuterParentheses("(()())(())"));//()()()
        logger.info("{}", new Solution().removeOuterParentheses("(()())(())(()(()))"));//()()()()(())
        logger.info("{}", new Solution().removeOuterParentheses("()()"));//""
    }
}
