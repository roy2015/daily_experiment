package com.roy.miscellaneous.leetcode.stage2;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by apple on 2020/1/19.
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution5 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution5.class);

    static class Solution {

        /**
         *
         *
         * 执行用时 :50 ms, 在所有 Java 提交中击败了47.99%的用户
         * 内存消耗 :36.1 MB, 在所有 Java 提交中击败了87.44%的用户
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if (s == null || "".equals(s) || s.length() == 1) {
                return s;
            }

            char[] chars = s.toCharArray();
            int len = chars.length;
            int retStartIndex = 0;//目前字符串开始下标
            int retEndIndex = 0;
            int oddStep = 0;//半步
            int i;
            boolean flag;
            //奇数,  两个字符时
            for (i = 1; i < len - 1; i++) {
                int step = i > (len - 1 - i) ? len - 1 - i : i;//最大能走的步数
                if (step < oddStep) {//小于
                    continue;
                }
                int j;
                //计算该点最大能走N步 N区间[oddstep, step], oddstep初始值0
                for (j = oddStep + 1; j <= step; j++) {
                    //尝试j步能不能走
                    flag = true;
                    for (int k = 1; k <= j; k++) {
                        if (chars[i - k] != chars[i + k]) {
                            flag = false;
                            break;
                        } else {
                        }
                    }
                    //j步可以走
                    if (flag) {
                        if (j > oddStep) {
                            oddStep = j;
                            retStartIndex = i - oddStep;
                            retEndIndex = i + oddStep;
                            if (2 * oddStep + 1 > len - 2) {
                                break;
                            }
                        } else {
                        }
                    } else {
                        break;
                    }
                }
            }

            //偶数
            if (2 * oddStep + 1 == len) {
                return s.substring(retStartIndex, retEndIndex + 1);
            }
            int evenStartStep = oddStep + 1;
            int step;
            int j;
            for (step = evenStartStep; step * 2 <= len; step++) {
                //遍历所有点，有没有能走大于奇数的步数或者是1
                for (i = 0; i + step * 2 <= len; i++) {
                    //比较组内的字符
                    flag = true;
                    for (j = i; j <= i + step - 1 && j + step < len; j++) {
                        if (chars[j] != chars[2 * i + 2 * step - 1 - j]) {
                            flag = false;
                            break;
                        } else {
                        }
                    }
                    if (flag && j != i) {
                        if (step * 2 - 1 > retEndIndex - retStartIndex) {
                            retStartIndex = i;
                            retEndIndex = i + step * 2 - 1;
                        }
                    }
                }
            }
            return s.substring(retStartIndex, retEndIndex + 1);
        }
    }

    public static void main(String[] args) {
        logger.info(new Solution().longestPalindrome("bacdca"));//acdca
        logger.info(new Solution().longestPalindrome("bbbb"));//bbbb
        logger.info(new Solution().longestPalindrome("babad"));//bab  aba
        logger.info(new Solution().longestPalindrome("cbbd"));//bb
        logger.info(new Solution().longestPalindrome("abacab"));//"bacab"

    }

}
