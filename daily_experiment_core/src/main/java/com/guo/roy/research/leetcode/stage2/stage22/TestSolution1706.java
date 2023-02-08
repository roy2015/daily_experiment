package com.guo.roy.research.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/1/29
 *
 *1706. 球会落何处
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 *
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 *
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 *
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
 * 输出：[1,-1,-1,-1,-1]
 * 解释：示例如图：
 * b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
 * b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 * b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 * 示例 2：
 *
 * 输入：grid = [[-1]]
 * 输出：[-1]
 * 解释：球被卡在箱子左侧边上。
 * 示例 3：
 *
 * 输入：grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
 * 输出：[0,1,2,3,4,-1]
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] 为 1 或 -1
 *
 *
 */
public class TestSolution1706 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1706.class);


    static class Solution {
        /**
         * 貌似不怎么理想，但至少是原创
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：3 ms, 在所有 Java 提交中击败了37.50%的用户
         * 内存消耗：39.8 MB, 在所有 Java 提交中击败了49.14%的用户
         *
         * @param grid
         * @return
         */
        public int[] findBall(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            int[] result = new int[col];
            //能否next, 如果所有球都碰壁或者都走到V字直接break没必要浪费计算
            boolean canGO = true;
            //初始化，默认列索引
            for (int i = 0; i < col; i++) {
                result[i] = i;
            }

            //大for层数 ，小for球
            for (int i = 0; i < row; i++) {
                if (!canGO) {
                    break;
                }
                //初始为false，由后面满足条件的置为true
                canGO = false;
                //开始遍历result
                for (int j = 0; j < col; j++) {
                    if (result[j] == -1) {
                        continue;
                    }
                    //球现在所在的列
                    int pos = result[j];
                    //左上右下，看下一个格子
                    if (grid[i][pos] == 1) {
                        //撞右边墙里或者和下一个成V型
                        if (pos == col -1 || grid[i][pos + 1]==-1) {
                            result[j] = -1;
                        } else {
                            result[j] = pos + 1;
                            canGO |= true;
                        }
                    } else {//右上左下，看前一个格子
                        //撞左边墙里或者和前一个成V型
                        if (pos == 0 || grid[i][pos - 1]== 1) {
                            result[j] = -1;
                        } else {
                            result[j] = pos - 1;
                            canGO |= true;
                        }
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {


        logger.info("{}", new Solution().findBall(new int[][]{
                {1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}

        }));//{1,-1,-1,-1,-1}

        logger.info("{}", new Solution().findBall(new int[][]{
                {-1}

        }));//-1

        logger.info("{}", new Solution().findBall(new int[][]{
                {1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}

        }));//0,1,2,3,4,-1
    }
}
