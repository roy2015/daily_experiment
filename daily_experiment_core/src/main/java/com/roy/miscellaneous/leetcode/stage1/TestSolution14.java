package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/8.
 *编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-common-prefix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution14 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution14.class);

    /**
     *
     * * 执行用时 :
     2 ms
     , 在所有 Java 提交中击败了
     76.05%
     的用户
     */
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            int i = 0;
            String tmpStr;
            StringBuffer sb = new StringBuffer();

            if (strs.length ==0) {
                return sb.toString();
            }

            while (i < strs[0].length()) {
                tmpStr = strs[0].substring(i, i + 1);
                for (int i1 = 1; i1 < strs.length; i1++) {
                    if (i == strs[i1].length() || !tmpStr.equals(strs[i1].substring(i, i+1)) ) {
                        return sb.toString();
                    }
                }
                sb.append(tmpStr);
                i++;
            }


            return sb.toString();
        }

        /**
         * 执行用时 :
         1 ms
         , 在所有 Java 提交中击败了
         98.22%
         的用户
         * @param strs
         * @return
         */
        public String longestCommonPrefix1(String[] strs) {
            int i = 0;
            char tmpChar;
            StringBuffer sb = new StringBuffer();

            if (strs.length ==0) {
                return sb.toString();
            }

            while (i < strs[0].length()) {
                tmpChar = strs[0].charAt(i);
                for (int i1 = 1; i1 < strs.length; i1++) {
                    if (i == strs[i1].length() || ! (tmpChar == strs[i1].charAt(i)) ) {
                        return sb.toString();
                    }
                }
                sb.append(tmpChar);
                i++;
            }


            return sb.toString();
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().longestCommonPrefix1(new String[]{"dog","racecar","car"}));
    }

}
