package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by apple on 2020/4/26.
 *20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 */
public class TestSolution20 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution20.class);

    static class Solution {
        /**
         *
         * 执行结果：通过显示详情
         * 执行用时 :2 ms, 在所有 Java 提交中击败了87.30%的用户
         * 内存消耗 :37.6 MB, 在所有 Java 提交中击败了5.48%的用户
         * @param s
         * @return
         */
        public boolean isValid(String s) {
            if ( s == null && toString().length() == 0) {
                return true;
            }

            char[] chars = s.toCharArray();
            Stack<Integer> stack = new Stack<>();

            int l1 = '(';
            int l2 = '[';
            int l3 = '{';

            int r1 = ')';
            int r2 = ']';
            int r3 = '}';

            Map<Integer, Integer> map = new HashMap<>();
            map.put(l1, r1);
            map.put(l2, r2);
            map.put(l3, r3);

            for (char aChar : chars) {
                if (stack.empty()) {
                    if (aChar == r1 || aChar == r2 || aChar == r3) {
                        return false;
                    } else {
                        stack.push((int) aChar);
                    }
                } else {
                    Integer peek = stack.peek();
                    int current = aChar;
                    if (current == l1 || current == l2 || current == l3) {
                        stack.push(current);
                    } else {
                        if (map.get(peek) == current) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                }
            }
            return stack.empty();
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().isValid("(])"));//false
        logger.info("{}", new Solution().isValid("()[]{}"));//true
        logger.info("{}", new Solution().isValid("()"));//true
        logger.info("{}", new Solution().isValid("(]"));//false
        logger.info("{}", new Solution().isValid("([)]"));//false
        logger.info("{}", new Solution().isValid("{[]}"));//true



    }

}
