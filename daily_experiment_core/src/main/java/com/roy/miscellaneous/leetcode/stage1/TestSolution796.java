package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/4.
 *给定两个字符串, A 和 B。

 A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。

 示例 1:
 输入: A = 'abcde', B = 'cdeab'
 输出: true

 示例 2:
 输入: A = 'abcde', B = 'abced'
 输出: false
 注意：

 A 和 B 长度不超过 100。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/rotate-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution796 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution796.class);

    /**
     */
    static class Solution {
        /**
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了71.14%的用户
         内存消耗 :34.4 MB, 在所有 java 提交中击败了81.25%的用户
         *
         * @param A
         * @param B
         * @return
         */
        public boolean rotateString(String A, String B) {
            if (A == null || B== null) {
                return false;
            }
            if (A.length() != B.length()) {
                return false;
            }
            if (A.length() ==0) {
                return true;
            }

            char[] charsA = A.toCharArray();
            char[] charsB = B.toCharArray();
            char[] preChars = charsA;
            char[] curChars;
            int len = charsA.length;
            for (int i = 0; i < len; i++) {
                char c = charsA[i];
                curChars = new char[len];
                System.arraycopy(preChars, 1, curChars, 0, len -1);
                curChars[len-1] = c;
                if (isCharArrayEqual(curChars, charsB)) {
                    return true;
                }
                preChars = curChars;
            }

            return false;
        }

        private boolean isCharArrayEqual(char[] chars1, char[] chars2) {
            if (chars1.length != chars2.length) {
                return false;
            }
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] != chars2[i]) {
                    return false;
                }
            }
            return true;
        }

        public boolean rotateString1(String A, String B) {
            return true;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().rotateString1("bqqutquvbtgouklsayfvzewpnrbwfcdmwctusunasdbpbmhnvy",
                "wpnrbwfcdmwctusunasdbpbmhnvybqqutquvbtgouklsayfvze"));
    }

}
