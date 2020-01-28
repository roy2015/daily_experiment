package com.roy.miscellaneous.leetcode.stage2;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/16 13:44
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution3 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution3.class);

    static class Solution {

        /**
         *
         * 执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :36.5 MB, 在所有 Java 提交中击败了97.33%的用户
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            //首先排除异常情况
            if (null == s || s.length() == 0) {
                return 0;
            }
            int cnt =1, tmpCnt;
            char[] a = s.toCharArray();
            for(int p=0, v =1 ; v < a.length; v++) {
                int iv;
                boolean flag = false;
                tmpCnt = 0;
                for (iv = p; iv < v; iv ++) {
                    tmpCnt ++;
                    if (a[iv] == a[v]) {//字串有没有和当前重复
                        flag =true;
                        break;
                    }
                }
                if (flag) {
                    tmpCnt = v - p;
                    p = iv + 1;
                    cnt = tmpCnt > cnt ? tmpCnt : cnt;
                } else {
                    tmpCnt = v - p + 1;
                    cnt = tmpCnt > cnt ? tmpCnt : cnt;
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        Integer r1 = new Solution().lengthOfLongestSubstring("abcabcbb"); logger.info("{}", r1);
        Integer r2 = new Solution().lengthOfLongestSubstring("bbbbb");logger.info("{}", r2);
        Integer r3 = new Solution().lengthOfLongestSubstring("pwwkew"); logger.info("{}", r3);
        Integer r4 = new Solution().lengthOfLongestSubstring("dvdf"); logger.info("{}", r4);
        Integer r5 = new Solution().lengthOfLongestSubstring("ckilbkd"); logger.info("{}", r5);

    }

}
