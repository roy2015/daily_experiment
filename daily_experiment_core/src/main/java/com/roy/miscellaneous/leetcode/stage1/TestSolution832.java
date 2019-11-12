package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/31.
 *给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

 示例 1:

 输入: [[1,1,0],[1,0,1],[0,0,0]]
 输出: [[1,0,0],[0,1,0],[1,1,1]]
 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 示例 2:

 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 说明:

 1 <= A.length = A[0].length <= 20
 0 <= A[i][j] <= 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/flipping-an-image
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution832 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution832.class);

    /**
     *   12345  4  0-2
     *   123456   5  0-2
     *
     *   0 1
     *   1 0
     *
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :37.7 MB, 在所有 java 提交中击败了92.62%的用户
     */
    static class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            int column;
            int tmp;
            for (int i = 0; i < A.length; i++) {
                column = A[i].length;
                for (int j = 0; j <= (column -1) /2; j++) {
                    tmp = 1 ^ A[i][j];
                    A[i][j] = 1 ^ A[i][column -1 - j];
                    A[i][column -1 - j] = tmp;
                }
            }
            return A;
        }
    }

    public static void main(String[] args) {
        int[][] ints = new Solution().flipAndInvertImage(new int[][]{
                {1, 1, 0}, {1, 0, 1}, {0, 0, 0}
        });
        logger.info("{}");
    }

}
