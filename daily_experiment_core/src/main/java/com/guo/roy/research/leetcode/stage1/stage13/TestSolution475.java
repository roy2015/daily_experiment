package com.guo.roy.research.leetcode.stage1.stage13;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/30
 *
 *
 * 475. 供暖器
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 *
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 *
 * 说明:
 *
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 示例 1:
 *
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 *
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 *
 *
 *
 */
public class TestSolution475 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution475.class);


    static class Solution {

        /**
         *
         * 算法思想： 找每个房屋最近的取暖器，然后求最大值， 找房屋最近的取暖器是个二分查找
         *  借鉴了题解，主要这个题目描述比较模糊，房屋是乱的，取暖器也是乱了，走了好多弯路
         *
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 20 ms, 在所有 Java 提交中击败了40.07%的用户
         * 内存消耗：
         * 43.3 MB, 在所有 Java 提交中击败了20.00%的用户
         *
         *
         * @param houses
         * @param heaters
         * @return
         */
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(heaters);
            int minRadius = 0;
            for (int house : houses) {
                int tempRadius = findNearestHeater(house, heaters);
                if (tempRadius > minRadius) {
                    minRadius = tempRadius;
                }
            }
            return minRadius;
        }

        /**
         *
         *二分查找和目标值差值最小的元素
         * @param house
         * @param sortedHeaters
         * @return 返回差值
         */
        public int findNearestHeater(int house, int[] sortedHeaters) {
            int length = sortedHeaters.length;
            int low = 0; int high = length -1 ;
            while (low <= high) {
                int mid = (low + high) /2;
                int midVal = sortedHeaters[mid];
                if (midVal == house) {
                    return 0;
                } else if (house > midVal) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            //超界判断
            if (low == length) {
                low = length -1;
            }

            if (high == -1) {
                high = 0;
            }

            int lowVal = sortedHeaters[low];
            int highVal = sortedHeaters[high];
            int lowGap = Math.abs(lowVal - house);
            int highGap = Math.abs(highVal - house);
            return Math.min(lowGap, highGap);
        }
    }

    public static void main(String[] args) {

        /**
         * 测试增强版二分查找
         */
        /*logger.info("{}", new Solution().findNearestHeater(1, new int[]{2, 3,4 ,7}));
        logger.info("{}", new Solution().findNearestHeater(8, new int[]{2, 3,4 ,7}));
        logger.info("{}", new Solution().findNearestHeater(2, new int[]{2, 3,4 ,7}));
        logger.info("{}", new Solution().findNearestHeater(3, new int[]{2, 3,4 ,7}));*/

        logger.info("{}", new Solution().findRadius(
                new int[]{1},
                new int[]{1,2, 3, 4}));//0

        logger.info("{}", new Solution().findRadius(
                new int[]{1,2,3,4},
                new int[]{1,4}));//1
        logger.info("{}", new Solution().findRadius(
                new int[]{1,5},
                new int[]{2}));//3

        logger.info("{}", new Solution().findRadius(
                new int[]{1,2,3,4,5},
                new int[]{2}));//3

        logger.info("{}", new Solution().findRadius(
                new int[]{1,2,3},
                new int[]{1,2}));//1

    }
}
