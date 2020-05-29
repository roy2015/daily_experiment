package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/15 10:40
 *
 * LCP 01. 猜数字
小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？



输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。



示例 1：

输入：guess = [1,2,3], answer = [1,2,3]
输出：3
解释：小A 每次都猜对了。


示例 2：

输入：guess = [2,2,3], answer = [3,2,1]
输出：1
解释：小A 只猜对了第二次。


限制：

guess的长度 = 3
answer的长度 = 3
guess的元素取值为 {1, 2, 3} 之一。
answer的元素取值为 {1, 2, 3} 之一。
 */
public class TestSolutionLcp01 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionLcp01.class);


    static class Solution {
        /**
         * 执行结果：
         通过
         显示详情
         执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :36.8 MB, 在所有 Java 提交中击败了5.88%的用户
         * @param guess
         * @param answer
         * @return
         */
        public int game(int[] guess, int[] answer) {
            int guessed = 0;
            for(int i =0;i< 3; i++) {
                if (guess[i] == answer[i]) {
                    guessed ++;
                }
            }
            return guessed;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().game(
                new int[]{1,2,3},
                new int[]{3,2,1}
        ));
    }
}
