package com.guo.roy.research.leetcode.stage1.stage12;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/20
 *
 *
 * 1275. 找出井字棋的获胜者
A 和 B 在一个 3 x 3 的网格上玩井字棋。

井字棋游戏的规则如下：

玩家轮流将棋子放在空方格 (" ") 上。
第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
"X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
如果所有方块都放满棋子（不为空），游戏也会结束。
游戏结束后，棋子无法再进行任何移动。
给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。

如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。

你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。



示例 1：

输入：moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
输出："A"
解释："A" 获胜，他总是先走。
"X  "    "X  "    "X  "    "X  "    "X  "
"   " -> "   " -> " X " -> " X " -> " X "
"   "    "O  "    "O  "    "OO "    "OOX"
示例 2：

输入：moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
输出："B"
解释："B" 获胜。
"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
"   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
"   "    "   "    "   "    "   "    "   "    "O  "
示例 3：

输入：moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
输出："Draw"
输出：由于没有办法再行动，游戏以平局结束。
"XXO"
"OOX"
"XOX"
示例 4：

输入：moves = [[0,0],[1,1]]
输出："Pending"
解释：游戏还没有结束。
"X  "
" O "
"   "
 *
 */
public class TestSolution1275 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1275.class);


    static class Solution {
        /**
         *
         * 执行结果：通过显示详情
         执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :37.3 MB, 在所有 Java 提交中击败了14.29%的用户
         *
         * @param moves
         * @return
         */
        public String tictactoe(int[][] moves) {
            int[][] chessboard = new int[3][3];
            int len = moves.length;
            for (int i =0; i < 3; i++) {
                Arrays.fill(chessboard[i], -1);
            }
            int val = 1;
            for (int[] move : moves) {
                val = val ^ 1;
                chessboard[move[0]][move[1]] = val;
            }
            int lastRow = moves[len -1][0];
            int lastCol = moves[len -1][1];
            val = chessboard[lastRow][lastCol];
            boolean b = checkGameResult(chessboard, lastRow, lastCol, val);
            if (b) {
                return val == 0? "A" : "B";
            }
            if (len == 9) {
                return "Draw";
            }
            return "Pending";
        }

        /**
         * 判定这一步的游戏结果，
         * @param chessboard
         * @param row
         * @param col
         * @param val
         * @return
         */
        private boolean checkGameResult (int[][] chessboard, int row, int col, int val) {
            //check行
            int i ;
            for (i= 0; i < 3; i++) {
                if (chessboard[row][i] == -1 || chessboard[row][i] != val) {
                    break;
                }
            }
            if (i == 3) {
               return true;
            }

            //check列
            for (i= 0; i < 3; i++) {
                if (chessboard[i][col] == -1 || chessboard[i][col] != val) {
                    break;
                }
            }
            if (i == 3) {
                return true;
            }

            //对角线 五个点
            if ((row == 0 && col == 0)) {
                if (chessboard[1][1] == val && chessboard[2][2] == val) {
                    return true;
                } else return false;
            } else if ((row == 1 && col == 1)){
                if ((chessboard[0][0] == val && chessboard[2][2] == val)
                        || (chessboard[0][2] == val && chessboard[2][0] == val)) {
                    return true;
                } else return false;

            } else if ((row == 2 && col == 2)){
                if (chessboard[0][0] == val && chessboard[1][1] == val) {
                    return true;
                } else return false;

            } else if ((row == 0 && col == 2)){
                if (chessboard[1][1] == val && chessboard[2][0] == val) {
                    return true;
                } else return false;

            } else if ((row == 2 && col == 0)){
                if (chessboard[1][1] == val && chessboard[0][2] == val) {
                    return true;
                } else return false;
            }else return false;
        }
    }

    public static void main(String[] args) {


        logger.info("{}", new Solution().tictactoe(
                new int[][]{
                        {2,2},{0,2},{1,0},{0,1},{2,0},{0,0}
                }
        ));//B

        logger.info("{}", new Solution().tictactoe(
                new int[][]{
                        {0,0},{2,0},{1,1},{2,1},{2,2}
                }
        ));//A
        logger.info("{}", new Solution().tictactoe(
                new int[][]{
                        {0,0},{1,1},{0,1},{0,2},{1,0},{2,0}
                }
        ));//B
        logger.info("{}", new Solution().tictactoe(
                new int[][]{
                        {0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}
                }
        ));//Draw
        logger.info("{}", new Solution().tictactoe(
                new int[][]{
                        {0,0},{1,1}
                }
        ));//Pending




    }
}
