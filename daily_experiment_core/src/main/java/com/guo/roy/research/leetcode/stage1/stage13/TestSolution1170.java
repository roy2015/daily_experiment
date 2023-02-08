package com.guo.roy.research.leetcode.stage1.stage13;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/31
 *
 *1170. 比较字符串最小字母出现频次
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 *
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 *
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 *
 *
 *
 * 示例 1：
 *
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 *
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 *
 *
 * 提示：
 *
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] 都是小写英文字母
 *
 *
 *
 */
public class TestSolution1170 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1170.class);


    static class Solution {

        /**
         *
         *
         * 最后一步比对已经做过优化了，应该还有优化的空间 todo
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 13 ms, 在所有 Java 提交中击败了60.60%的用户
         * 内存消耗：
         * 40.8 MB, 在所有 Java 提交中击败了23.08%的用户
         *
         *
         * @param queries
         * @param words
         * @return
         */
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int[] queryFreq = new int[queries.length];
            int[] wordsFreq = new int[words.length];

            for (int i = 0; i < queries.length; i++) {
                queryFreq[i] = doFunc(queries[i].toCharArray());
            }
            for (int i = 0; i < words.length; i++) {
                wordsFreq[i] = doFunc(words[i].toCharArray());
            }

            //这一段可优化
            int[] retArry = new int[queries.length];
            int k = 0;
            /*for (int query : queryFreq) {
                int count = 0;
                for (int word : wordsFreq) {
                    if (word > query) {
                        count ++;
                    }
                }
                retArry[k++] = count;
            }*/
            Arrays.sort(wordsFreq);
            for (int query : queryFreq) {
                int length = wordsFreq.length;
                int i;
                //提前处理
                if (wordsFreq[0] > query) {
                    retArry[k++] = length;
                    continue;
                } else if (wordsFreq[length -1] <= query) {
                    retArry[k++] = 0;
                    continue;
                } else {}

                for (i = 0; i < length; i++) {
                    int iVal = wordsFreq[i];
                    if (iVal > query) {
                        break;
                    }
                }

                retArry[k++] = length - i;
            }


            return retArry;
        }


        /**
         * 求最小字母出现的次数
         *
         * @param chars
         * @return
         */
        private int doFunc(char[] chars) {
            int[] map = new int[26];
            char minLetter = 'z';
            for (char aChar : chars) {
                if (aChar < minLetter ) {
                    minLetter = aChar;
                }
                map[(aChar - 'a')] ++;
            }
            return map[minLetter - 'a'];
        }

    }

    public static void main(String[] args) {
        logger.info("{}");
        logger.info("{}", new Solution().numSmallerByFrequency(
                new String[]{"cbd"},
                new String[]{"zaaaz"}));//[1]
        logger.info("{}", new Solution().numSmallerByFrequency(
                new String[]{"bbb","cc"},
                new String[]{"a","aa","aaa","aaaa"}));//[1,2]
    }
}






















