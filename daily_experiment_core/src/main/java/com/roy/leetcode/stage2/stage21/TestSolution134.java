package com.roy.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/30
 *
 *
 * 134. 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明:
 *
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例 1:
 *
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * 输出: 3
 *
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 *
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 *
 * 输出: -1
 *
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 *
 *
 */
public class TestSolution134 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution134.class);


    static class Solution {

        /**
         *
         * 借鉴了官方的一点点思路，但没有看人家的源代码，自己想的实现，
         * 关键点：
         *   1）怎么找下一个出发站点，包括两种情况：
         *      1. 刚开始找第一个可出发的站点
         *      2. 从可出发的站点出发，走下去最后发现走不下去了，怎么找下一个出发站点（此处也有一种弯路设计）
         *   2）要考虑到这是一个闭环
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了
         * 42.28%的用户
         * 内存消耗：39.3 MB,
         * 在所有 Java 提交中击败了
         * 18.46%的用户
         *
         * @param gas
         * @param cost
         * @return
         */
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int len = gas.length;
            //便于理解，造这么一个数组：从当前站点出发到下一站点后剩余油量
            for (int i = 0; i < cost.length; i++) {
                cost[i] = gas[i] - cost[i];
            }
            int leftOil = 0;
            int i = 0;
            int retIdx = 0;
            for (; retIdx <len;) {
                // "此站油出发无法到下一站"并且"加上历史剩余的油也无法到下一站"，则跳到下一个加油站重新选择出发站
                if ( cost[i] < 0 && (leftOil + cost[i]) < 0) {
                    int nexIdx = (i +1) % len;
                    if (nexIdx <= retIdx) {
                        retIdx ++;
                        i = retIdx;
                        leftOil = 0;
                        continue;
                    } else retIdx = (i +1) % len;
                    leftOil = 0;
                } else {//油足够，判断检验结果的idx是不是到了出发站，等于是走了一圈
                    leftOil += cost[i];
                    if ((i == retIdx -1 || i == retIdx + len -1 ) && leftOil >= 0) {
                        return retIdx;
                    }
                }
                i = (i+1) % len;
            }
            return -1;
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().canCompleteCircuit(new
                int[]{3,1,1}, new int[]{1,2,2}));//0

        logger.info("{}", new Solution().canCompleteCircuit(new
                int[]{4,5,2,6,5,3}, new int[]{3,2,7,3,2,9}));//-1

        logger.info("{}", new Solution().canCompleteCircuit(new
                int[]{3,3,4}, new int[]{3,4,4}));//-1

        logger.info("{}", new Solution().canCompleteCircuit(new
                int[]{1,4,2,3,5}, new int[]{3,1,4,5,2}));//4

        logger.info("{}", new Solution().canCompleteCircuit(new
            int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));//3
    }
}
