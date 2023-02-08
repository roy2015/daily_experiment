package com.guo.roy.research.leetcode.stage1.stage13;

import java.util.BitSet;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/1
 *
 *
 * 463. 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 *
 *
 *
 *
 */
public class TestSolution463 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution463.class);


    /**
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 14 ms, 在所有 Java 提交中击败了8.25%
     * 的用户
     * 内存消耗：
     * 43.3 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     */
    static class Solution {
        private int[][] grid;
        private int rowLen;
        private int colLen;

        /**
         *
         *自己思考出来的算法 15ms
         *递归计算，每个格子递归四个方向的格子计算周长再加自身周长
         *
         * 执行用时：
         * 15 ms, 在所有 Java 提交中击败了6.25%的用户
         * 内存消耗：
         * 41.5 MB
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         *
         * @param grid
         * @return
         */
        public int islandPerimeter(int[][] grid) {
            this.grid = grid;
            rowLen = grid.length;
            colLen = grid[0].length;
            BitSet isLandMap = new BitSet(colLen * rowLen );
            int retPerimeter;

            int i , j ;
            for (i = 0; i < rowLen; i++) {
                for (j = 0; j < colLen; j++) {
                    if (grid[i][j] == 1) {
                        retPerimeter = evaluateGridPerimeter(isLandMap, i, j, i*colLen + j);
                        return retPerimeter;
                    }
                }
            }
                return 0;
        }

        /**
         *
         *
         *
         * @param i
         * @param j
         * @return
         */
        public int evaluateGridPerimeter(BitSet isLandMap, int i, int j,int currentIdx) {
            int up =0, down=0, left=0, right=0, self = 4;
            isLandMap.set(currentIdx, true);
            int nextIdx ;

            if (j > 0) {//左
                if (grid[i][j-1] == 1) {
                    //判断是为了防止环出现就死循环了
                    nextIdx = i * colLen + (j-1);
                    if (!isLandMap.get(nextIdx)) {
                        left = evaluateGridPerimeter(isLandMap, i,  j -1, nextIdx);
                    }
                    self --;
                }
            }
            if (j < colLen-1) {//右
                if (grid[i][j+1] == 1 ) {
                    nextIdx = i * colLen + j+1;
                    if (!isLandMap.get(nextIdx)) {
                        right = evaluateGridPerimeter(isLandMap, i,  j + 1, nextIdx);
                    }
                    self --;
                }
            }
            if (i > 0) {//上
                if (grid[i-1][j] == 1) {
                    nextIdx = (i-1) * colLen + j;
                    if (!isLandMap.get(nextIdx)) {
                        up = evaluateGridPerimeter(isLandMap, i - 1, j, nextIdx);
                    }
                    self --;
                }
            }
            if (i < rowLen -1) {//下
                if (grid[i+1][j] == 1) {
                    nextIdx = (i+1) * colLen + j;
                    if (  !isLandMap.get(nextIdx)) {
                        down = evaluateGridPerimeter(isLandMap, i+1,  j,  nextIdx);
                    }
                    self --;
                }
            }
            return left +right + up +down +self;
        }


        /**
         *自己思考，再优化同上，不过没使用哈希，直接把状态写到原数组  9ms
         * 更优化的算法应该是不用递归吧？
         *
         *
         *执行结果：
         *通过
         *显示详情
         *执行用时：
         * 9 ms, 在所有 Java 提交中击败了53.05%的用户
         * 内存消耗：
         * 41.6 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param grid
         * @return
         */
        public int islandPerimeter1(int[][] grid) {
            this.grid = grid;
            rowLen = grid.length;
            colLen = grid[0].length;
            int retPerimeter;

            int i , j ;
            for (i = 0; i < rowLen; i++) {
                for (j = 0; j < colLen; j++) {
                    if (grid[i][j] == 1) {
                        retPerimeter = evaluateGridPerimeter1(i, j);
                        return retPerimeter;
                    }
                }
            }
            return 0;
        }

        public int evaluateGridPerimeter1(int i, int j) {
            int up =0, down=0, left=0, right=0, self = 4;

            //2：已访问已计算过
            grid[i][j] = 2;
            int tmp;

            if (j > 0) {//左
                tmp = grid[i][j-1];
                if (tmp ==1 || tmp == 2) {
                    if (tmp == 1) {
                        left = evaluateGridPerimeter1(i,  j -1);
                    }
                    self --;
                }

            }

            if (j < colLen-1) {//右
                tmp = grid[i][j + 1];
                if (tmp ==1 || tmp == 2) {
                    if (tmp == 1) {
                        right = evaluateGridPerimeter1(i, j + 1);
                    }
                    self--;
                }
            }

            if (i > 0) {//上
                tmp = grid[i - 1][j];
                if (tmp ==1 || tmp == 2) {
                    if (tmp == 1) {
                        up = evaluateGridPerimeter1(i - 1, j);
                    }
                    self--;
                }
            }
            if (i < rowLen -1) {//下
                tmp = grid[i + 1][j];
                if (tmp ==1 || tmp == 2) {
                    if (tmp == 1) {
                        down = evaluateGridPerimeter1(i + 1, j);
                    }
                    self--;
                }
            }
            return left +right + up +down +self;
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().islandPerimeter(new int[][]{
                {1,1},
                {1,1}
        }));//8

        logger.info("{}", new Solution().islandPerimeter(new int[][]{
                {1,0,0},
                {1,1,0}
        }));//8
        logger.info("{}", new Solution().islandPerimeter1(new int[][]{
                {0,0,1},
                {1,1,1}
        }));//10

        logger.info("{}", new Solution().islandPerimeter1(new int[][]{
                {0,0,0},
                {1,1,0}
        }));//6



        logger.info("{}", new Solution().islandPerimeter1(new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        }));//16

        logger.info("{}", new Solution().islandPerimeter1(new int[][]{
                {1,1,0},
                {1,0,0},
                {1,0,0}
        }));//10
    }
}
