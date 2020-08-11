package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/18 10:40
 *
 * 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 */
public class TestSolutionInterview46 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview46.class);


    static class Solution {


        /**
         *
         * 就是个递归而已，主要是细节， 0和大于25的处理
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :
         * 36.6 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param num
         * @return
         */
        public int translateNum(int num) {
            String s = String.valueOf(num);
            int length = s.length();
            return translateNumSub(0, s, length);
        }
        private int translateNumSub(int idx, String numStr, int len) {
            if (idx >= len -1) {
                return 1;
            }

            String idx1 = numStr.substring(idx, idx + 1);
            String idx12 = numStr.substring(idx, idx + 2);
            if (idx1.equals("0") || idx12.compareTo("25") > 0) {
                return translateNumSub(idx + 1, numStr, len);
            } else {
                return translateNumSub(idx + 1, numStr, len) + translateNumSub(idx + 2, numStr, len);
            }
        }

    }

    public static void main(String[] args) {
        logger.info(" {}", new Solution().translateNum(1111));//1
        logger.info(" {}", new Solution().translateNum(506));//1
        logger.info(" {}", new Solution().translateNum(1));//1
        logger.info(" {}", new Solution().translateNum(12));//1
        logger.info(" {}", new Solution().translateNum(12258));//5
    }
}
