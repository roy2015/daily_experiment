package com.roy.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/14.
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

 数字 1-9 在每一行只能出现一次。
 数字 1-9 在每一列只能出现一次。
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-sudoku
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution36 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution36.class);

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            List<Integer> list = new ArrayList<>();
            boolean isValidRowCheck = true;
            boolean isValidColoumCheck = true;
            boolean isValid33Check = true;
            //1
            for (int i = 0; i < 9; i++) {
                list.clear();
                isValidRowCheck = true;
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        if ( ! list.isEmpty() && list.contains(board[i][j] - '0')) {
                            isValidRowCheck = isValidRowCheck && false;
                            logger.info("行重复, ({},{}):[]", i,j ,board[i][j] - '0');
                            break;
                        } else {
                            list.add(board[i][j] - '0');
                        }
                    } else {
                        list.add(0);
                    }
                }
                if (!isValidRowCheck) {
                    return false;
                }
            }

            //2
            for (int i = 0; i < 9; i++) {
                list.clear();
                isValidColoumCheck = true;
                for (int j = 0; j < 9; j++) {
                    if (board[j][i] != '.') {
                        if ( ! list.isEmpty() && list.contains(board[j][i] - '0')) {
                            isValidColoumCheck = isValidColoumCheck && false;
                            logger.info("列重复, ({},{}):[]", j,i ,board[j][i] - '0');
                            break;
                        } else {
                            list.add(board[j][i] - '0');
                        }
                    } else {
                        list.add(0);
                    }
                }
                if (!isValidColoumCheck) {
                    return false;
                }
            }

            /* 3
              00 03 06
              30 33 36
              60 63 66
             */
            for (int i =0; i<=6; i=i+3) {
                for (int j = 0; j <=6 ; j=j+3) {
                    int m =i, n= j;
                    list.clear();
                    isValid33Check = true;
                    for (int k1 = m; k1 < m+3; k1++) {
                        for (int k2 = n; k2 < n + 3; k2++) {
                            if (board[k1][k2] != '.') {
                                if ( ! list.isEmpty() && list.contains(board[k1][k2] - '0')) {
                                    isValid33Check = isValid33Check && false;
                                    logger.info("3*3重复, ({},{}):[]", k1,k2 ,board[k1][k2] - '0');
                                    break;
                                } else {
                                    list.add(board[k1][k2] - '0');
                                }
                            } else {
                                list.add(0);
                            }
                            if (!isValid33Check) {
                                break;
                            }
                        }
                        if (!isValid33Check) {
                            break;
                        }
                    }
                    if (!isValid33Check) {
                        return false;
                    }
                }
            }

            return true;

        }

    }

    public static void main(String[] args) {
        char[][] chars = {
                {'.','.','4',  '.','.','.',  '6','3','.'},
                {'.','.','.',  '.','.','.',  '.','.','.'},
                {'5','.','.',  '.','.','.',  '.','9','.'},

                {'.','.','.',  '5','6','.',  '.','.','.'},
                {'4','.','3',  '.','.','.',  '.','.','1'},
                {'.','.','.',  '7','.','.',  '.','.','.'},

                {'.','.','.',  '5','.','.',  '.','.','.'},
                {'.','.','.',  '.','.','.',  '.','.','.'},
                {'.','.','.',  '.','.','.',  '.','.','.'}

        };
        boolean validSudoku = new Solution().isValidSudoku(chars);
        logger.info("{}",validSudoku);
    }


}
