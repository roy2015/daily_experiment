package com.roy.miscellaneous.leetcode.stage11;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author guojun
 * @date 2020/5/14
 *
 * 383. 赎金信
给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。

(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)



注意：

你可以假设两个字符串均只含有小写字母。

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */
public class TestSolution383 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution383.class);


    static class Solution {

        /**
         *
         * 先排序
         *
         * 执行结果：通过
         显示详情
         执行用时 :7 ms, 在所有 Java 提交中击败了41.37%的用户
         内存消耗 :40 MB, 在所有 Java 提交中击败了8.33%的用户
         *
         * @param ransomNote
         * @param magazine
         * @return
         */
        public boolean canConstruct(String ransomNote, String magazine) {
            if (magazine.length() == 0) {
                if (ransomNote.length() == 0) {
                    return true;
                } else return false;
            }
            if (ransomNote.length() == 0) {
                return true;
            }
            char[] pArry = ransomNote.toCharArray();
            char[] qArry = magazine.toCharArray();

            int pLen = pArry.length;
            int qLen = qArry.length;
            if (qLen < pLen) {//q的长度不够
                return false;
            }
            Arrays.sort(pArry);
            Arrays.sort(qArry);

            //start
            int p = 0, q = 0;
            while (p < pLen && q < qLen) {
                //step1 找相同的元素
                char pcha = pArry[p];
                while (q < qLen && qArry[q] != pcha) {
                    q++ ;
                }
                if (q == qLen) {
                    return false;
                }
                //step2 然后判断如果p+1和p元素不同，q要继续挪动到下一个不同的元素
                if (p == pLen -1) {
                    return true;
                }
                char pNextcha = pArry[p +1];
                if (pNextcha != pcha) {
                    while (q < qLen && qArry[q] == pcha) {
                        q++ ;
                    }
                    if (q == qLen) {
                        return false;
                    }
                } else {//p中下一个元素和当前相同
                    q ++;
                }
                p ++;
            }
            return p == pLen;
        }

        /**
         *
         * bitSet
         *
         * 执行结果：通过
         * 显示详情
         执行用时 :8 ms, 在所有 Java 提交中击败了38.69%的用户
         内存消耗 :
         40 MB, 在所有 Java 提交中击败了8.33%的用户
         * @param ransomNote
         * @param magazine
         * @return
         */
        public boolean canConstruct1(String ransomNote, String magazine) {
            if (magazine.length() == 0) {
                if (ransomNote.length() == 0) {
                    return true;
                } else return false;
            }
            if (ransomNote.length() == 0) {
                return true;
            }
            char[] pArry = ransomNote.toCharArray();
            char[] qArry = magazine.toCharArray();

            int pLen = pArry.length;
            int qLen = qArry.length;
            if (qLen < pLen) {//q的长度不够
                return false;
            }

            BitSet bitSet = new BitSet(qLen);
            for (int i = 0; i < pLen; i++) {
                char pcha = pArry[i];
                int i1 =0;
                for (; i1 < qLen; i1++) {
                    if (qArry[i1] == pcha && !bitSet.get(i1)) {
                        bitSet.set(i1);
                        break;
                    }
                }
                if (i1 == qLen) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().canConstruct1("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }
}
