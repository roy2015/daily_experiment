package com.guo.roy.research.leetcode.stage2.stage21;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/02/05
 *
 *
 *
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 *
 *
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 *
 *
 */
public class TestSolution221 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution221.class);


    static class Solution {

        static class Postion {
            /**
             * 行坐标
             */
            private int pr;
            /**
             * 列坐标
             */
            private int pc;

            public Postion(int pr, int pc) {
                this.pr = pr;
                this.pc = pc;
            }
        }


        /**
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：9 ms, 在所有 Java 提交中击败了9.95%的用户
         * 内存消耗：
         * 43.2 MB, 在所有 Java 提交中击败了5.09%的用户
         *
         * @param matrix
         * @return
         */
        public int maximalSquare(char[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            List<Postion> lastLevelData = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == '1') {
                        lastLevelData.add(new Postion(i,j));
                    }
                }
            }
            //全部是0
            if (lastLevelData.size() == 0) {
                return 0;
            }
            int level =1;
            int rowCol = Math.min(row, col);
            //外层for代表level，内层for轮询上一level的list
            for (level = 2; level <= rowCol; level++) {
                List<Postion> currentLevelData = new ArrayList<>();
                for (Postion lastLevelDatum : lastLevelData) {
                    boolean available = true;//校验每个点是否能扩展到下一个level
                    int pc = lastLevelDatum.pc + level -1;
                    int pr = lastLevelDatum.pr + level -1;
                    if (pc >= col || pr >= row) {
                        continue;
                    }
                    //列
                    for (int i = lastLevelDatum.pr; i <= pr; i++) {
                        if (matrix[i][pc] == '0') {
                            available = false;
                            break;
                        }
                    }
                    if (!available) {
                        continue;
                    }
                    //行
                    for (int i = lastLevelDatum.pc; i <= pc; i++) {
                        if (matrix[pr][i] == '0') {
                            available = false;
                            break;
                        }
                    }
                    //右加一列，下加一行都ok
                    if (available) {
                        currentLevelData.add(new Postion(lastLevelDatum.pr,lastLevelDatum.pc));
                    }
                }//end for
                //不能扩展一个level
                if ((currentLevelData.size() ==0)) {
                    return  (level -1) * (level -1);
                }
                lastLevelData = currentLevelData;
            }//end for
            return (level -1) * (level -1);
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}

        }));
    }
}
