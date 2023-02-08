package com.roy.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/27
 *
 * 744. 寻找比目标字母大的最小字母
给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。

在比较时，字母是依序循环出现的。举个例子：

如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'


示例：

输入:
letters = ['c', 'f', 'j']
target = 'a'
输出: 'c'

输入:
letters = ['c', 'f', 'j']
target = 'c'
输出: 'f'

输入:
letters = ['c', 'f', 'j']
target = 'd'
输出: 'f'

输入:
letters = ['c', 'f', 'j']
target = 'g'
输出: 'j'

输入:
letters = ['c', 'f', 'j']
target = 'j'
输出: 'c'

输入:
letters = ['c', 'f', 'j']
target = 'k'
输出: 'c'


提示：

letters长度范围在[2, 10000]区间内。
letters 仅由小写字母组成，最少包含两个不同的字母。
目标字母target 是一个小写字母。
 */
public class TestSolution744 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution744.class);


    static class Solution {

        /**
         *
         *
         *
         * 二分查找法
         *
         执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
         内存消耗 :40.1 MB, 在所有 Java 提交中击败了11.11%的用户
         *
         * @param letters
         * @param target
         * @return
         */
        public char nextGreatestLetter(char[] letters, char target) {
            int len = letters.length;
            int p =0 ;
            int q = len -1;
            if (letters[p] > target) {
                return letters[p];
            }
            if (letters[q] <= target) {
                return letters[p];
            }

            while(q != p) {
                int mid = (p +q) /2;
                char midVal = letters[mid];
                if (midVal <= target ) {//mid小于等于目标
                    if (letters[mid+1] > target ) {//下一个大于
                        return letters[mid+1];
                    } else {
                        p = mid;
                    }
                } else{//mid大于等于目标
                    if (letters[mid-1] <= target ) {//上一个小于等于
                        return letters[mid];
                    } else {
                        q = mid;
                    }
                }
            }
            return letters[q];
        }

        /**
         *
         * 朴素的解法
         *
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :39.7 MB, 在所有 Java 提交中击败了11.11%的用户
         *
         *
         * @param letters
         * @param target
         * @return
         */
        public char nextGreatestLetter1(char[] letters, char target) {
            int len = letters.length;
            int p =0 ;
            int q = len -1;
            if (letters[p] > target) {
                return letters[p];
            }
            if (letters[q] <= target) {
                return letters[p];
            }

            for(int i = 0; i< len ; i++) {
                if (letters[i] > target) {
                    return letters[i];
                }
            }
            return letters[0];
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().nextGreatestLetter(new char[]{
                'a','b','c','d','e','f','g','h','j','k','l','m','n','o',
                'p','q','r','s','t','u','v','w','x','y','z'}, 'b'));//c

        logger.info("{}", new Solution().nextGreatestLetter(new char[]{
                'e','e','e','k','q','q','q','v','v','y'}, 'b'));//k

        logger.info("{}", new Solution().nextGreatestLetter(new char[]{
                'c','f','j'}, 'd'));//f
    }
}
