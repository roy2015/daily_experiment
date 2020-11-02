package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/11/2
 *
 *
 *
 * 748. 最短补全词
 * 给定一个字符串牌照 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
 *
 * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为 补全词 。在所有完整词中，最短的单词我们称之为 最短补全词 。
 *
 * 单词在匹配牌照中的字母时要：
 *
 * 忽略牌照中的数字和空格。
 * 不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 * 如果某个字母在牌照中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 * 例如：licensePlate = "aBc 12c"，那么它由字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 是 "abccdef"、"caaacab" 以及 "cbca" 。
 *
 * 题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取单词列表中最靠前的一个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 说明：最短补全词应该包括 "s"、"p"、"s" 以及 "t"。在匹配过程中我们忽略牌照中的大小写。
 * "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
 * "steps" 包含 "t"、"p" 和两个 "s"。
 * "stripe" 缺一个 "s"。
 * "stepple" 缺一个 "s"。
 * 因此，"steps" 是唯一一个包含所有字母的单词，也是本样例的答案。
 * 示例 2：
 *
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 * 说明：存在 3 个包含字母 "s" 且有着最短长度的补全词，"pest"、"stew"、和 "show" 三者长度相同，但我们返回最先出现的补全词 "pest" 。
 * 示例 3：
 *
 * 输入：licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy","education","drug","prevent","writer","old"]
 * 输出："husband"
 * 示例 4：
 *
 * 输入：licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder","box","arrive","money","tax","thus"]
 * 输出："enough"
 * 示例 5：
 *
 * 输入：licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","public","never","wonder","simple","thought","use"]
 * 输出："simple"
 *
 *
 * 提示：
 *
 * 1 <= licensePlate.length <= 7
 * licensePlate 由数字、大小写字母或空格 ' ' 组成
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 15
 * words[i] 由小写英文字母组成
 *
 *
 */
public class TestSolution748 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution748.class);


    static class Solution {
        /**
         * 前提条件：words[i] 由小写英文字母组成 licensePlate 由数字、大小写字母或空格 ' ' 组成
         *
         * 思路清晰的算法，简洁高效
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：3 ms, 在所有 Java 提交中击败了96.49%的用户
         * 内存消耗：39.1 MB, 在所有 Java 提交中击败了73.52%的用户
         *
         * @param licensePlate
         * @param words
         * @return
         */
        public String shortestCompletingWord(String licensePlate, String[] words) {
            //"密码本"
            int[] dic = new int[26];
            int dicNum = 0;
            //1. 求密码本
            char[] chars = licensePlate.toCharArray();
            for (char aChar : chars) {
                if (aChar >= 'a' && aChar <= 'z') {
                    dic[aChar - 'a']++;
                    dicNum ++;
                } else if (aChar >= 'A' && aChar <= 'Z') {
                    dic[aChar - 'A']++;
                    dicNum ++;
                }
            }
            //2. 开始计算每个word的情况
            int scwLen = 16;//1 <= words[i].length <= 15
            String scw = null;
            int [] tempOccus;
            for (String word : words) {
                char[] toCharArray = word.toCharArray();
                //长度不够，直接跳出
                if (toCharArray.length < dicNum) {
                    continue;
                }
                tempOccus = new int[26];
                for (char c : toCharArray) {
                    if (c >= 'a' && c <= 'z') {
                        tempOccus[c - 'a']++;
                    } else if (c >= 'A' && c <= 'Z') {
                        tempOccus[c - 'A']++;
                    }
                }
                int i ;
                for (i = 0; i < 26; i++) {
                    if (tempOccus[i] < dic[i]) {
                        break;
                    }
                }
                if (i == 26 &&  toCharArray.length < scwLen) {
                    scwLen = toCharArray.length;
                    scw = word;
                }
            }
            return scw;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().shortestCompletingWord("1s3 PSt", new String[] {"step", "steps", "stripe", "stepple"}));//steps
        logger.info("{}", new Solution().shortestCompletingWord("1s3 456", new String[] {"looks", "pest", "stew", "show"}));//pest
        logger.info("{}", new Solution().shortestCompletingWord("Ah71752", new String[] {"suggest","letter","of","husband","easy",
                "education","drug","prevent","writer","old"}));//husband
        logger.info("{}", new Solution().shortestCompletingWord("OgEu755", new String[] {"enough","these","play","wide","wonder",
                "box","arrive","money","tax","thus"}));//enough
        logger.info("{}", new Solution().shortestCompletingWord("iMSlpe4", new String[] {"claim","consumer","student","camera",
                "public","never","wonder","simple","thought","use"}));//simple
    }
}
