package com.roy.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/18.
 *如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。

 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。

 示例 1:

 输入:
 matrix = [
   [1,2,3,4],
   [5,1,2,3],
   [9,5,1,2]
 ]
 输出: True
 解释:
 在上述矩阵中, 其对角线为:
 "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 各条对角线上的所有元素均相同, 因此答案是True。
 示例 2:

 输入:
 matrix = [
   [1,2],
   [2,2]
 ]
 输出: False
 解释:
 对角线"[1, 2]"上的元素不同。
 说明:

  matrix 是一个包含整数的二维数组。
 matrix 的行数和列数均在 [1, 20]范围内。
 matrix[i][j] 包含的整数在 [0, 99]范围内。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution766 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution766.class);

    /**
     *
     *
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :39.6 MB, 在所有 java 提交中击败了98.25%的用户
     */
    static class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            if (matrix == null) {
                return false;
            }

            int row = matrix.length;
            int column = matrix[0].length;

            for (int i =row-1 ; i > 0; i--) {
                for (int j= i+1,k =1; (j < row) && (k< column) ;  j++,k++ ) {
                    if (matrix[i][0] != matrix[j][k]) {
                        return false;
                    }
                }
            }

            for (int i =0 ; i < column; i++) {
                for (int j= i+1,k =1; (k < row) && (j< column );  j++, k++ ) {
                    if (matrix[0][i] != matrix[k][j]) {
                        return false;
                    }
                }
            }
            return true;

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isToeplitzMatrix (
                new int[][]{
                        {44,35,39},
                        {15,44,35},
                        {17,15,44},
                        {80,17,15},
                        {43,80,17},
                        {77,43,80}}));
    }

}
