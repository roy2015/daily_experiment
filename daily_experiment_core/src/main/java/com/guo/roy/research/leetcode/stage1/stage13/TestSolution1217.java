package com.guo.roy.research.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/10
 *
 *
 * 1217. 玩筹码
 * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
 *
 * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 *
 * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 *
 * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 *
 *
 *
 * 示例 1：
 *
 * 输入：chips = [1,2,3]
 * 输出：1
 * 解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。
 * 示例 2：
 *
 * 输入：chips = [2,2,2,3,3]
 * 输出：2
 * 解释：第四和第五个筹码移动到位置二的代价都是 1，所以最小总代价为 2。
 *
 *
 * 提示：
 *
 * 1 <= chips.length <= 100
 * 1 <= chips[i] <= 10^9
 *
 */
public class TestSolution1217 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1217.class);


    static class Solution {

        /**
         *
         *
         * 直接透过现象简化问题，和a（chips[0]即可）比较把所有元素分为两堆，偶数差和奇数差， 奇数差个数为0则返回0，否则返回小的堆
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.2 MB, 在所有 Java 提交中击败了75.41%的用户
         *
         * @param chips
         * @return
         */
        public int minCostToMoveChips(int[] chips) {
            if (chips.length == 0) {
                return 0;
            }
            int len = chips.length;
            int evenCnt=0,oddCnt;//偶数个数，奇数个数
            int target = chips[0];
            for(int i = 0; i < len; i++) {
                if(((chips[i] - target) & 0x1) == 0) {
                    evenCnt ++;
                }
            }

            oddCnt = len - evenCnt;
            return Math.min(oddCnt, evenCnt);
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().minCostToMoveChips(new int[]{2,3,3}));//1
        logger.info("{}", new Solution().minCostToMoveChips(new int[]{2,2,2,3,3}));//2
        logger.info("{}", new Solution().minCostToMoveChips(new int[]{1,2,3}));//1



    }
}
