package com.guo.roy.research.leetcode.stage1.stage11;

import java.util.BitSet;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/8 9:54
 *
 * 1252. 奇数值单元格的数目
给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。

另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。

你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。

请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。



示例 1：



输入：n = 2, m = 3, indices = [[0,1],[1,1]]
输出：6
解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
第一次增量操作后得到 [[1,2,1],[0,1,0]]。
最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
示例 2：



输入：n = 2, m = 2, indices = [[1,1],[0,0]]
输出：0
解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。


提示：

1 <= n <= 50
1 <= m <= 50
1 <= indices.length <= 100
0 <= indices[i][0] < n
0 <= indices[i][1] < m
 */
public class TestSolution1252 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1252.class);


    static class Solution {

        /**
         *
         * 用了bitSet打标记
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时 :6 ms, 在所有 Java 提交中击败了5.18%的用户 (what?)
         * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了33.33%的用户
         *
         * @param n
         * @param m
         * @param indices
         * @return
         */
        public int oddCells(int n, int m, int[][] indices) {
            BitSet bitSet = new BitSet(n * m);

            for (int[] indice : indices) {
                int row = indice[0];
                int col = indice[1];

                //本列
                for (int i = 0; i < n ; i++) {
                    int pos = i * m + col;
                    bitSet.set(pos, ! bitSet.get(pos));
                }

                //本行
                for (int j = 0; j < m ; j++) {
                    int pos = row * m + j;
                    bitSet.set(pos, ! bitSet.get(pos));
                }
            }

            int total =0;
            int size = m * n;

            for (int i = 0; i < size; i++) {
                if (bitSet.get(i)) {
                    total ++;
                }
            }

            return total;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new TestSolution1252.Solution().oddCells(2,3,
                new int[][]{
                        {0,1},{1,1}
                }));

        logger.info("{}", new TestSolution1252.Solution().oddCells(2,2,
                new int[][]{
                        {1,1},{0,0}
                }));
    }
}
