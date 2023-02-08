package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

 

示例 1：

输入: s = "abcdefg", k = 2
输出: "cdefgab"
示例 2：

输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"
 

限制：

1 <= k < s.length <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolutionInterview58 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview58.class);


    static class Solution {
        /**
         *
         * 空间换时间 两个数组，避免在一个数组里增加复杂度
         *
         * 执行用时 :2 ms, 在所有 Java 提交中击败了29.23%的用户
         内存消耗 :39.8 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param s
         * @param n
         * @return
         */
        public String reverseLeftWords(String s, int n) {
            int len = s.length();
            if(n >= len) {
                return s;
            }

            char[] chars = s.toCharArray();
            char[] retChars = new char[len];


            for(int i = 0; i< len; i++) {
                if(i <n) {
                    retChars[len-n+i] = chars[i];
                } else{
                    retChars[i-n] = chars[i];
                }

            }

            return new String(retChars);
        }

        /**
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :39.1 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param s
         * @param n
         * @return
         */
        public String reverseLeftWords_1(String s, int n) {
            return n >= s.length() ? s : s.substring(n) + s.substring(0,n);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = solution.reverseLeftWords("lrloseumgh", 6);
        int i =0;
    }
}
