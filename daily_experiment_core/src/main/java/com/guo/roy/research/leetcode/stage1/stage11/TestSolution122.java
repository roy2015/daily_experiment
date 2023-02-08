package com.guo.roy.research.leetcode.stage1.stage11;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/28 16:32
 *
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 *
 *
 *
 */
public class TestSolution122 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution122.class);


    static class Solution {

        /**
         *
         * 执行结果：
         通过显示详情
         执行用时 :1 ms, 在所有 Java 提交中击败了99.05%的用户
         内存消耗 :39.3 MB, 在所有 Java 提交中击败了6.25%的用户
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            int sumProfit =0;
            int profit =0;
            int length = prices.length;

            int k =0;
            for (;;) {
                Map<Integer, Integer> map = getSegmentProfitInfo(k, prices, length);
                k = map.get(1);
                profit = map.get(2);
                sumProfit += profit;

                if (k >= length -1) {
                    return sumProfit;
                }
            }
        }

        /**
         *
         * 返回最高点和这段的利润
         *
         * 处理过程
         * 1. 找最低点
         * 2. 返回最高点
         * @param start  开始点
         * @param prices
         * @return
         */
        public Map<Integer, Integer> getSegmentProfitInfo(int start, int[] prices , int len) {
            HashMap<Integer, Integer> retMap = new HashMap<>();

            int i ;
            boolean startPointFlag =false;
            for (i = start ; i< len -1 ;i ++) {
                if (prices[i + 1] > prices[i]) {
                    startPointFlag = true;
                    break;
                }
            }

            if (!startPointFlag ) {
                retMap.put(1, len -1);
                retMap.put(2, 0);
                return retMap;

            }

            int p =0 ,q;
            if (startPointFlag ) {
                p = i;
            }

            boolean endPointFlag =false;
            for (i = p ; i< len -1 ;i ++) {
                if (prices[i + 1] < prices[i]) {
                    endPointFlag = true;
                    break;
                }
            }

            if (!endPointFlag && i == p ) {

                retMap.put(1, len -1);
                retMap.put(2, 0);
                return retMap;
            } else {
                retMap.put(1, i +1);
                retMap.put(2, prices[i] - prices[p]);
            }


            return retMap;
        }


    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxProfit(new int[]{1,2,3,4,5}));//4
        logger.info("{}", new Solution().maxProfit(new int[]{7,6,4,3,1}));//0
        logger.info("{}", new Solution().maxProfit(new int[]{7,1,5,3,6,4}));//7

    }
}
