package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/11/2
 *
 * 1455. 检查单词是否为句中其他单词的前缀
 * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。
 *
 * 请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
 *
 * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
 * 如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
 * 如果 searchWord 不是任何单词的前缀，则返回 -1 。
 * 字符串 S 的 「前缀」是 S 的任何前导连续子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：sentence = "i love eating burger", searchWord = "burg"
 * 输出：4
 * 解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
 * 示例 2：
 *
 * 输入：sentence = "this problem is an easy problem", searchWord = "pro"
 * 输出：2
 * 解释："pro" 是 "problem" 的前缀，而 "problem" 是句子中第 2 个也是第 6 个单词，但是应该返回最小下标 2 。
 * 示例 3：
 *
 * 输入：sentence = "i am tired", searchWord = "you"
 * 输出：-1
 * 解释："you" 不是句子中任何单词的前缀。
 * 示例 4：
 *
 * 输入：sentence = "i use triple pillow", searchWord = "pill"
 * 输出：4
 * 示例 5：
 *
 * 输入：sentence = "hello from the other side", searchWord = "they"
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= sentence.length <= 100
 * 1 <= searchWord.length <= 10
 * sentence 由小写英文字母和空格组成。
 * searchWord 由小写英文字母组成。
 * 前缀就是紧密附着于词根的语素，中间不能插入其它成分，并且它的位置是固定的——-位于词根之前。（引用自 前缀_百度百科 ）
 *
 */
public class TestSolution1455 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1455.class);


    static class Solution {
        /**
         *
         * 首先有前提条件的  sentence 由小写英文字母和空格组成。searchWord 由小写英文字母组成。
         *
         * 乱写+乱debug就ok了
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.1 MB, 在所有 Java 提交中击败了96.68%的用户
         *
         * @param sentence
         * @param searchWord
         * @return
         */
        public int isPrefixOfWord(String sentence, String searchWord) {
            if (sentence.equals(" ")) {
                return -1;
            }
            int ret = 1;
            char[] sentenceChars = sentence.toCharArray();
            char[] searchWordChars = searchWord.toCharArray();
            int sentenceLen = sentenceChars.length;
            int searchWordLen = searchWordChars.length;
            for (int i = 0; i < sentenceLen; i++) {
                char sentenceCharVal = sentenceChars[i];
                int j =i ;
                if (sentenceCharVal == ' ') {
                    ret ++;
                    j +=1;
                }
                //compare only char
                int k = 0;
                int m = 0;
                boolean valid =true ;
                for (k = 0; k < searchWordLen; k++) {
                    m = j + k;
                    //这个判断还是需要的，当sentence只有一个单词时
                    if (m == sentenceLen) {
                        valid = false;
                        break;
                    }
                    if (searchWordChars[k] != sentenceChars[m]) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    return ret;
                }
                if (m == sentenceLen) {
                    return  -1;
                } else {
                    j = m;
                    while ( j < sentenceLen && sentenceChars[j] != ' ' ) {
                        j++;
                    }
                    if ( j == sentenceLen) {
                        return -1;
                    } else {
                        i = j-1;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isPrefixOfWord(" hellohello hellohellohello", "ell"));//-1
        logger.info("{}", new Solution().isPrefixOfWord(" b", "b"));//2
        logger.info("{}", new Solution().isPrefixOfWord("i love eating burger", "burg"));//4
        logger.info("{}", new Solution().isPrefixOfWord("this problem is an easy problem", "pro"));//2
        logger.info("{}", new Solution().isPrefixOfWord("i am tired", "you"));//-1
        logger.info("{}", new Solution().isPrefixOfWord("i use triple pillow", "pill"));//4
        logger.info("{}", new Solution().isPrefixOfWord("hello from the other side", "they"));//-1


    }
}
