package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/4
 *
 *
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 *
 * 提示：
 *
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 *
 *
 */
public class TestSolution541 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution541.class);


    static class Solution {

        /**
         *
         *
         * 使用了stringBuilder，走了无效的loop，见第二个优化方法  {@link TestSolution541.Solution#reverseStr1(java.lang.String, int)}
         * 考基本功
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 4 ms, 在所有 Java 提交中击败了13.93%的用户
         * 内存消耗：
         * 39.7 MB, 在所有 Java 提交中击败了79.01%的用户
         *
         *
         * @param s
         * @param k
         * @return
         */
        public String reverseStr(String s, int k) {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            int idx = 0;
            int len = chars.length;
            int seg = 2 * k;
            //step1 2k循环
            while (len - idx >= seg) {
                //前k个反转
                for (int i = idx + k -1; i >= idx ; i--) {
                    sb.append(chars[i]);
                }
                //后k个原样
                int end = idx + seg;
                for (int i = idx + k; i < end; i++) {
                    sb.append(chars[i]);
                }
                idx += seg;
            }

            //step 2 多于等于k个的，k个翻转
            if (len - idx >= k) {
                for (int i = idx + k -1; i >= idx ; i--) {
                    sb.append(chars[i]);
                }
                idx += k;
                //剩余的原样
                for (; idx < len ; idx++) {
                    sb.append(chars[idx]);
                }
            //step2 小于k个
            } else {
                //反转
                for (int i = len -1; i >= idx ; i--) {
                    sb.append(chars[i]);
                }
            }

            return sb.toString();
        }

        /**
         *
         * 对上面的优化，去掉了StringBuilder, 原样输出的不做任何操作，这个和上面的本质区别 {@link TestSolution541.Solution#reverseStr(String, int)} 直接原地
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 39.6 MB, 在所有 Java 提交中击败了95.06%的用户
         *
         *
         * @param s
         * @param k
         * @return
         */
        public String reverseStr1(String s, int k) {
            char[] chars = s.toCharArray();
            int idx = 0;
            int len = chars.length;
            int seg = 2 * k;
            int sumIdx;
            int midIdx;

            //step1 2k循环
            while (len - idx >= seg) {
                sumIdx = idx + (idx + k -1);
                midIdx = sumIdx / 2;

                //前k个反转
                for (int i = idx; i <= midIdx ; i++) {
                    char tmp = chars[i];
                    chars[i] = chars[sumIdx - i];
                    chars[sumIdx - i] = tmp;
                }

                //后k个原样
                /*int end = idx + seg;
                for (int i = idx + k; i < end; i++) {
                    sb.append(chars[i]);
                }*/
                idx += seg;
            }

            //step 2 多于等于k个的，k个翻转
            if (len - idx >= k) {
                sumIdx = idx + (idx + k -1);
                midIdx = sumIdx / 2;
                //前k个反转
                for (int i = idx; i <= midIdx ; i++) {
                    char tmp = chars[i];
                    chars[i] = chars[sumIdx - i];
                    chars[sumIdx - i] = tmp;
                }
//                idx += k;
                //剩余的原样
                /*for (; idx < len ; idx++) {
                    sb.append(chars[idx]);
                }*/
                //step2 小于k个
            } else {
                //反转
                sumIdx = idx + (len -1);
                midIdx = sumIdx / 2;
                //前k个反转
                for (int i = idx; i <= midIdx ; i++) {
                    char tmp = chars[i];
                    chars[i] = chars[sumIdx - i];
                    chars[sumIdx - i] = tmp;
                }
            }

            return new String(chars);
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().reverseStr("abcdefg", 8));//gfedcba
        logger.info("{}", new Solution().reverseStr("abcd", 4));//dcba
        logger.info("{}", new Solution().reverseStr("abcdefg", 2));//bacdfeg
        logger.info("{}", new Solution().reverseStr("a", 1));//a
    }
}
