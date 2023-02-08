package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/22
 *
 *
 *849. 到最近的人的最大距离
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 *
 * 至少有一个空座位，且至少有一人坐在座位上。
 *
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 *
 * 返回他到离他最近的人的最大距离。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 *
 * 输入：[1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 *
 *
 * 提示：
 *
 * 2 <= seats.length <= 20000
 * seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
 *
 *
 *
 */
public class TestSolution849 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution849.class);


    static class Solution {

        /**
         *
         * 挺实用的问题，电影院占座问题
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 2 ms, 在所有 Java 提交中击败了99.22%的用户
         * 内存消耗：
         * 41.8 MB, 在所有 Java 提交中击败了11.11%的用户
         *
         *
         * @param seats
         * @return
         */
        public int maxDistToClosest(int[] seats) {
            int size = seats.length;
            int i;
            //找第一个1，一定有的这是前提条件
            for (i = 0; i < size; i++) {
                if (seats[i] == 1) {
                    break;
                }
            }
            //第一个1过半，直接返回
            if (i > size / 2) {
                return i;
            }
            int maxDist = i;

            int start = i;
            while (true) {
                int j = start +1;
                for (; j < size; j++) {
                    if (seats[j] == 1) {
                        break;
                    }
                }
                int dis;
                //超界
                if (j == size) {
                    dis = j - 1 - start;
                    if (dis > maxDist) {
                        maxDist = dis;
                    } else {}
                    return maxDist;
                }

                dis = (j + start) /2 - start;
                if (dis > maxDist) {
                    maxDist = dis;
                }
                start = j;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxDistToClosest(new int[]{0,0,1}));//2
        logger.info("{}", new Solution().maxDistToClosest(new int[]{1,0,0,0,1,0,1}));//2
        logger.info("{}", new Solution().maxDistToClosest(new int[]{1,0,0,0}));//3
    }
}
