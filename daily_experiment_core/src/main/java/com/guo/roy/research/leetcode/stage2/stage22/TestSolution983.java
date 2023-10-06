package com.guo.roy.research.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

import java.util.BitSet;
import java.util.HashMap;

/**
 * @author guojun
 * @date 2020/8/12
 *
 *
 * 983. 最低票价
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 *
 * 火车票有三种不同的销售方式：
 *
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 *
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 *
 *
 *
 * 示例 1：
 *
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 * 示例 2：
 *
 * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * 输出：17
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
 * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
 * 你总共花了 $17，并完成了你计划的每一天旅行。
 *
 *
 * 提示：
 *
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days 按顺序严格递增
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 */
public class TestSolution983 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution983.class);


    static class Solution {
        /**
         *
         *
         * 动态规划
         * 参考思路，然后自己完成代码
         * https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/java-dong-tai-gui-hua-si-lu-bu-zou-cong-hou-xiang-/
         * 从后往前的思路， 依次计算第i天到结束的费用dp[i], 反推到dp[1]
         *
         * 这题是 前面依赖后面，和一般dp后面依赖前面不一样
         * "上述思路显而易见，最关键在于：「今天买多少，得看后几天怎么安排」，即「前面依赖后面」——从后向前来买。"
         *
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 98.74%
         * 的用户
         * 内存消耗：
         * 37.6 MB
         * , 在所有 Java 提交中击败了
         * 63.63%
         * 的用户
         *
         * @param days
         * @param costs
         * @return
         */
        public int mincostTickets (int[] days, int[] costs) {
            int len = days.length;
            int maxDay = days[len -1];
            int minDay = days[0];
            int[] dp = new int[maxDay + 31];//31: 0占位 + 30个冗余防止超界

            int d ;
            int i;
            for (i = len -1, d= maxDay; d >=minDay ; d--) {
                if (d == days[i]) {
                    dp[d] = Math.min(costs[0] + dp[d + 1], costs[1] + dp[d + 7]);
                    dp[d] = Math.min(dp[d], costs[2] + dp[d + 30]);
                    i --;
                } else {
                    dp[d] = dp[d + 1];
                }
            }
            return dp[minDay];
        }

        /**
         *
         * 从前往后dp，和上面的相反
         * dp[i]表示旅游到i天需要的最少票价
         * @param days
         * @param costs
         * @return
         */
        public int mincostTickets20230923 (int[] days, int[] costs) {
            int[] dp = new int[days.length + 1];

            BitSet bitSet = new BitSet(365);
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            hashMap.put(0,0);
            for (int i = 0; i < days.length; i++) {
                bitSet.set(days[i]);
                hashMap.put(days[i],i +1);
            }

            for (int i = 1; i < dp.length; i++) {
                int day = days[i-1];
                int oneDay, weekDay,monthDay;
                oneDay = dp[findNearestSmallEl(bitSet, day, hashMap)] + costs[0];//一天
                if ((day - 6) < 0) {
                    weekDay = dp[0] + costs[1];
                } else {
                    weekDay = dp[findNearestSmallEl(bitSet, day - 6, hashMap)] + costs[1];
                }

                if ((day - 29) < 0) {
                    monthDay = dp[0] + costs[2];
                } else {
                    monthDay = dp[findNearestSmallEl(bitSet, day - 29, hashMap)] + costs[2];
                }
                dp[i] = Math.min(Math.min(oneDay,weekDay), monthDay);
            }
            return dp[days.length];

        }

        //返回最近的小于target且存在在bitset里的元素
        public int findNearestSmallEl(BitSet bitSet, int target, HashMap<Integer,Integer> map) {
            if (target <= 1) {
                return 0;
            }
            for (int i = target -1; i > 0 ; i--) {
                if (bitSet.get(i)) {
                    return map.get(i);
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().mincostTickets20230923(
                new int[]{6,8,9,18,20,21,23,25},
                new  int[]{2,10,41}));//16

        logger.info("{}", new Solution().mincostTickets20230923(
                new int[]{1,4,6,7,8,20},
                new  int[]{2,7,15}));//11

        logger.info("{}", new Solution().mincostTickets20230923(
                new int[]{1,2,3,4,5,6,7,8,9,10,30,31},
                new  int[]{2,7,15}));//17
    }
}
