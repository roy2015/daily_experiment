package com.roy.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution2326 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution2326.class);

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     *
     *
     * 本质上还是剥洋葱
     *
     * 执行结果：通过
     * 显示详情
     * 添加备注
     *
     * 执行用时：7 ms, 在所有 Java 提交中击败了81.23%的用户
     * 内存消耗：59 MB, 在所有 Java 提交中击败了83.58%的用户
     * 通过测试用例：50 / 50
     *
     *
     */
    static class Solution {
        public int[][] spiralMatrix(int m, int n, ListNode head) {
            if (m ==0 || n ==0) {
                return new int[][]{};
            }

            int[][] matrix = new int[m][n];
            ListNode renderer = head;

            for (int i = 0; i < m; i++) {
                Arrays.fill(matrix[i], -1);
            }

            List<Integer> storeList = new ArrayList<>();
            //剥洋葱，每剥一次矩阵行列长度减2，开始元素行列坐标加1
            for (int startRow=0 , startCol =0; m >= 1 && n >=1 && renderer != null; m-=2,n-=2, startRow++, startCol++) {
                renderer = goOneLayer(matrix, m, n, startRow, startCol, renderer);
            }
            return matrix;
        }

        private ListNode goOneLayer(int[][] matrix, int row, int col, int idxRow, int idxCol, ListNode renderer) {
            if (col < 1 || row < 1 || renderer == null) {
                return null;
            }

            int rightColIdx = idxCol + col - 1;
            int downRowIdx = idxRow + row - 1;
            //只有一列
            if (col == 1) {
                //向下结束
                for (int i = 0; i < row ; i++) {
                    if (renderer == null) {
                        return null;
                    }
                    matrix[idxRow + i][rightColIdx] = renderer.val;
                    renderer = renderer.next;
                }
                return null;
            }

            //多列，向右
            for (int i = 0; i < col; i++) {
                if (renderer == null) {
                    return null;
                }
                matrix[idxRow][idxCol + i] = renderer.val;
                renderer = renderer.next;
            }

            //只有一列， 不用向下，结束
            if (row == 1) {
                return null;
            }

            //向下
            for (int i = 1; i < row; i++) {
                if (renderer == null) {
                    return null;
                }
                matrix[idxRow + i][rightColIdx]= renderer.val;
                renderer = renderer.next;
            }

            //多行， 向左
            for (int i = rightColIdx - 1; i >= idxCol; i--) {
                if (renderer == null) {
                    return null;
                }
                matrix[downRowIdx][i] = renderer.val;
                renderer = renderer.next;
            }
            //向上
            for (int i = idxRow + row - 2; i > idxRow; i--) {
                if (renderer == null) {
                    return null;
                }
                matrix[i][idxCol] = renderer.val;
                renderer = renderer.next;
            }
            return renderer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix;
        ListNode head = new ListNode(3);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);

        matrix = solution.spiralMatrix(3,5, head);
        logger.info("{}", solution);
    }
}
