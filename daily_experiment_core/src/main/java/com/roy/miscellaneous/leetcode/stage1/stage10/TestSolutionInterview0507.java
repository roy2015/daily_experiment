package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/28
 *
 *
 * 面试题 05.07. 配对交换
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 *
 * 示例1:
 *
 *  输入：num = 2（或者0b10）
 *  输出 1 (或者 0b01)
 * 示例2:
 *
 *  输入：num = 3
 *  输出：3
 * 提示:
 *
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 *
 *
 *
 */
public class TestSolutionInterview0507 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0507.class);

    static class Solution {
        /**
         *
         * 思考半小时的思路：  每次右移两位求互换操作的值，根据基数累加即可， 有前提条件"um的范围
         *  在[0, 2^30 - 1]之间"，所以只需要移动15次（30/2）
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.5 MB, 在所有 Java 提交中击败了34.54%的用户
         *
         * num的范围在[0, 2^30 - 1]之间
         *
         * @param num
         * @return
         */
        public int exchangeBits(int num) {
            int base = 1;//基数
            int retSum = 0;
            for (int i = 0; i < 15; i++) {//15 ?
                int low2Bit = ( num & 0x3 );
                int tmpSum = 0;
                switch (low2Bit) {
                    case 0:
                        tmpSum = 0;
                        break;
                    case 1:
                        tmpSum = 2;
                        break;
                    case 2:
                        tmpSum = 1;
                        break;
                    case 3:
                        tmpSum = 3;
                        break;
                }
                tmpSum = tmpSum * base;
                retSum += tmpSum;
                base = base << 2;
                num = num >> 2;
            }
            return retSum;
        }

        /**
         *  借鉴的思路比较巧妙，直接一次性求奇数位和偶数位，再错位拼接起来
         *
         *  执行结果：
         *  通过
         *  显示详情
         *  执行用时：0 ms,
         *  在所有 Java
         *  提交中击败了100.00%的用户
         *  内存消耗：36.5 MB,
         *  在所有 Java
         *  提交中击败了34.54%的用户
         * @param num
         * @return
         */
        public int exchangeBits1(int num) {
            int jiPadding = 0x15555555;
            int ouPadding = 0x2AAAAAAA;
            return (num & jiPadding) << 1 | (num & ouPadding) >> 1;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().exchangeBits1(3));//3
        logger.info("{}", new Solution().exchangeBits1(13));//14
        logger.info("{}", new Solution().exchangeBits1(2));//1

    }
}
