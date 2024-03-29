package com.guo.roy.research.leetcode.stage1.stage10;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/23.
 *给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

 注意：每次拼写时，chars 中的每个字母都只能用一次。

 返回词汇表 words 中你掌握的所有单词的 长度之和。

  

 示例 1：

 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 输出：6
 解释：
 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 示例 2：

 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 输出：10
 解释：
 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。


 提示：

 1 <= words.length <= 1000
 1 <= words[i].length, chars.length <= 100
 所有字符串中都仅包含小写英文字母

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution1160 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1160.class);

    /**
     */
    static class Solution {

        /**
         * 执行用时 :5 ms, 在所有 java 提交中击败了98.21%的用户
         内存消耗 :37.9 MB, 在所有 java 提交中击败了100.00%的用户
         *
         * @param words
         * @param chars
         * @return
         */
        public int countCharacters(String[] words, String chars) {
            //校验入参是否入题目要求的条件
            if (words == null || words.length < 1 || chars == null || chars.length() < 1) {
                return 0;
            }

            //chars的个数映射数组
            char[] charArray = chars.toCharArray();
            int[] charPresentCountArry = new int[26];
            Arrays.fill(charPresentCountArry, 0);
            for (char c : charArray) {
                charPresentCountArry[c - 'a'] += 1;
            }

            int[] copyCharPresentCountArry = new int[26];

            int wordLength =0;
            boolean alarmFlag;//报警标志
            for (String word : words) {
                System.arraycopy(charPresentCountArry, 0, copyCharPresentCountArry, 0, charPresentCountArry.length);
                char[] tmpChars = word.toCharArray();
                alarmFlag = false;
                for (char tmpChar : tmpChars) {
                    if (copyCharPresentCountArry[tmpChar - 'a'] == 0) {
                        alarmFlag = true;
                        break;
                    } else {
                        copyCharPresentCountArry[tmpChar - 'a'] --;
                    }
                }
                if (! alarmFlag) {
                    wordLength += word.length();
                }
            }
            return wordLength;
        }
    }

    public static void main(String[] args) {
        int countCharacters = new Solution().countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr");
        logger.info("{}", countCharacters);
    }

}
