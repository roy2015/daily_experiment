package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 八皇后问题, 进而推理到N皇后 并输出每种组合
 *
 * @author guojun
 * @date 2021/02/26
 */
public class TestSolutionNQueens {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionNQueens.class);


    static class Solution {

        private List<List<Integer>> resultLists = new ArrayList<>();
        private int queens;//预留
        private int queens_1;//queens-1使用比较多，单独一个变量

        public List<List<Integer>> solveNQueens(int N) {
            queens = N;
             queens_1 = queens -1;

            List<Integer> historyList = new ArrayList<>();
            int[] array1 = new int[2 * queens -1];//0~14 左上右下
            int[] array2 = new int[2 * queens -1];//-7~7 右上左下
            int[] array3 = new int[queens];//0~7 行
            int[] array4 = new int[queens];//0~7 列
            //从第一列到最后一列放皇后
            // 需要纪录：1. 第几个皇后（0-7） 3.之前皇后位置list
            //能放就继续往下放到底，直到情况都遍历，return到上一层
            int queenIdx = 0;
            //初始化放第一个皇后，第一列的八种情况
            for (int row = 0; row <= queens_1 ; row++) {
                int sumIdx = row + queenIdx;
                int diffIdx = row - queenIdx + queens_1;
                array1[sumIdx] = 1;
                array2[diffIdx] = 1;
                array3[row] = 1;
                array4[queenIdx] = 1;
                historyList.add(row);
                diguiCacl(queenIdx +1, historyList, array1, array2,array3, array4);
                //初始化
                historyList.clear();
                array1[sumIdx] = 0;
                array2[diffIdx] = 0;
                array3[row] = 0;
                array4[queenIdx] = 0;
            }
            return resultLists;
        }


        /**
         *
         * @param col 第几个皇后
         * @param historyList
         * @param array1 左上右下
         * @param array2 右上左下
         * @param array3 0~7 行
         * @param array4 0~7 列
         */
        public void diguiCacl(int col, List<Integer> historyList, int[] array1, int[] array2, int[] array3, int[] array4 ) {
            List<Integer> copyHistoryList = new ArrayList<>();
            copyHistoryList.addAll(historyList);
            //超界，返回
            if (col == queens) {
                resultLists.add(copyHistoryList);
                return;
            }

            List<Integer> candidatePos = getCandidatePos(col, array1, array2, array3, array4);
            for (int row : candidatePos) {
                markPos(col, row, array1, array2, array3, array4);
                copyHistoryList.add(row);
                diguiCacl(col +1, copyHistoryList, array1, array2, array3, array4);
                //prepare something for loop nex
                copyHistoryList.remove(copyHistoryList.size() -1);
                restPos(col, row, array1, array2, array3, array4);
            }
        }

        /**
         * 标记落下一个皇后
         * @param col
         * @param row
         * @param array1
         * @param array2
         * @param array3
         * @param array4
         */
        public void markPos(int col, int row,  int[] array1, int[] array2, int[] array3, int[] array4) {
            int sumIdx = row + col;
            int diffIdx = row - col + queens_1;
            array1[sumIdx] = 1;
            array2[diffIdx] = 1;
            array3[row] = 1;
            array4[col] = 1;
        }

        /**
         * 拿起一个皇后
         * @param col
         * @param row
         * @param array1
         * @param array2
         * @param array3
         * @param array4
         */
        public void restPos(int col, int row,  int[] array1, int[] array2, int[] array3, int[] array4) {
            int sumIdx = row + col;
            int diffIdx = row - col + queens_1;
            array1[sumIdx] = 0;
            array2[diffIdx] = 0;
            array3[row] = 0;
            array4[col] = 0;
        }

        /**
         * 返回皇后的候选位置(行)
         * @param col
         * @param array1
         * @param array2
         * @param array3
         * @param array4
         * @return
         */
        public List<Integer> getCandidatePos(int col, int[] array1, int[] array2, int[] array3, int[] array4) {
            List<Integer> retList = new ArrayList<>();
            for (int i = 0; i < queens; i++) {
                int sumIdx = i + col;
                int diffIdx = i - col + queens_1;
                if (array1[sumIdx] == 0 && array2[diffIdx] == 0 && array3[i] == 0 && array4[col] == 0 ) {
                    retList.add(i);
                }
            }
            return retList;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().solveNQueens(4);
        logger.info("{}", lists);
        logger.info("{}", lists.size());
    }
}
