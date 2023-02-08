package com.guo.roy.research.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/12/23
 *
 *
 * 1476. 子矩形查询
 * 请你实现一个类 SubrectangleQueries ，它的构造函数的参数是一个 rows x cols 的矩形（这里用整数矩阵表示），并支持以下两种操作：
 *
 * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 *
 * 用 newValue 更新以 (row1,col1) 为左上角且以 (row2,col2) 为右下角的子矩形。
 * 2. getValue(int row, int col)
 *
 * 返回矩形中坐标 (row,col) 的当前值。
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
 * [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
 * 输出：
 * [null,1,null,5,5,null,10,5]
 * 解释：
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);
 * // 初始的 (4x3) 矩形如下：
 * // 1 2 1
 * // 4 3 4
 * // 3 2 1
 * // 1 1 1
 * subrectangleQueries.getValue(0, 2); // 返回 1
 * subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
 * // 此次更新后矩形变为：
 * // 5 5 5
 * // 5 5 5
 * // 5 5 5
 * // 5 5 5
 * subrectangleQueries.getValue(0, 2); // 返回 5
 * subrectangleQueries.getValue(3, 1); // 返回 5
 * subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
 * // 此次更新后矩形变为：
 * // 5   5   5
 * // 5   5   5
 * // 5   5   5
 * // 10  10  10
 * subrectangleQueries.getValue(3, 1); // 返回 10
 * subrectangleQueries.getValue(0, 2); // 返回 5
 * 示例 2：
 *
 * 输入：
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue"]
 * [[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
 * 输出：
 * [null,1,null,100,100,null,20]
 * 解释：
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
 * subrectangleQueries.getValue(0, 0); // 返回 1
 * subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
 * subrectangleQueries.getValue(0, 0); // 返回 100
 * subrectangleQueries.getValue(2, 2); // 返回 100
 * subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
 * subrectangleQueries.getValue(2, 2); // 返回 20
 *
 *
 * 提示：
 *
 * 最多有 500 次updateSubrectangle 和 getValue 操作。
 * 1 <= rows, cols <= 100
 * rows == rectangle.length
 * cols == rectangle[i].length
 * 0 <= row1 <= row2 < rows
 * 0 <= col1 <= col2 < cols
 * 1 <= newValue, rectangle[i][j] <= 10^9
 * 0 <= row < rows
 * 0 <= col < cols
 */
public class TestSolution1476 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1476.class);


    /**
     * 不敢相信有如此简单的medium难度的，估计有其他的骚套路吧，去看看官方题解
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：29 ms, 在所有 Java 提交中击败了94.76%的用户
     * 内存消耗：42.6 MB, 在所有 Java 提交中击败了9.19%的用户
     *
     *
     */
    static class SubrectangleQueries {
        private int[][] storeRectangle;


        public SubrectangleQueries(int[][] rectangle) {
            storeRectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2 ; i++) {
                for (int j = col1; j <= col2; j++) {
                    storeRectangle[i][j] = newValue;
                }
            }


        }

        public int getValue(int row, int col) {
            return storeRectangle[row][col];
        }
    }

    /**
     * 思路别人的，代码自己写的，
     * 1.算是lazy更新吧， 保存update的history,getValue时逆序查找history，看是否在区间内，这样可以频繁
     *  更新原数组，
     * 2. 直接用数组，不要用ArrayList，后者慢比上面的解法还差
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 27 ms
     * , 在所有 Java 提交中击败了
     * 99.02%
     * 的用户
     * 内存消耗：
     * 42.3 MB,
     * 在所有 Java 提交中击败了33.36%的用户
     */
    static class SubrectangleQueries1 {
        private int[][] storeRectangle;
        private int[][] history;
        private int updateTimes = 0;

        public SubrectangleQueries1(int[][] rectangle) {
            storeRectangle = rectangle;
            history = new int[500][];
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            history[updateTimes] = new int[]{row1, col1, row2, col2, newValue};
            updateTimes ++;
        }

        public int getValue(int row, int col) {
            for (int i = updateTimes -1; i >= 0 ; i--) {
                int[] item = history[i];
                int hisRow1 = item[0];
                int hisCol1 = item[1];
                int hisRow2 = item[2];
                int hisCol2 = item[3];
                if (row >= hisRow1 && row <= hisRow2 && col >= hisCol1 && col <= hisCol2 ) {
                    return item[4];
                }
            }
            return storeRectangle[row][col];
        }
    }


    /**
     * Your SubrectangleQueries object will be instantiated and called as such:
     * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
     * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
     * int param_2 = obj.getValue(row,col);
     */

    public static void main(String[] args) {
        SubrectangleQueries1 solution = new SubrectangleQueries1(new int[][]{
                {1, 1, 1}, {2, 2, 2}, {3, 3, 3}
        });
        logger.info("{}", solution.getValue(0,0));//1
        solution.updateSubrectangle(0,0,2,2,100);
        logger.info("{}", solution.getValue(0,0));//100
        logger.info("{}", solution.getValue(2,2));//100
        solution.updateSubrectangle(1,1,2,2,20);
        logger.info("{}", solution.getValue(2,2));//20
    }
}
