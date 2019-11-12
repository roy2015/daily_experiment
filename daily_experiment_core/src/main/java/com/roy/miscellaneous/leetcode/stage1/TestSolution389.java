package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/24.
 *给定两个字符串 s 和 t，它们只包含小写字母。

 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

 请找出在 t 中被添加的字母。

  

 示例:

 输入：
 s = "abcd"
 t = "abcde"

 输出：
 e

 解释：
 'e' 是那个被添加的字母。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-the-difference
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution389 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution389.class);

    /**
     */
    static class Solution {
        /**
         * 执行用时 :2 ms, 在所有 java 提交中击败了89.54%的用户
         内存消耗 :37.5 MB, 在所有 java 提交中击败了41.18%的用户
         *
         * @param s
         * @param t
         * @return
         */
        public char findTheDifference(String s, String t) {
            char[] chars1 = s.toCharArray();

            int[] charMap = new int[26];
//            Arrays.fill(charMap, 0);

            for (char c : chars1) {
                charMap[c - 'a'] += 1;
            }

            for (int i = 0; i < t.length(); i++) {
                char tmpChar = t.charAt(i);
                if( charMap[tmpChar - 'a'] == 0) {
                    return tmpChar;
                } else {
                    charMap[tmpChar - 'a'] --;
                }
            }
            return '1';
        }

        /**
         * 去掉了 String.charAt(i)，改用数组
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
         内存消耗 :37.5 MB, 在所有 java 提交中击败了42.73%的用户
         *
         * @param s
         * @param t
         * @return
         */
        public char findTheDifference1(String s, String t) {
            char[] chars1 = s.toCharArray();
            char[] chars2 = t.toCharArray();

            int[] charMap = new int[26];
            //Arrays.fill(charMap, 0);

            for (char c : chars1) {
                charMap[c - 'a'] += 1;
            }

            for (int i = 0; i < chars2.length; i++) {
                if( charMap[chars2[i] - 'a'] == 0) {
                    return chars2[i];
                } else {
                    charMap[chars2[i] - 'a'] --;
                }
            }
            return '1';
        }

        /**
         *
         * 又是流氓方法， 是leetcode的，不是自己的
         * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
         内存消耗 :37.5 MB, 在所有 java 提交中击败了44.05%的用户
         * @param s
         * @param t
         * @return
         */
        public char findTheDifference3(String s, String t) {
            char[] chars1 = s.toCharArray();
            char[] chars2 = t.toCharArray();
            int res = 0;
            for (char c : chars1) {
                res ^= c;
            }
            for (char c: chars2){
                res ^= c;
            }
            return (char) res;


        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findTheDifference("a", "aa"));
    }

}
