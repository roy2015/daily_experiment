package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/9.
 *给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。

 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。

 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。

 示例 1:

 输入:
 nums =
 [[1,2],
 [3,4]]
 r = 1, c = 4
 输出:
 [[1,2,3,4]]
 解释:
 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 示例 2:

 输入:
 nums =
 [[1,2],
 [3,4]]
 r = 2, c = 4
 输出:
 [[1,2],
 [3,4]]
 解释:
 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 注意：

 给定矩阵的宽和高范围在 [1, 100]。
 给定的 r 和 c 都是正数。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution566 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution566.class);

    /**
     *取模求余
     *
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100%的用户
     内存消耗 :38.9  MB, 在所有 Java 提交中击败了97.17%的用户
     */
    static class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int row = 0, colmn = 0;
            if (nums == null) {
                return nums;
            }
            colmn = nums[0].length;
            row = nums.length;
            if (r * c != colmn * row) {
                return nums;
            }

            int[][] ints = new int[r][c];
            int count = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ints[i][j] = nums[count / colmn][ count % colmn ];
                    count++;
                }
            }

            return ints;
        }


        /**
         * 转化成 1*n 矩阵，再赋值
         *
         * 执行用时 :2 ms, 在所有 Java 提交中击败了92.87%的用户
         内存消耗 :38.9  MB, 在所有 Java 提交中击败了97.80%的用户
         */
        public int[][] matrixReshape1(int[][] nums, int r, int c) {
            int row = 0, colmn = 0;
            if (nums == null) {
                return nums;
            }
            colmn = nums[0].length;
            row = nums.length;
            if (r * c != colmn * row) {
                return nums;
            }

            int[] oneLineNums = new int[r * c];
            int k =0;
            for (int[] num : nums) {
                for (int i : num) {
                    oneLineNums[k ++] = i;
                }
            }
            k =0;
            int[][] ints = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ints[i][j]  = oneLineNums[k++];
                }
            }

            return ints;
        }

        /**
         * 直接循环原矩阵，填充新矩阵，相比与第一种，减少了不少if判断时间，所以能击败 100%
         *
         * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :42.9 MB, 在所有 Java 提交中击败了84.59%的用户
         * @param nums
         * @param r
         * @param c
         * @return
         */
        public int[][] matrixReshape2(int[][] nums, int r, int c) {
            if (nums == null) {
                return nums;
            }
            if (r * c != nums[0].length * nums.length) {
                return nums;
            }

            int[][] ints = new int[r][c];
            int rowIdx =0, colIdx =0;
            for (int[] num : nums) {
                for (int i : num) {
                    if (colIdx == c ) {
                        colIdx = 0;
                        rowIdx ++;
                    }
                    ints[rowIdx][colIdx++] = i;
                }
            }
            return ints;
        }
    }

    public static void main(String[] args) {
        int[][] ints = new Solution().matrixReshape(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        }, 3, 2);
        logger.info("{}");
    }

}
