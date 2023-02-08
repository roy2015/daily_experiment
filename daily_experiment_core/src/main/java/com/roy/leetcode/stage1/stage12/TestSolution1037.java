package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/23
 *
 * 1037. 有效的回旋镖
 * 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
 *
 * 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[1,1],[2,3],[3,2]]
 * 输出：true
 * 示例 2：
 *
 * 输入：[[1,1],[2,2],[3,3]]
 * 输出：false
 *
 *
 * 提示：
 *
 * points.length == 3
 * points[i].length == 2
 * 0 <= points[i][j] <= 100
 */
public class TestSolution1037 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1037.class);


    /**
     * 判断三点共线
     */
    static class Solution {
        /**
         *
         * 几何问题，直接可以写出函数 f(x)= ax +b，为了避免求b出现除不尽，方程两边乘以除数 c * f(x) = ax + b;  a= p1y- p2y,
         * c = p1x-p0x,求出b , 最后代入方程， 验证第三个点
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37.5 MB, 在所有 Java 提交中击败了50.00%的用户
         *
         * @param points
         * @return
         */
        public boolean isBoomerang(int[][] points) {
            int p0x, p0y, p1x, p1y, p2x, p2y;
            p0x = points[0][0];
            p0y = points[0][1];
            p1x = points[1][0];
            p1y = points[1][1];
            p2x = points[2][0];
            p2y = points[2][1];

            //重合
            if (p0x == p1x && p0y == p1y) {
                return false;
            }

            if (p0x == p2x && p0y == p2y) {
                return false;
            }

            if (p1x == p2x && p1y == p2y) {
                return false;
            }

            int fx;
            if (p0x == p1x) {
                return p2x != p0x;
            }
            if (p0y == p1y) {
                return p2y != p0y;
            }

            //排除了特殊情况后进入正题， 计算 cY = aX + b
            int a,b,c;
            a = p1y - p0y;
            c = p1x - p0x;
            b = c * p0y - a * p0x;

            int expectP2y;
            expectP2y = a * p2x + b;
            return expectP2y != c * p2y;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isBoomerang(new int[][]{
                {0,0},
                {0,2},
                {2,1}
        }));

        logger.info("{}", new Solution().isBoomerang(new int[][]{
                {1,1},{2,3},{3,2}
        }));

        logger.info("{}", new Solution().isBoomerang(new int[][]{
                {1,1},{2,2},{3,3}
        }));
    }
}
