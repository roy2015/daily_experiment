package com.roy.miscellaneous.leetcode.stage2.stage20;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/12/02
 *
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 输入"aabcdc"
 * 输出
 * [
 *  ["a","a","b","c","d","c"],
 *  ["a","a","b","cdc"],
 *  ["aa","b","c","d","c"],
 *  ["aa","b","cdc"]
 * ]
 *
 *  提示：回溯算法
 */
public class TestSolution131 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution131.class);


    static class Solution {
        private List<List<String>> storedListList;
        private char[] dic;


        /**
         * 1. 分割成字符数组
         * 2. 从前拼接回文串+递归
         * 3.使用成员变量记录
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：2 ms, 在所有 Java 提交中击败了98.11%的用户
         * 内存消耗：39.6 MB, 在所有 Java 提交中击败了45.94%的用户
         *
         *
         * @param s
         * @return
         */
        public List<List<String>> partition(String s) {
            dic = s.toCharArray();
            storedListList = new ArrayList<>();

            List<String> topList = new ArrayList<>();
            for (int i = 0; i < dic.length; i++) {
                topList.add(String.valueOf(dic[i]));
            }
            storedListList.add(topList);

            doPartition(new ArrayList<>(), 0);
            return storedListList;
        }

        /**
         *
         * 输入"aabcdc"
         * 输出
         * [
         *  ["a","a","b","c","d","c"],
         *  ["a","a","b","cdc"],
         *  ["aa","b","c","d","c"],
         *  ["aa","b","cdc"]
         * ]
         *
         * 递归， preList记录回来的路就可以了，注意copypreList,不要覆盖 preList，
         *
         *
         */
        public void doPartition(List<String> preList, int startIdx) {
            int length = dic.length;
            for (int p = startIdx; p < length -1; p++) {
                for (int q = p + 1; q < length; q++) {
                    boolean flag = isHuiWen(p, q);
                    //是回文,拼p->q这段字符串
                    if (flag) {
                        StringBuffer pqStr = new StringBuffer();
                        for (int i = p; i <= q; i++) {
                            pqStr.append(dic[i]);
                        }
                        List<String> currentList = new ArrayList<>();
                        currentList.addAll(preList);
                        currentList.add(pqStr.toString());
                        for (int i = q + 1; i < length; i++) {
                            currentList.add(String.valueOf(dic[i]));
                        }
                        storedListList.add(currentList);
                        int nextStartIdx = q + 1;
                        if (nextStartIdx < length - 1) {
                            List<String> newPreList = new ArrayList<>();
                            newPreList.addAll(preList);
                            newPreList.add(pqStr.toString());
                            doPartition(newPreList, nextStartIdx);
                        }
                    }
                }
                preList.add(String.valueOf(dic[p]));
            }
        }

        /**
         * 判断p->q 形成的字符串 是否回文
         * @param p
         * @param q
         * @return
         */
        private boolean isHuiWen(int p, int q) {
            while (p < q) {
                if (dic[p] != dic[q]) {
                    return false;
                }
                q --;
                p ++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().partition("aabcdc"));//["a","a","b","c","d","c"],["a","a","b","cdc"],["aa","b","c","d","c"],["aa","b","cdc"]
        logger.info("{}", new Solution().partition("aab"));// [aa b]   [a a b]
        logger.info("{}", new Solution().partition("a"));// [a]

    }
}
