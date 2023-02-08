package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/27 16:30
 *
 *
 * 441. 排列硬币
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 *
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * 示例 1:
 *
 * n = 5
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * 因为第三行不完整，所以返回2.
 * 示例 2:
 *
 * n = 8
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * 因为第四行不完整，所以返回3.
 */
public class TestSolution441 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution441.class);


    static class Solution {

        /**
         * 显示详情
         * 执行用时 :8 ms, 在所有 Java 提交中击败了49.80%的用户
         * 内存消耗 :36.8 MB, 在所有 Java 提交中击败了16.67%的用户
         * @param n
         * @return
         */
        public int arrangeCoins(int n) {
            int level = 1;
            while (true) {
                n -= level;
                if (n == 0) {
                    return level ;
                } else if (n < 0) {
                    return level -1;
                }
                level ++;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().arrangeCoins(2147483647));
    }
}
