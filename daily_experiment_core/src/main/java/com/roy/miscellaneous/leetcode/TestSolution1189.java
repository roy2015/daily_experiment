package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by apple on 2019/10/4.
 *
 *给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。

 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。

  

 示例 1：



 输入：text = "nlaebolko"
 输出：1
 示例 2：



 输入：text = "loonbalxballpoon"
 输出：2

 提示：

 1 <= text.length <= 10^4
 text 全部由小写英文字母组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution1189 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1189.class);

    /**
     */
    static class Solution {
        public int maxNumberOfBalloons(String text) {
            String targetStr = "balloon";

            int targetLength = targetStr.length();
            int result = 0;

            for (int i = 0; i < targetLength; ) {
                if (text.indexOf(targetStr.substring(i, i + 1)) == -1) {
                    break;
                }
                text = text.replaceFirst(targetStr.substring(i, i + 1), "0");
                if (i == targetLength - 1) {
                    result++;
                    i = 0;
                } else i++;
            }

            return result;
        }

        private int getCountOfChar(String s, String cha) {
            int index = s.indexOf(cha);
            if (index == -1) return 0;

            int count = 1;
            for (int j = index + 1; j < s.length(); j++) {
                if (s.substring(j, j + 1).equalsIgnoreCase(cha)) {
                    count++;
                } else break;
            }
            return count;
        }

        /**
         * 执行用时 :3 ms, 在所有 Java 提交中击败了87.32%的用户
         * 内存消耗 :35.8 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param text
         * @return
         */

        public int maxNumberOfBalloons_1(String text) {
            char[] textChars = text.toCharArray();
            Arrays.sort(textChars);
            String processedText = new String(textChars);

            String target = "balloon";
            char[] targetChars = target.toCharArray();
            Arrays.sort(targetChars);
            String processedTarget = new String(targetChars);

            int bCount_tar, bCount_tex;
            int aCount_tar, aCount_tex;
            int lCount_tar, lCount_tex;
            int oCount_tar, oCount_tex;
            int nCount_tar, nCount_tex;
            int count;

            bCount_tar = getCountOfChar(processedTarget, "b");
            bCount_tex = getCountOfChar(processedText, "b");
            if (bCount_tex == 0 || bCount_tex / bCount_tar == 0) {
                return 0;
            } else {
                count = bCount_tex / bCount_tar;
            }

            aCount_tar = getCountOfChar(processedTarget, "a");
            aCount_tex = getCountOfChar(processedText, "a");
            if (aCount_tex == 0 || aCount_tex / aCount_tar == 0) {
                return 0;
            } else if (aCount_tex / aCount_tar < count) {
                count = aCount_tex / aCount_tar;
            } else {
            }

            lCount_tar = getCountOfChar(processedTarget, "l");
            lCount_tex = getCountOfChar(processedText, "l");
            if (lCount_tex == 0 || lCount_tex / lCount_tar == 0) {
                return 0;
            } else if (lCount_tex / lCount_tar < count) {
                count = lCount_tex / lCount_tar;
            } else {
            }

            oCount_tar = getCountOfChar(processedTarget, "o");
            oCount_tex = getCountOfChar(processedText, "o");
            if (oCount_tex == 0 || oCount_tex / oCount_tar == 0) {
                return 0;
            } else if (oCount_tex / oCount_tar < count) {
                count = oCount_tex / oCount_tar;
            } else {
            }

            nCount_tar = getCountOfChar(processedTarget, "n");
            nCount_tex = getCountOfChar(processedText, "n");
            if (nCount_tex == 0 || nCount_tex / nCount_tar == 0) {
                return 0;
            } else if (nCount_tex / nCount_tar < count) {
                count = nCount_tex / nCount_tar;
            } else {
            }

            return count;
        }


        /**
         * 空间换时间
         *
         * @param text
         * @return
         */
        public int maxNumberOfBalloons_2(String text) {
            int[] textCount = new int[26];

            char[] chars = text.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                textCount[chars[i]-'a']++;
            }
            int count = Integer.MAX_VALUE;
            String targetStr = "balloon";
            char[] tarChars = targetStr.toCharArray();
            for (int i = 0; i < tarChars.length; i++) {
                if (tarChars[i] == 'l' || tarChars[i] == 'o') {
                    if (textCount[tarChars[i] - 'a'] / 2 < count) {
                        count = textCount[tarChars[i] - 'a'] / 2;
                    }
                } else {
                    if (textCount[tarChars[i] - 'a'] < count) {
                        count = textCount[tarChars[i] - 'a'];
                    }

                }

            }
            return count;
        }
    }

    public static void main(String[] args) {

//        logger.info("{}",new Solution().maxNumberOfBalloons("loonbalxballpoon"));
//        logger.info("{}",new Solution().maxNumberOfBalloons_1("loonbalxballpoon"));
        logger.info("{}",new Solution().maxNumberOfBalloons_2("loonbalxballpoon"));
        int i=0;
    }

}
