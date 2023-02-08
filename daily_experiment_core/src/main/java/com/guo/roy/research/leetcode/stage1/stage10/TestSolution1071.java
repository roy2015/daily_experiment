package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/31
 *1071. 字符串的最大公因子
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 *
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *
 *
 * 提示：
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 */
public class TestSolution1071 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1071.class);


    static class Solution {
        /**
         * 找该字符串的因子
         * @param chars1
         * @return
         */
        public String getGysStr (char[] chars1) {

            int[] presentDics;
            presentDics = new int[26];
            for (char c : chars1) {
                int val = c -'A';
                presentDics[val] ++;
            }

            int gys = 0;

            int sum = 0;
            for (int presentDic : presentDics) {
                if (presentDic != 0) {
                    if (gys != 0) {
                        gys = getGYS1(presentDic, gys);
                        if (gys == 1) break;
                    } else {
                        gys = presentDic;
                    }
                    sum += presentDic;
                }
            }

            if (gys ==1) {
                return new String(chars1);
            }
            
            int gyslen = sum / gys;
            StringBuffer collSb = new StringBuffer();
            for (int i = 0; i < gyslen; i++) {
                collSb.append(chars1[i]);
            }

            String gysStr = collSb.toString();
            collSb = new StringBuffer();
            for (int i = 0; i < gys; i++) {
                collSb.append(gysStr);
            }

            if (!collSb.toString().equals(new String(chars1))) {
               return  new String(chars1);
            }

            return gysStr;

        }

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：3 ms, 在所有 Java 提交中击败了19.55%的用户
         * 内存消耗：38.5 MB, 在所有 Java 提交中击败了85.33%的用户
         *
         * @param str1
         * @param str2
         * @return
         */
        public String gcdOfStrings(String str1, String str2) {
            if (str1.isEmpty() || str2.isEmpty()) {
                return "";
            }


            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();

            int s1Len = chars1.length;
            //求公约字符串
            StringBuffer collSb = new StringBuffer();
            String gys = getGysStr(chars1/*, s1Len*/);

            int gysLen = gys.length();
            int times1 = s1Len / gysLen;

            int s2Len = chars2.length;
            if (s2Len % gysLen != 0) {
                return "";
            }
            int times2 = s2Len / gysLen;
            collSb = new StringBuffer();
            for (int i = 0; i < times2; i++) {
                collSb.append(gys);
            }
            if (!collSb.toString().equals(str2)) {
                return "";
            }
            //求最大公约数
            int times = getGYS1(times1, times2);
            collSb = new StringBuffer();
            for (int i = 0; i < times; i++) {
                collSb.append(gys);
            }
            return collSb.toString();
        }

        /**
         * 辗转相除法求最大公约数 （网上copy的, 比上面手写的效率高）
         * @param num1
         * @param num2
         * @return
         */
        private int getGYS1(int num1, int num2) {
            // 先获得绝对值，保证负数也可以求
            num1 = Math.abs(num1);
            num2 = Math.abs(num2);
            // 先求余数，假定第一个数较大；如果第二个较大，在第二轮调用时会颠倒过来
            int remainder = num1 % num2;
            // 如果为 0，则直接得出
            if (remainder == 0) {
                return num2;
            }
            // 递归调用
            return getGYS1(num2, remainder);
        }

    }

    public static void main(String[] args) {

        new Solution().getGysStr("TAUXXTAUXXTAUXXTAUXXTAUXX".toCharArray());
        logger.info("{}", new Solution().gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX",
                "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));//"TAUXX"
        logger.info("{}", new Solution().gcdOfStrings("ABCABC", "ABC"));//"ABC"
        logger.info("{}", new Solution().gcdOfStrings("ABC", "AB"));//""
        logger.info("{}", new Solution().gcdOfStrings("ABABAB", "ABAB"));//"AB"
        logger.info("{}", new Solution().gcdOfStrings("LEET", "CODE"));//""
        logger.info("{}", new Solution().gcdOfStrings("ABC", "ABC"));//"ABC"
        logger.info("{}", new Solution().gcdOfStrings("", ""));//""
        logger.info("{}", new Solution().gcdOfStrings("", ""));//""
    }
}
