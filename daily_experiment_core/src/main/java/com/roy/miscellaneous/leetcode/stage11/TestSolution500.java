package com.roy.miscellaneous.leetcode.stage11;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author guojun
 * @date 2020/5/15
 * 500. 键盘行
给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。



American keyboard



示例：

输入: ["Hello", "Alaska", "Dad", "Peace"]
输出: ["Alaska", "Dad"]


注意：

你可以重复使用键盘上同一字符。
你可以假设输入的字符串将只包含字母。
 */
public class TestSolution500 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution500.class);


    static class Solution {

        /**
         * 执行结果：
         通过
         显示详情
         执行用时 :1 ms, 在所有 Java 提交中击败了56.69%的用户
         内存消耗 :37.3 MB, 在所有 Java 提交中击败了12.50%的用户
         * @param words
         * @return
         */
        public String[] findWords(String[] words) {

            HashSet<Integer> line1Map = new HashSet<>();
            HashSet<Integer> line2Map = new HashSet<>();
            HashSet<Integer> line3Map = new HashSet<>();
            //qwertyuiop
            line1Map.add((int) 'q');
            line1Map.add((int) 'Q');
            line1Map.add((int)'w');
            line1Map.add((int)'W');
            line1Map.add((int)'e');
            line1Map.add((int)'E');
            line1Map.add((int)'r');
            line1Map.add((int)'R');
            line1Map.add((int)'t');
            line1Map.add((int)'T');
            line1Map.add((int)'y');
            line1Map.add((int)'Y');
            line1Map.add((int)'u');
            line1Map.add((int)'U');
            line1Map.add((int)'i');
            line1Map.add((int)'I');
            line1Map.add((int)'o');
            line1Map.add((int)'O');
            line1Map.add((int)'p');
            line1Map.add((int)'P');
            //asdfghjkl
            line2Map.add((int)'a');
            line2Map.add((int)'A');
            line2Map.add((int)'s');
            line2Map.add((int)'S');
            line2Map.add((int)'d');
            line2Map.add((int)'D');
            line2Map.add((int)'f');
            line2Map.add((int)'F');
            line2Map.add((int)'g');
            line2Map.add((int)'G');
            line2Map.add((int)'h');
            line2Map.add((int)'H');
            line2Map.add((int)'j');
            line2Map.add((int)'J');
            line2Map.add((int)'k');
            line2Map.add((int)'K');
            line2Map.add((int)'l');
            line2Map.add((int)'L');
            //zxcvbnm
            line3Map.add((int)'z');
            line3Map.add((int)'Z');
            line3Map.add((int)'x');
            line3Map.add((int)'X');
            line3Map.add((int)'c');
            line3Map.add((int)'C');
            line3Map.add((int)'v');
            line3Map.add((int)'V');
            line3Map.add((int)'b');
            line3Map.add((int)'B');
            line3Map.add((int)'n');
            line3Map.add((int)'N');
            line3Map.add((int)'m');
            line3Map.add((int)'M');
            int k =0;
            String[] retStrArry = new String[words.length];
            for (String word : words) {
                char[] chars = word.toCharArray();
                HashSet<Integer> usedMap =null;
                int i =0;
                int curLen = chars.length;
                for (i = 0; i < curLen; i++) {
                    char aChar = chars[i];
                    if (usedMap == null) {
                        if (line1Map.contains((int)aChar)) {
                            usedMap = line1Map;
                        } else if (line2Map.contains((int)aChar)) {
                            usedMap = line2Map;
                        } else {
                            usedMap = line3Map;
                        }
                    } else {
                        if (!usedMap.contains((int)aChar)) {
                            break;
                        }
                    }
                }
                if (i == curLen) {
                    retStrArry[k ++] =  word;
                }
            }
            return Arrays.copyOf(retStrArry,  k );
        }
    }

    public static void main(String[] args) {
        String[] words = new Solution().findWords(new String[]{
                "Hello", "Alaska", "Dad", "Peace"
        });
        logger.info("{}", words);
    }
}
