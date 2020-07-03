package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/3
 *
 *
 * 374. 猜数字大小
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 *
 *
 * 示例 :
 *
 * 输入: n = 10, pick = 6
 * 输出: 6
 *
 */
public class TestSolution374 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution374.class);

    public static class GuessGame {
        /**
         * 底牌
         */
        private int num;
        GuessGame (int num) {
            this.num = num;
        }

        /**
         * Forward declaration of guess API.
         * @param  num   your guess
         * @return 	     -1 : 我的数字比较小
         *			      1 : 我的数字比较大
         *               0 : 恭喜！你猜对了！
         *
         *
         *
         *
         **/
        protected int guess(int num) {
            if (this.num < num) {
                return -1;
            } else if (this.num > num ) {
                return 1;
            } else {
                return 0;
            }
        }
    }


    static class Solution extends GuessGame {
        Solution(int num) {
            super(num);
        }

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 36.6 MB, 在所有 Java 提交中击败了10.00%的用户
         *
         * @param n 数字范围
         * @return
         */
        public int guessNumber(int n) {
            int low = 1, high = n;
            while (low <= high) {
                int mid = (int) (((long)low + (long)high) /2);
                if (guess(mid) == 1) {
                    low = mid +1;
                } else if (guess(mid) == -1) {
                    high = mid -1;
                } else {
                    return mid;
                }
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution(6).guessNumber(10));
    }
}
