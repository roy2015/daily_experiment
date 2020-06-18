package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.function.Function;

/**
 * @author guojun
 * @date 2020/6/18
 *
 *
 *1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class TestSolution1047 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1047.class);


    static class Solution {

        /**
         *
         *
         * linkedList 也是栈，且支持两头出栈
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :17 ms, 在所有 Java 提交中击败了74.50%的用户
         * 内存消耗 :
         * 40.4 MB, 在所有 Java 提交中击败了7.69%的用户
         *
         * @param S
         * @return
         */
        public String removeDuplicates(String S) {
            LinkedList<Character> stack = new LinkedList<Character>();
            char[] chars = S.toCharArray();
            for (char aChar : chars) {
                if (stack.isEmpty()) {
                    stack.push(aChar);
                    continue;
                }
                int flag = 0;
                while ( !stack.isEmpty() && stack.peek().equals(aChar)) {
                    flag = 1;
                    stack.pop();
                }
                if (flag == 0) {
                    stack.push(aChar);
                }
            }

            int size = stack.size();
            char[] retChars = new char[size];
            int k = size;
            while (!stack.isEmpty()) {
                retChars[--k] = stack.pop();
            }

            return new String(retChars);
        }


    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().removeDuplicates("abbaca"));
    }
}
