package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 *
 * 223. 矩形面积
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 *
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 *
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 *
 *
 * 示例 1：
 *
 * Rectangle Area
 * 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * 输出：45
 * 示例 2：
 *
 * 输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * 输出：16
 *
 *
 * 提示：
 *
 * -104 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 104
 *
 * @author guojun
 * @date 2021/9/30
 */
public class TestSolution223 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution223.class);


    static class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            //右下角
            int ax3 = ax2;
            int ay3 = ay1;

            int bx3 = bx2;
            int by3 = by1;

            //算重叠面积
            int shadeArea ;
            //两个矩形的面积
            int area = (ax2 - ax1) * (ay2  - ay1) + (bx2 - bx1) * (by2  - by1);

            //无重叠
            if (bx1 >= ax3 || bx3 <= ax1 || by3 <= ay3 || by3 >= ay2) {
                return area ;
            }

            //分三种情况，


            return 0;

        }

        static class Tuple {
            private int px;
            private int py;

            public Tuple(int px, int py) {
                this.px = px;
                this.py = py;
            }

            public int getPx() {
                return px;
            }

            public void setPx(int px) {
                this.px = px;
            }

            public int getPy() {
                return py;
            }

            public void setPy(int py) {
                this.py = py;
            }
        }



    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().computeArea(-3, 0,  3,  4,  0,  -1,  9,  2));
    }
}
