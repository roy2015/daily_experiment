package com.roy.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 *
 * 836. 矩形重叠
矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。

如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。

给出两个矩形，判断它们是否重叠并返回结果。



示例 1：

输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
输出：true
示例 2：

输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
输出：false


提示：

两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
矩形中的所有坐标都处于 -10^9 和 10^9 之间。
x 轴默认指向右，y 轴默认指向上。
你可以仅考虑矩形是正放的情况。
 */
public class TestSolution836 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution836.class);


    static class Solution {
        /**
         * 执行结果：
         * 通过显示详情
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :37 MB, 在所有 Java 提交中击败了50.00%的用户
         * @param rec1
         * @param rec2
         * @return
         */
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            //四个顶点
            int fx1 = rec1[0], fy1 = rec1[1];
            int fx2 = rec1[2], fy2 = rec1[3];
            int sx1 = rec2[0], sy1 = rec2[1];
            int sx2 = rec2[2], sy2 = rec2[3];

            if ((sx1 < fx2 && sx2 > fx1) &&
                    (sy1 < fy2 && sy2 > fy1)) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isRectangleOverlap(new int[]{-7,-3,10,5},
                new int[]{-6,-5,5,10}));//true

        logger.info("{}", new Solution().isRectangleOverlap(new int[]{0,0,1,1},
                new int[]{1,0,2,1}));//false
    }
}
