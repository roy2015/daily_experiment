package com.roy.miscellaneous.leetcode.stage3;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[["Q"]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * @author guojun
 * @date 2021/2/27
 *
 */
public class TestSolution51 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution51.class);


    /**
     *
     * 回溯算法的经典题目 八皇后问题，推广到N皇后
     *
     * 执行结果：通过
     * 显示详情
     * 执行用时：5 ms, 在所有 Java 提交中击败了52.28%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了29.32%的用户
     *
     *
     */
    static class Solution {
        private List<List<String>> resultLists = new ArrayList<>();
        private int queens;//预留
        private int queens_1;//queens-1使用比较多，单独一个变量
        private String templateStr;

        public List<List<String>> solveNQueens(int n) {
            queens = n;
            queens_1 = queens -1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append('.');
            }
            templateStr = sb.toString();

            List<String> historyList = new ArrayList<>();
            int[] leftRightArray = new int[2 * queens -1];//0~14 左上右下
            int[] rightLeftArray = new int[2 * queens -1];//-7~7 右上左下
            int[] rowArray = new int[queens];//0~7 行
            int[] colArray = new int[queens];//0~7 列

            int queenIdx = 0;

            for (int col = 0; col <= queens_1 ; col++) {
                int sumIdx = queenIdx + col;
                int diffIdx = queenIdx - col + queens_1;
                leftRightArray[sumIdx] = 1;
                rightLeftArray[diffIdx] = 1;
                rowArray[queenIdx] = 1;
                colArray[col] = 1;
                historyList.add(new StringBuilder(templateStr).replace(col, col+1, "Q").toString());
                diguiCacl(queenIdx +1, historyList, leftRightArray, rightLeftArray, rowArray, colArray);
                //初始化
                historyList.remove(0);
                leftRightArray[sumIdx] = 0;
                rightLeftArray[diffIdx] = 0;
                rowArray[queenIdx] = 0;
                colArray[col] = 0;
            }
            return resultLists;
        }

        /**
         *
         * @param row 第几个皇后
         * @param historyList
         * @param leftRightArray 左上右下
         * @param rightLeftArray 右上左下
         * @param rowArray 0~7 行
         * @param colArray 0~7 列
         */
        private void diguiCacl(int row, List<String> historyList, int[] leftRightArray, int[] rightLeftArray, int[] rowArray, int[] colArray ) {
            List<String> copyHistoryList = new ArrayList<>();
            copyHistoryList.addAll(historyList);
            //超界，返回
            if (row == queens) {
                resultLists.add(copyHistoryList);
                return;
            }

            List<Integer> candidatePos = getCandidatePos(row, leftRightArray, rightLeftArray, rowArray, colArray);
            for (int col : candidatePos) {
                markPos(row, col, leftRightArray, rightLeftArray, rowArray, colArray);
                copyHistoryList.add(new StringBuilder(templateStr).replace(col, col+1, "Q").toString());
                diguiCacl(row +1, copyHistoryList, leftRightArray, rightLeftArray, rowArray, colArray);
                //prepare something for loop nex
                copyHistoryList.remove(copyHistoryList.size() -1);
                restPos(row, col, leftRightArray, rightLeftArray, rowArray, colArray);
            }
        }

        /**
         * 标记落下一个皇后
         * @param row
         * @param col
         *  @param leftRightArray 左上右下
         *  @param rightLeftArray 右上左下
         *  @param rowArray 0~7 行
         *  @param colArray 0~7 列
         */
        private void markPos(int row, int col,  int[] leftRightArray, int[] rightLeftArray, int[] rowArray, int[] colArray) {
            int sumIdx = row + col;
            int diffIdx = row - col   + queens_1;
            leftRightArray[sumIdx] = 1;
            rightLeftArray[diffIdx] = 1;
            rowArray[row] = 1;
            colArray[col] = 1;
        }

        /**
         * 拿起一个皇后
         * @param row
         * @param col
         *  @param leftRightArray 左上右下
         *  @param rightLeftArray 右上左下
         *  @param rowArray 0~7 行
         *  @param colArray 0~7 列
         */
        private void restPos(int row, int col,  int[] leftRightArray, int[] rightLeftArray, int[] rowArray, int[] colArray) {
            int sumIdx = row + col;
            int diffIdx = row - col  + queens_1;
            leftRightArray[sumIdx] = 0;
            rightLeftArray[diffIdx] = 0;
            rowArray[row] = 0;
            colArray[col] = 0;
        }

        /**
         * 返回皇后的候选位置(烈)
         * @param row
         * @param leftRightArray 左上右下
         * @param rightLeftArray 右上左下
         * @param rowArray 0~7 行
         * @param colArray 0~7 列
         * @return
         */
        private List<Integer> getCandidatePos(int row, int[] leftRightArray, int[] rightLeftArray, int[] rowArray, int[] colArray) {
            List<Integer> retList = new ArrayList<>();
            for (int col = 0; col < queens; col++) {
                int sumIdx =  row + col;
                int diffIdx = row - col   + queens_1;
                if (leftRightArray[sumIdx] == 0 && rightLeftArray[diffIdx] == 0 && rowArray[row] == 0 && colArray[col] == 0 ) {
                    retList.add(col);
                }
            }
            return retList;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().solveNQueens(4));
    }
}
