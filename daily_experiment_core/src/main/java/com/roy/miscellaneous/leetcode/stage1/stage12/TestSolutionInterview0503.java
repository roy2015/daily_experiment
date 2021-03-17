package com.roy.miscellaneous.leetcode.stage1.stage12;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/27
 *
 *面试题 05.03. 翻转数位
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 *
 * 示例 1：
 *
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 示例 2：
 *
 * 输入: num = 7(01112)
 * 输出: 4
 *
 */
public class TestSolutionInterview0503 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0503.class);

    static class Solution {


        /**
         *
         * 走的不是与运算哈~
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了18.46%的用户
         * 内存消耗：
         * 36.6 MB, 在所有 Java 提交中击败了24.25%的用户
         *
         * @param num
         * @return
         */
        public int reverseBits(int num) {
            String s = Integer.toBinaryString(num);
            if (s.substring(0,1).equalsIgnoreCase("1")) {
                s = "0" + s;
            }

            char[] chars = s.toCharArray();
            int length = chars.length;

            List<Integer> zeroIdxs = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if (chars[i] == '0') {
                    zeroIdxs.add(i);
                }
            }

            int size_m1 = zeroIdxs.size() -1;
            int max = 0;
            for (int i = 0; i < zeroIdxs.size(); i++) {
                int preIdx ;
                int postIdx;
                if (i == 0) {
                    preIdx = -1;
                } else {
                    preIdx = zeroIdxs.get(i -1);
                }

                if (i < size_m1) {
                   postIdx =  zeroIdxs.get(i + 1);
                } else {
                    postIdx = length;
                }
                Integer iIdx = zeroIdxs.get(i);
                int tmp = (iIdx - preIdx - 1) + 1 + ( postIdx - iIdx - 1 ) ;
                if (tmp > max) {
                    max = tmp;
                }

            }
            return max;

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().reverseBits(7));//8
        logger.info("{}", new Solution().reverseBits(1775));//8

    }
}
