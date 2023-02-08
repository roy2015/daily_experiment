package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/27 10:19
 *
 * 717. 1比特与2比特字符
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 *
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * 示例 1:
 *
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 * 示例 2:
 *
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 * 注意:
 *
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或 1.
 */
public class TestSolution717 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution717.class);


    static class Solution {
        /**
         * 执行结果：通过显示详情
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :39.1 MB, 在所有 Java 提交中击败了20.00%的用户
         *
         * @param bits
         * @return
         */
        public boolean isOneBitCharacter(int[] bits) {
            int length = bits.length;
            int step;
            for (int i = 0; i < length; i += step) {
                if (bits[i] == 1) {
                    if ( i + 2 == length) {
                        return false;
                    } else {
                        step =2;
                    }
                } else {
                    step =1;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isOneBitCharacter(new int[] {1,1,0,1,0}));//false
        logger.info("{}", new Solution().isOneBitCharacter(new int[] {1, 0, 0}));//true
        logger.info("{}", new Solution().isOneBitCharacter(new int[] {1, 1, 1, 0}));//false
    }
}
