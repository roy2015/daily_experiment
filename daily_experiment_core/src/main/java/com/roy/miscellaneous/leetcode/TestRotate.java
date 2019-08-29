package com.roy.miscellaneous.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/8/28.
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

 示例 1:

 给定 matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 原地旋转输入矩阵，使其变为:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/rotate-image
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestRotate {
    public static Logger LOGGER = LoggerFactory.getLogger(TestRotate.class);

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int k = i;
            for (int j = matrix[i].length -1 ; j >= 0; j--, k--) {
                int size = matrix[i].length;
                int m = 0,n =0 ;

                if (i != 0 && j >= size - i ) {
                    int tmpI = i, tmpJ =j;
                    for (int loop = k; loop > 0   ; loop-- ) {
                        m = size -1 - tmpJ;
                        n = tmpI;

                        tmpI = m;
                        tmpJ = n;
                    }
                    /*m = size -1 - j;
                    n = i;*/

                    if (n < j ) {
                        int tmp = matrix[m][n];
                        matrix[m][n] = matrix[j][size -1 - i ];
                        matrix[j][size -1 - i ] = tmp;
                    }



                } /*else if ( i == (size -1) && j ==0 ) {

                } */else {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][size - 1 - i];
                    matrix[j][size - 1 - i] = tmp;
                }
            }
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                LOGGER.info("{}", matrix[i][j]);
            }
            LOGGER.info("=============");
        }
    }

    public static void main(String[] args) {
        int[][] ints = new int[][] {{1,2,3, 4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] ints = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        TestRotate testRotate = new TestRotate();
        testRotate.printMatrix(ints);
        testRotate.rotate(ints);
        testRotate.printMatrix(ints);
    }


}
