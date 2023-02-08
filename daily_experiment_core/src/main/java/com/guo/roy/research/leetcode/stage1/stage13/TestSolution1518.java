package com.guo.roy.research.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/21
 *
 * 1518. 换酒问题
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 *
 * 请你计算 最多 能喝到多少瓶酒。
 *
 */
public class TestSolution1518 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1518.class);


    static class Solution {
        /**
         *
         * 双百
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 36.2 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param numBottles
         * @param numExchange
         * @return
         */
        public int numWaterBottles(int numBottles, int numExchange) {
            int fullBottlesNum = numBottles;//有酒的瓶子
            int emptyBottlesNum = 0;//空瓶子
            int sumDrink = 0;

            while ( (numExchange * fullBottlesNum + emptyBottlesNum) / numExchange != 0 ) {
                //喝
                sumDrink += fullBottlesNum;
                emptyBottlesNum += fullBottlesNum;
                //换
                fullBottlesNum = emptyBottlesNum / numExchange;
                emptyBottlesNum = emptyBottlesNum % numExchange;
            }
            return sumDrink;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().numWaterBottles(9,3));
        logger.info("{}", new Solution().numWaterBottles(15,4));
        logger.info("{}", new Solution().numWaterBottles(5,5));
        logger.info("{}", new Solution().numWaterBottles(2,3));
    }
}
