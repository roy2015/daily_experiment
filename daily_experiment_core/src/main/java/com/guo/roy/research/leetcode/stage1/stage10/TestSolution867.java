package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/29.
 *给定一个矩阵 A， 返回 A 的转置矩阵。

 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。

  

 示例 1：

 输入：[[1,2,3],[4,5,6],[7,8,9]]
 输出：[[1,4,7],[2,5,8],[3,6,9]]
 示例 2：

 输入：[[1,2,3],[4,5,6]]
 输出：[[1,4],[2,5],[3,6]]
  

 提示：

 1 <= A.length <= 1000
 1 <= A[0].length <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/transpose-matrix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution867 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution867.class);

    /**
     *
     */
    static class Solution {

        /**
         *
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了97.15%的用户
         内存消耗 :38.4 MB, 在所有 java 提交中击败了95.47%的用户
         *
         * @param A
         * @return
         */
        public int[][] transpose(int[][] A) {
            if (A == null) {
                return null;
            }

            int row = A.length;
            int column = A[0].length;
            int[][] retInts = new int[column][row];

            for (int i=0 ; i < column; i ++) {
                for (int j = 0; j < row; j++) {
                    retInts[i][j] = A[j][i];
                }
            }
            return retInts;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().transpose(new int[][]{
                {1,2,3},{4,5,6}}) );
    }

}
