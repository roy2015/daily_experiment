package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 旋转图像
 *
 * Created by apple on 2019/8/28.
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 *
 *  采用 洋葱循环，像剥洋葱一层层处理
 */
public class TestSolution48 {
    public static Logger LOGGER = LoggerFactory.getLogger(TestSolution48.class);

    /**
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :36.1 MB, 在所有 java 提交中击败了59.69%的用户
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int loop = 0;
        for (int i = 0, j = 0; i < size / 2; i++, j++, loop = loop + 2) {
            for (int k = 0; k < size - 1 - loop; k++) {
                int temp = matrix[i][j + k];
                //第一顶点  matrix[i][j] -> 向右  j++
                //第二顶点  matrix[j][size-1-i] -> 向下  j++
                //第三顶点 matrix[siz-1-i][size-1-j] - 左
                //第四顶点 matrix[size-1-j][i] - 上
                matrix[i][j + k] = matrix[size - 1 - i - k][i];
                matrix[size - 1 - i - k][i] = matrix[size - 1 - i][size - 1 - j - k];
                matrix[size - 1 - i][size - 1 - j - k] = matrix[j + k][size - 1 - i];
                matrix[j + k][size - 1 - i] = temp;
//                printMatrix(matrix);
            }
            printMatrix(matrix);

        }
    }

    public void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(StringUtils.leftPad(matrix[i][j] + "", 3)).append("  ");
            }
            LOGGER.info("{}", stringBuilder.toString());
        }
        LOGGER.info("=====================");
    }

    public static void main(String[] args) {

        int dimension = 5;
        int seed = 0;
        int[][] ints = new int[dimension][dimension];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length ; j++) {
                ints[i][j] = ++seed;
            }
        }

        TestSolution48 testSolution48 = new TestSolution48();
        LOGGER.info("======旋转前========");
        testSolution48.printMatrix(ints);
        LOGGER.info("======开始旋转========");
        testSolution48.rotate(ints);
        LOGGER.info("======旋转后========");
        testSolution48.printMatrix(ints);
    }


}
