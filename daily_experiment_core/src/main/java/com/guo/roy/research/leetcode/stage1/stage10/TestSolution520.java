package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/12.
 *给定一个单词，你需要判断单词的大写使用是否正确。

 我们定义，在以下情况时，单词的大写用法是正确的：

 全部字母都是大写，比如"USA"。
 单词中所有字母都不是大写，比如"leetcode"。
 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 否则，我们定义这个单词没有正确使用大写字母。

 示例 1:

 输入: "USA"
 输出: True
 示例 2:

 输入: "FlaG"
 输出: False
 注意: 输入是由大写和小写拉丁字母组成的非空单词。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/detect-capital
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution520 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution520.class);

    /**
     */
    static class Solution {

        /**
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
         内存消耗 :34.6 MB, 在所有 java 提交中击败了93.44%的用户
         *
         * @param word
         * @return
         */
        public boolean detectCapitalUse(String word) {
            char[] chars = word.toCharArray();
            if (chars.length == 1 || chars.length ==0) {
                return true;
            }

            char firstChar = chars[0];
            char secondChar = chars[1];

            if (firstChar >= 'a' && firstChar <= 'z') {
                for (int i = 1; i < chars.length; i++) {
                    if (chars[i] >= 'A' && chars[i] <= 'Z') {
                        return false;
                    }
                }
            } else if (firstChar >= 'A' && firstChar <= 'Z') {
                if (secondChar >= 'A' && secondChar <= 'Z') {
                    for (int i = 2; i < chars.length; i++) {
                        if (chars[i] >= 'a' && chars[i] <= 'z') {
                            return false;
                        }
                    }
                } else {
                    for (int i = 2; i < chars.length; i++) {
                        if (chars[i] >= 'A' && chars[i] <= 'Z') {
                            return false;
                        }
                    }

                }
            } else {}
            return true;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().detectCapitalUse("Google"));
    }

}
