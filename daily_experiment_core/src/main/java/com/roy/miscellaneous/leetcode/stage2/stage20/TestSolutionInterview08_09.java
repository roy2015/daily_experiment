package com.roy.miscellaneous.leetcode.stage2.stage20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 *
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。

说明：解集不能包含重复的子集。

例如，给出 n = 3，生成结果为：

[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()"
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bracket-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolutionInterview08_09 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview08_09.class);


    static class Solution {
        /**
         * 递归+循环+栈
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时 :165 ms, 在所有 Java 提交中击败了5.15%的用户
         * 内存消耗 :42.1 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param n
         * @return
         */
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList();
            List<String> subList;
            if (n == 1) {
                list.add("()");
            } else {
                subList = generateParenthesis( n -1);
                String strI = null;
                int size = subList.size();
                for (int i=0; i< size; i++) {
                    strI = subList.get(i);
                    processListBaseOnSubListItem(list, strI);
//                    processListBaseOnSubListItem1(list, strI);
                }
            }
            return list;
        }

        /**
         * 生成当前层次的括号，基于上一层
         *
         * 逻辑： 1. "(" 插到 i 前面，")"插到 j 后面
         *       2.  j==i-1 时单独处理，因为是都要插到 i 前面
         * @param retList
         * @param subStr
         */
        public void processListBaseOnSubListItem(List<String> retList, String subStr) {
            int length = subStr.length();
            for (int i = 0; i < length; i++) {
                for (int j = i -1 ; j < length; j++) {
                    if (j == i -1) {//括号加到前面，单独处理
                        String candidateStr = subStr.substring(0, j+ 1)   + "(" + ")" + subStr.substring(i);
                        if (checkKuohao(candidateStr)) {
                            if (!retList.contains(candidateStr)) {
                                retList.add(candidateStr);
                            }
                        }
                    } else {
                        String candidateStr = subStr.substring(0, i) + "(" + subStr.substring(i, j + 1) +
                                 ")" +
                                subStr.substring(j);
                        if (!retList.contains(candidateStr) && checkKuohao(candidateStr)) {
                           retList.add(candidateStr);
                        }
                    }
                }
            }
        }

        /**
         * 同上，用的纯数组实现的
         * @param retList
         * @param subStr
         */
        public void processListBaseOnSubListItem1(List<String> retList, String subStr) {
            int length = subStr.length();
            char[] chars = subStr.toCharArray();
            char[] opChars = new char[length +2];
            Arrays.fill(opChars, '.');
            for (int i = 0; i < length; i++) {
                for (int j = i -1 ; j < length; j++) {
                    if (j == i -1) {//括号加到前面，单独处理
                        System.arraycopy(chars, 0, opChars,  0, j+1 );
                        opChars[j+1] = '(';
                        opChars[j+2] = ')';
                        System.arraycopy(chars, i, opChars,  j+3, length -i );
                    } else {
                        System.arraycopy(chars, 0, opChars,  0, i );
                        opChars[i] = '(';
                        System.arraycopy(chars, i, opChars,  i, j+1-i );
                        opChars[j+1] = ')';
                        System.arraycopy(chars, j, opChars,  j+2, length -j );
                    }

                    String s = new String(opChars);
                    if (!retList.contains(s) && checkKuohao(opChars)) {
                        retList.add(s);
                    }
                }
            }
        }

        /**
         * 校验括号的正确性
         * @return
         */
        public boolean checkKuohao (char[] chars) {
//            char[] chars = str.toCharArray();
            Stack<String> stack = new Stack();
            for (char aChar : chars) {
                if (aChar == '(') {
                    stack.push("(");
                } else {
                    if (stack.empty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.empty();
        }

        /**
         * 校验括号的正确性
         * @return
         */
        public boolean checkKuohao (String str) {
            char[] chars = str.toCharArray();
            Stack<String> stack = new Stack();
            for (char aChar : chars) {
                if (aChar == '(') {
                    stack.push("(");
                } else {
                    if (stack.empty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.empty();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        logger.info("{}" ,solution.checkKuohao("(()))"));
        logger.info("{}" ,solution.checkKuohao("(())"));
        logger.info("{}" ,solution.checkKuohao("((())"));
        logger.info("{}" ,solution.checkKuohao(")"));

//        logger.info("123".substring(0,0));

        List<String> list = solution.generateParenthesis(4);
        logger.info("size:{}, {}", list.size(), list);
    }
}
