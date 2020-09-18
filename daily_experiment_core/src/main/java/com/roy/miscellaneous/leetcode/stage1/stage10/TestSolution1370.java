package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/18
 *
 *
 * 1370. 上升下降字符串
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 *
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 *
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 *
 * 输入：s = "spo"
 * 输出："ops"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 *
 */
public class TestSolution1370 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1370.class);


    static class Solution {
        /**
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：3 ms, 在所有 Java 提交中击败了98.45%的用户
         * 内存消耗：38.8 MB, 在所有 Java 提交中击败了74.76%的用户
         *
         *
         * @param s
         * @return
         */
        public String sortString(String s) {
            char constansChar = 'a';
            if (s == null || s.length() == 0) {
                return s;
            }

            char[] chars = s.toCharArray();
            int[] dic = new int[26];
            for (char aChar : chars) {
                dic[aChar - constansChar] ++;
            }

            StringBuilder retSb = new StringBuilder();
            int end = 25;
            boolean retCond = true;
            boolean rotate = true;

            while (retCond) {
                retCond = false;
                if (rotate) {
                    for (int i = 0; i <= end ; i++) {
                        if (dic[i] > 0) {
                            if (!retCond) {
                                retCond = true;
                            } else {}

                            dic[i] --;
                            retSb.append((char) (i + constansChar));
                        } else {}
                    }
                } else {
                    for (int i = end; i >= 0 ; i--) {
                        if (dic[i] > 0) {
                            if (!retCond) {
                                retCond = true;
                            } else {}

                            dic[i] --;
                            retSb.append((char) (i + constansChar));
                        } else {}
                    }
                }
                rotate = ! rotate;
            }
            return retSb.toString();
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().sortString("aaaabbbbcccc"));//abccbaabccba
        logger.info("{}", new Solution().sortString("rat"));//art
        logger.info("{}", new Solution().sortString("leetcode"));//cdelotee
        logger.info("{}", new Solution().sortString("spo"));//ops
        logger.info("{}", new Solution().sortString("ggggggg"));//ggggggg
    }
}
