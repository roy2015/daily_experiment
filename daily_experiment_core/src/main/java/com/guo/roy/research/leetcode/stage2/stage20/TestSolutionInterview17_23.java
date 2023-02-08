package com.guo.roy.research.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/23
 *
 * 面试题 17.23. 最大黑方阵
 * 给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。
 *
 * 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *    [1,0,1],
 *    [0,0,1],
 *    [0,0,1]
 * ]
 * 输出: [1,0,2]
 * 解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
 * 示例 2:
 *
 * 输入:
 * [
 *    [0,1,1],
 *    [1,0,1],
 *    [1,1,0]
 * ]
 * 输出: [0,0,1]
 * 提示：
 *
 * matrix.length == matrix[0].length <= 200
 *
 */
public class TestSolutionInterview17_23 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview17_23.class);

    /**
     * matrix.length == matrix[0].length <= 200, 正方形矩阵
     *
     */
    static class Solution {

        /**
         *
         * 持续思考优化，总算96%了，开始107ms，有点吓人，只优化了一点就避免重复走了好多循环
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 7 ms, 在所有 Java 提交中击败了96.46%的用户
         * 内存消耗：
         * 47.7 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param matrix
         * @return
         */
        public int[] findSquare(int[][] matrix) {
            if (matrix.length == 0 ) {
                return new int[]{};
            }
            int r , c, size;
            int len = matrix.length;
            r = c = 0;
            size = 0;

            for (int i = 0; i < len ; i++) {
                 if((i + size + 1) > len) {//纵向找不到更大的矩阵
                     break;
                 }
                for (int j = 0; j < len; ) {
                    /*if (matrix[i][j] ==1) {
                        break;
                    }*/
                    if (size == 0) {
                        if (validateBorder(i, j, 1, matrix, len) == 1) {
                            r = i;
                            c = j;
                            size = size + 1 ;
                        } else {
                            j ++;
                        }
                    } else {//至少有1
                        int candidateSize = size + 1;
                        //向右扩张（同时也是向下）
                        while (((j + candidateSize) <= len)) {//横向满足能找到更大的矩阵的基本条件
                            int checkBorder = validateBorder(i, j, candidateSize, matrix, len);
                            if (checkBorder == 1) {
                                r = i;
                                c = j;
                                size = candidateSize;
                                //此时不能
                            } else if (checkBorder == -1) {//横向不满足的话就不用向右边扩张了，break;
                                break;
                            } else {
                                //尽管不满足，但不能break, 因为可能满足更大的矩阵
                            }
                            candidateSize ++;
                        }
                        j++;
                    }
                }
            }
            if (size == 0 ) {
                return new int[]{};
            } else
            return new int[]{r, c , size};
        }


        /**
         * 验证四条边
         * @param r
         * @param c
         * @param size
         * @param matrix
         * @return
         */
        private int validateBorder(int r, int c, int size, int[][] matrix, int len) {
            if (r + size > len || c +size > len) {
                return 0;
            }

            //右
            int i;
            for (i = c; i <c+size; i ++) {
                if (matrix[r][i] ==  1) {
                    return -1;
                }
            }
            //下
            for (i = r; i < r+size; i ++) {
                if (matrix[i][c + size -1] ==  1) {
                    return 0;
                }
            }
            //左
            for (i = c + size -1 ; i >= c; i --) {
                if (matrix[r + size - 1][i] ==  1) {
                    return 0;
                }
            }
            //上
            for (i = r + size -1 ; i >= r; i --) {
                if (matrix[i][c] ==  1) {
                    return 0;
                }
            }
            return 1;
        }

    }

    public static void main(String[] args) {
        logger.info("{}" , new Solution().findSquare(new int[][]{
                {1, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 0, 1, 1, 1}
        }));//1 4 3


        logger.info("{}" , new Solution().findSquare(new int[][]{
                {0, 0, 0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 1, 0, 0, 1, 1},
                {0, 0, 0, 1, 1, 0, 0, 1, 1, 1}
        }));// 0 0 2

        logger.info("{}" , new Solution().findSquare(new int[][]{
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0}
        }));// 5 3 2

        logger.info("{}" , new Solution().findSquare(new int[][]{
                {1}
        }));//[]


        logger.info("{}" , new Solution().findSquare(new int[][]{
                {1,0,1},
                {0,0,1},
                {0,0,1}
        }));//1 0 2

        logger.info("{}" , new Solution().findSquare(new int[][]{
                {0,1,1},
                {1,0,1},
                {1,1,0}
        }));//0 0 1
        int k = 0;

    }
}
