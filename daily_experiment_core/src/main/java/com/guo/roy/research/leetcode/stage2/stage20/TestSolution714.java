package com.guo.roy.research.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/12/16
 *
 *
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 *
 *
 *  -1 1   0 0
 *  -3 3 -1 1  -3 3   0 0
 *  -5 2
 *
 *
 */
public class TestSolution714 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution714.class);


    static class Solution {
        /**
         *
         * 鬼知道我是用一天是怎么想出来的
         * 1. 明确一点：同一天卖出买入 or 买入卖出是不明智的选择，所以买入买出是分开在不用的天
         * 2. 算出当天持有和非持有状态下的最大利润（多个值没意义，肯定不是最终的最大利润，所以只求最大），带入下一天，
         *    继续动态计算
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：4 ms, 在所有 Java 提交中击败了99.77%的用户
         * 内存消耗：47.8 MB, 在所有 Java 提交中击败了53.43%的用户
         *
         * @param prices
         * @param fee
         * @return
         */
        public int maxProfit(int[] prices, int fee) {
            int length = prices.length;
            if (length == 1) {
                return 0;
            }

            int holdProfit = -prices[0];
            int noHoldProfit = 0;

            for (int i = 1; i < length; i++) {
                int todayPrice = prices[i];
                //hold
                //sale
                int noHoldAfterSale = holdProfit + todayPrice - fee;
                //keep peace
                int holdKeep = holdProfit;

                //noHold
                //purchase
                int holdPurchase = noHoldProfit - todayPrice;
                //keep peace
                int noHoldKeep = noHoldProfit;

                holdProfit = Math.max(holdKeep, holdPurchase);
                noHoldProfit = Math.max(noHoldAfterSale, noHoldKeep);
            }
            return Math.max(holdProfit, noHoldProfit);
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));//8
    }
}
