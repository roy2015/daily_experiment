package com.roy.miscellaneous.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/23
 *
 *
 *
 * 821. 字符的最短距离
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 *
 * 示例 1:
 *
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 说明:
 *
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 *
 *
 */
public class TestSolution821 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution821.class);


    static class Solution {
        /**
         * 有没有更好的思路
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：8 ms, 在所有 Java 提交中击败了13.48%的用户
         * 内存消耗：38.1 MB, 在所有 Java 提交中击败了99.56%的用户
         *
         * @param S
         * @param C
         * @return
         */
        public int[] shortestToChar(String S, char C) {
            List<Integer> dic = new ArrayList<>();
            char[] chars = S.toCharArray();
            int length = chars.length;
            for (int i = 0; i < length; i++) {
                if (C == chars[i]) {
                    dic.add(i);
                }
            }
            int[] retDis = new int[length];
            for (int i = 0; i < length; i++) {
                int min = length;
                for (Integer idx : dic) {
                    int dis = Math.abs(idx - i);
                    if (dis < min) {
                        min = dis;
                    }
                }
                retDis[i] = min;
            }
            return retDis;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().shortestToChar("loveleetcode", 'e'));
    }
}
