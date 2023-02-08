package com.roy.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/10.
 *给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

 注意你不能在买入股票前卖出股票。

 示例 1:

 输入: [7,1,5,3,6,4]
 输出: 5
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 示例 2:

 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution121 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution121.class);

    /**
     */
    static class Solution {
        /**
         *
         *思路：
         * 1. O(i) 找一个上升路(第一个底)
         * 2. O(n-i) 不停更新底和利润
         *
         * 这样时间复杂度 也是O(n), O(i) + O(n-i) = O(n)
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了99.98%的用户
         内存消耗 :37.7 MB, 在所有 java 提交中击败了65.41%的用户
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length ==0 ) {
                return 0;
            }
            //找第一个底（即上升线）
            int min = -1 , max = -1 ;
            for (int i = 0; i < prices.length -1; i++) {
                if (prices[i] < prices[i + 1]) {
                    min = i;
                    max = i + 1;
                    break;
                }
            }
            if (min == -1) {
                return 0;
            }

            int profit = prices[max] - prices[min];
            for (int i = max + 1; i < prices.length; i++) {
                int tmpPrice = prices[i];
                if (tmpPrice < prices[min]) {//更新底
                    min = i;
                    continue;
                } else {
                    int tmpProfit = tmpPrice - prices[min];
                    if (tmpProfit > profit) {
                        profit = tmpProfit;
                    }
                }
            }
            return profit;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxProfit(new int[]{
                3,3,5,0,0,3,1,4
        }));
    }

}
