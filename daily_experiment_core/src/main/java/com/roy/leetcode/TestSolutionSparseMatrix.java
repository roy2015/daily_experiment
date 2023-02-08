package com.roy.leetcode;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolutionSparseMatrix {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionSparseMatrix.class);


    @Data
    static class Solution {
        private int[][] sparseMatix ;

        public void printf() {
            printf(this.sparseMatix);
        }

        public void printf (int[] toOutputMatrix) {
            int length = toOutputMatrix.length;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(toOutputMatrix[i]);
                sb.append(StrUtil.C_SPACE);
            }
            logger.info(sb.toString());
        }

        public void printf (int[][] toOutputMatrix) {
            int length = toOutputMatrix.length;
            for (int i = 0; i < length; i++) {
                printf(toOutputMatrix[i]);
            }
        }

        /**
         * Coordinate(COO)
         *
         */
        public void s0 () {
            int row = this.sparseMatix.length;
            int col = this.sparseMatix[0].length;

            int nonZeroNum = 0 ;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (sparseMatix[i][j] != 0) {
                        nonZeroNum ++;
                    }
                }
            }
            int[][] denseMatrix = new int[3][nonZeroNum];
            int denseRowIdx = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (sparseMatix[i][j] != 0) {
                        denseMatrix[0][denseRowIdx] = i;
                        denseMatrix[1][denseRowIdx] = j;
                        denseMatrix[2][denseRowIdx] = sparseMatix[i][j];
                        denseRowIdx++;
                    }
                }
            }
            printf(denseMatrix);
        }

        /**
         * CSR Compressed Sparse Row
         * dense
         */
        public void s1 () {
            int row = this.sparseMatix.length;
            int col = this.sparseMatix[0].length;

            int nonZeroNum = 0 ;

            int firstI = -1, firstJ = -1;
            //find first non-zero element
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (sparseMatix[i][j] != 0) {
                        firstI = i;
                        firstJ = j;
                        break;
                    }
                }
                if (firstI != -1) {
                    break;
                }
            }

            if (firstI == -1) {
                return;
            }

            List<Integer>[] list =  new ArrayList[3];
            List<Integer> denseMatrixRow = new ArrayList<>();
            List<Integer> denseMatrixCol = new ArrayList<>();
            List<Integer> denseMatrixVal = new ArrayList<>();
            list[0] = denseMatrixRow;
            list[1] = denseMatrixCol;
            list[2] = denseMatrixVal;

            int last = -1;
            int cIdx = firstI;
            int i;
            for (i = firstI; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (sparseMatix[i][j] != 0) {
                        denseMatrixCol.add(j);
                        denseMatrixVal.add(sparseMatix[i][j]);

                        if (last == -1) {
                            denseMatrixRow.add(i);
                            last = i;
                        } else {
                            if (i != last) {
                                denseMatrixRow.add(cIdx);
                                last = i;
                            }
                        }
                        cIdx ++;
                    }
                }
            }
            denseMatrixRow.add(denseMatrixCol.size());


            logger.info("{}", denseMatrixRow);
            logger.info("{}", denseMatrixCol);
            logger.info("{}", denseMatrixVal);




        }



    }

    public static void main(String[] args) {
        Solution so = new Solution();
        so.setSparseMatix(new int[][]{
                {0, 0, 0, 0},
                {0, 2, 8, 0},
                {5, 0, 3, 9},
                {0, 6, 0, 4}
        });
        so.printf();

        logger.info("=================");

        so.s1();
    }
}
