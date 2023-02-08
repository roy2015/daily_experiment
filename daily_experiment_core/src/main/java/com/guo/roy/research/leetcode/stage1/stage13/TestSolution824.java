package com.guo.roy.research.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/31
 *
 *
 * 824. 山羊拉丁文
 * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 *
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 *
 * 山羊拉丁文的规则如下：
 *
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * 例如，单词"apple"变为"applema"。
 *
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 *
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 * 返回将 S 转换为山羊拉丁文后的句子。
 *
 * 示例 1:
 *
 * 输入: "I speak Goat Latin"
 * 输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * 示例 2:
 *
 * 输入: "The quick brown fox jumped over the lazy dog"
 * 输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * 说明:
 *
 * S 中仅包含大小写字母和空格。单词间有且仅有一个空格。
 * 1 <= S.length <= 150。
 *
 *
 *
 */
public class TestSolution824 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution824.class);


    static class Solution {

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 38.4 MB, 在所有 Java 提交中击败了63.64%的用户
         *
         * @param S
         * @return
         */
        public String toGoatLatin(String S) {
            StringBuilder retSb = new StringBuilder();
            StringBuilder singleWordSb;
            int start = 0;
            char[] chars = S.toCharArray();
            int len = chars.length;
            //找第一个非空格
            while (start < len && chars[start] == ' ') {
                start ++;
            }
            if (start == len) {
                return null;
            }

            char aChar = chars[start];

            int sort = 1;
            //start
            int p = start;
            int q;
            while (p < len) {
                singleWordSb = new StringBuilder();
                q = p +1;
                //找单词的结束（第一个空格）
                while (q < len && (chars[q] != ' ')) {
                    q ++;
                }

                char pChar = chars[p];
                if (isYuanYin(pChar)) {
                    //处理元音字母
                    singleWordSb.append(new String(chars, p, q - p)).append("ma");
                } else {
                    //处理元音字母
                    singleWordSb.append(new String(chars, p + 1, q - p -1)).append(chars[p]).append("ma");
                }
                //结尾加a
                doExraInfo(singleWordSb, sort);
                retSb.append(singleWordSb.toString());

                if (q == len) {
                    //处理多余的一个空格
                    return retSb.delete(retSb.length() -1, retSb.length()).toString();
                }

                p = q + 1;
                sort ++;

            }
            return retSb.toString();
        }

        private void doExraInfo(StringBuilder sb, int times) {
            for (int i = 0; i < times; i++) {
                sb.append("a");
            }
            sb.append(" ");
        }

        private boolean isYuanYin(char ch) {
            boolean ret;
            switch (ch) {//a, e, i, o, u
                case 'a':
                    ret = true;
                    break;
                case 'A':
                    ret = true;
                    break;
                case 'e':
                    ret = true;
                    break;
                case 'E':
                    ret = true;
                    break;
                case 'i':
                    ret = true;
                    break;
                case 'I':
                    ret = true;
                    break;
                case 'o':
                    ret = true;
                    break;
                case 'O':
                    ret = true;
                    break;
                case 'u':
                    ret = true;
                    break;
                case 'U':
                    ret = true;
                    break;
                default:
                    ret = false;
                    break;
            }
            return ret;
        }

    }

    public static void main(String[] args) {
        logger.info("%{}%", new Solution().toGoatLatin("I speak Goat Latin"));//Imaa peaksmaaa oatGmaaaa atinLmaaaaa
    }
}
