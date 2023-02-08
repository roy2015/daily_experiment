package com.roy.leetcode.stage2.stage20;

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
        /**
         *
         *
         * 考虑16种情况
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：3 ms, 在所有 Java 提交中击败了55.68%的用户
         * 内存消耗：
         * 37.8 MB, 在所有 Java 提交中击败了59.69%的用户通过测试用例：
         *
         * @param ax1
         * @param ay1
         * @param ax2
         * @param ay2
         * @param bx1
         * @param by1
         * @param bx2
         * @param by2
         * @return
         */
        public int computeArea1(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            //顺时针
            //左上
            int a1x,a1y;
            //右上
            int a2x,a2y;
            //右下
            int a3x,a3y;
            //左下
            int a4x,a4y;
            a1x = ax1;
            a1y = ay2;
            a2x = ax2;
            a2y = ay2;
            a3x = ax2;
            a3y = ay1;
            a4x = ax1;
            a4y = ay1;

            //同理
            int b1x,b1y;
            //右上
            int b2x,b2y;
            //右下
            int b3x,b3y;
            //左下
            int b4x,b4y;
            b1x = bx1;
            b1y = by2;
            b2x = bx2;
            b2y = by2;
            b3x = bx2;
            b3y = by1;
            b4x = bx1;
            b4y = by1;

            //算重叠面积
            int shadeArea ;
            //两个矩形的面积
            int aArea = Math.abs(a1x - a3x) * Math.abs(a1y - a3y) ;
            int bArea = Math.abs(b1x - b3x) * Math.abs(b1y - b3y) ;

            //无重叠
            if (b1x >= a3x || b2x <= a1x || b1y <= a4y || b4y >= a1y) {
                return aArea + bArea ;
            }

            int resut = 0;
            //拿B去切割A
            if (isInRectangle(b1x, b1y, a1x, a2x, a4y, a1y)) {
                resut |= 1;
            }
            if (isInRectangle(b2x, b2y, a1x, a2x, a4y, a1y)) {
                resut |= 2;
            }
            if (isInRectangle(b3x, b3y, a1x, a2x, a4y, a1y)) {
                resut |= 4;
            }
            if (isInRectangle(b4x, b4y, a1x, a2x, a4y, a1y)) {
                resut |= 8;
            }

            switch (resut) {
                case 0x0://四个点在A外
                    break;
                case 0xF://B四个点均在A里
                    return aArea;
                case 0x3://
                    return aArea + bArea - (b2x - b1x) * (b1y - a4y);
                case 0xc:
                    return aArea + bArea - (b2x - b1x) * (a1y - b4y);
                case 0x6:
                    return aArea + bArea - (b2x - a1x) * (b2y - b3y);
                case 0x9:
                    return aArea + bArea - (a2x - b1x) * (b2y - b3y);
                case 0x1:
                    return aArea + bArea - (a3x - b1x) * (b1y - a3y);
                case 0x2:
                    return aArea + bArea - (b2x - a4x) * (b2y - a4y);
                case 0x4:
                    return aArea + bArea - (b3x - a1x) * (a1y - b3y);
                case 0x8:
                    return aArea + bArea - (a2x - b4x) * (a2y - b4y);
            }

            //B的四个点在A外的相交
            int width = Math.min(a2x, b2x) - Math.max(a1x, b1x);
            int height = Math.min(a1y, b1y) - Math.max(a4y, b4y);
            int shadowArea = width * height;
            return aArea + bArea - shadowArea;
        }

        /**
         *
         * 再多的判断场景也不如一个公式来的容易，适用所有场景
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：3 ms, 在所有 Java 提交中击败了55.68%的用户
         * 内存消耗：37.7 MB, 在所有 Java 提交中击败了89.38%的用户
         * 通过测试用例：
         * 3080 / 3080
         *
         * @param ax1
         * @param ay1
         * @param ax2
         * @param ay2
         * @param bx1
         * @param by1
         * @param bx2
         * @param by2
         * @return
         */
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            //顺时针
            //左上
            int a1x,a1y;
            //右上
            int a2x,a2y;
            //右下
            int a3x,a3y;
            //左下
            int a4x,a4y;
            a1x = ax1;
            a1y = ay2;
            a2x = ax2;
            a2y = ay2;
            a3x = ax2;
            a3y = ay1;
            a4x = ax1;
            a4y = ay1;

            //同理
            int b1x,b1y;
            //右上
            int b2x,b2y;
            //右下
            int b3x,b3y;
            //左下
            int b4x,b4y;
            b1x = bx1;
            b1y = by2;
            b2x = bx2;
            b2y = by2;
            b3x = bx2;
            b3y = by1;
            b4x = bx1;
            b4y = by1;

            //算重叠面积
            int shadeArea ;
            //两个矩形的面积
            int aArea = Math.abs(a1x - a3x) * Math.abs(a1y - a3y) ;
            int bArea = Math.abs(b1x - b3x) * Math.abs(b1y - b3y) ;

            //无重叠
            if (b1x >= a3x || b2x <= a1x || b1y <= a4y || b4y >= a1y) {
                return aArea + bArea ;
            }

            //我去，两个公式包含所有情况
            int width = Math.min(a2x, b2x) - Math.max(a1x, b1x);
            int height = Math.min(a1y, b1y) - Math.max(a4y, b4y);
            int shadowArea = width * height;
            return aArea + bArea - shadowArea;
        }

        private boolean isInRectangle (int px, int py, int minX, int maxX, int minY, int maxY) {
            if (px > minX && px < maxX && py > minY  && py < maxY ) {
                return true;
            }
            return false;
        }



    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().computeArea1(-3,-3,3,-1,
                -2,-2,2,2
            ));//24
        logger.info("{}", new Solution().computeArea(-2,   -2,   2, 2,
             -2,  -2,  2, 2));//16
        logger.info("{}", new Solution().computeArea(-3, 0,  3,  4,
            0,  -1,  9,  2));//45


    }
}
