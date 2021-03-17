package com.roy.miscellaneous.leetcode.stage1.stage11;

import java.util.Stack;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/28 15:14
 *
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 *
 * 进阶：
 *
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 *
 *
 */
public class TestSolution844 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution844.class);


    static class Solution {
        /**
         *
         * 用栈，第一个字符串入栈，第二个字符串出栈，最后栈空且第二个不剩字符返回true
         * O(n)
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时 :2 ms, 在所有 Java 提交中击败了77.22%的用户
         * 内存消耗 :38.1 MB, 在所有 Java 提交中击败了33.33%的用户
         * @param S
         * @param T
         * @return
         */
        public boolean backspaceCompare(String S, String T) {
            char[] sChars = S.toCharArray();
            char[] tChars = T.toCharArray();

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < sChars.length; i++) {
                char sChar = sChars[i];
                if ( '#' == sChar) {
                    if ( !stack.isEmpty() ) {
                        stack.pop();
                    }
                } else {
                    stack.push(sChar);
                }
            }

            int backSpace =0 ;
            for (int i = tChars.length - 1; i >= 0; i--) {
                char sChar = tChars[i];
                if ('#' == sChar) {
                    backSpace ++;
                } else {
                    if (backSpace ==0) {
                        if (!stack.empty()) {
                            Character peek = stack.peek();
                            if (peek != sChar) {
                                return false;
                            } else {
                                stack.pop();
                            }
                        } else {//栈里已空
                            return false;
                        }
                    } else {
                        backSpace --;
                    }
                }
            }
            return stack.empty();
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().backspaceCompare("aaa###a", "aaaa###a"));//false
        logger.info("{}", new Solution().backspaceCompare("ab##", "c#d#"));//true
        logger.info("{}", new Solution().backspaceCompare("ab#c", "ad#c"));//true
        logger.info("{}", new Solution().backspaceCompare("a##c", "#a#c"));//true
        logger.info("{}", new Solution().backspaceCompare("a#c", "b"));//false

    }
}
