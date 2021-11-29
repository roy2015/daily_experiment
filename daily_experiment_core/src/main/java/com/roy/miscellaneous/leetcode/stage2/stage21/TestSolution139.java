package com.roy.miscellaneous.leetcode.stage2.stage21;

import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 *
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定 s 是否可以由空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：拆分时可以重复使用字典中的单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution139 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution139.class);


    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int len = s.length();
            int[] dp = new int[len + 1];
            dp[0] = 1;

            String[] str = new String[len + 1];
            str[0] = "";
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                str[i +1] = str[i] + chars[i];
            }

            for (int i = 0; i < str.length; i++) {
                String s1 = str[i];
                for (String s2 : wordDict) {

                    if (s1.endsWith(s2)) {
                        int idx = s1.lastIndexOf(s2);
                        if (dp[idx] == 1) {
                            dp[i] = 1;
                            break;
                        }
                    }
                }
            }
            return dp[len] == 1 ? true : false;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));//false
        logger.info("{}", new Solution().wordBreak("applepenapple", Arrays.asList("apple", "pen", "apple")));//true
        logger.info("{}", new Solution().wordBreak("leetcode", Arrays.asList("leetcode", "leet", "code")));//true
    }
}
