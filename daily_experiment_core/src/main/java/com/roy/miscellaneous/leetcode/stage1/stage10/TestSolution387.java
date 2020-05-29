package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/23.
 *
 *给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

 案例:

 s = "leetcode"
 返回 0.

 s = "loveleetcode",
 返回 2.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution387 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution387.class);

    /**
     */
    static class Solution {
        public int firstUniqChar(String s) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {

                if (s.indexOf(chars[i] + "") == s.lastIndexOf(chars[i] + "")) {
                    return i;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new TestSolution387.Solution().firstUniqChar("leetcode"));
    }

}
