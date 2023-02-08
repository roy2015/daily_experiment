package com.guo.roy.research.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 *
 * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 

 i - K <= r <= i + K, j - K <= c <= j + K 
 (r, c) 在矩阵内。
  

 示例 1：

 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 输出：[[12,21,16],[27,45,33],[24,39,28]]
 示例 2：

 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 输出：[[45,45,45],[45,45,45],[45,45,45]]
  

 提示：

 m == mat.length
 n == mat[i].length
 1 <= m, n, K <= 100
 1 <= mat[i][j] <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/matrix-block-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * @author guojun
 * @date 2020/1/30 10:59
 */
public class TestSolution1314 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1314.class);


    static class Solution {
        /**
         *
         * todo: 硬编码，执行用时较高，考虑用前缀和
         *
         * 执行用时 :97 ms, 在所有 Java 提交中击败了46.83%的用户
         * 内存消耗 :53.3 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param mat
         * @param K
         * @return
         */
        public int[][] matrixBlockSum(int[][] mat, int K) {
            int row = mat.length;
            int col = mat[0].length;
            //初始化数组
            int[][] retMatrix = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int sum = 0;
                    int minR = Math.max(0, i - K);
                    int maxR = Math.min(row -1, i + K);
                    int minC = Math.max(0, j - K);
                    int maxC = Math.min(col - 1, j + K);

                    for (int r = minR; r <= maxR; r++) {
                        for (int c = minC; c <= maxC; c++) {
                            sum += mat[r][c];
                        }
                    }
                    retMatrix[i][j] = sum;
                }
            }
            return retMatrix;
        }

        public static void printMatrix(int[][] mat) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int[] ints : mat) {
                stringBuffer.delete(0, stringBuffer.length());
                for (int anInt : ints) {
                    stringBuffer.append(anInt).append(" ");
                }
                logger.info(stringBuffer.toString());
            }
        }
    }

    public static void main(String[] args) {
        int[][] ints = new Solution().matrixBlockSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 1);
        Solution.printMatrix(ints);
    }
}
