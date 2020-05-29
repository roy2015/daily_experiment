package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by apple on 2019/10/22.
 *给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:

 输入: 3
 输出: [1,3,3,1]
 进阶：

 你可以优化你的算法到 O(k) 空间复杂度吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 *
 */
public class TestSolution119 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution119.class);

    /**
     *
     *
     *
     */
    static class Solution {
        /**
         * 执行用时 :1 ms, 在所有 java 提交中击败了97.04%的用户
         内存消耗 :33.8 MB, 在所有 java 提交中击败了22.20%的用户
         * @param rowIndex
         * @return
         */
        public List<Integer> getRow(int rowIndex) {
            Integer[] row1 = getSubRow(rowIndex);
            return Arrays.asList(row1);
        }

        /**
         * 执行用时 :1 ms, 在所有 java 提交中击败了97.04%的用户
         内存消耗 :33.5 MB, 在所有 java 提交中击败了27.45%的用户
         * @param rowIndex
         * @return
         */
        public List<Integer> getRow1(int rowIndex) {
            List<Integer> list = new ArrayList<>();
            getSubRow1(rowIndex, list);
            return list;
        }

        /**
         * 执行用时 :1 ms, 在所有 java 提交中击败了97.04%的用户
         内存消耗 :33.7 MB, 在所有 java 提交中击败了22.67%的用户
         * @param rowIndex
         * @return
         */
        public List<Integer> getRow2(int rowIndex) {
            int[] ints = new int[rowIndex+1];
            Arrays.fill(ints, 1);
            getSubRow2(rowIndex, ints);
            ArrayList<Integer> arrayList = new ArrayList<>(rowIndex+1);
            for (int anInt : ints) {
                arrayList.add(anInt);
            }
            return arrayList;
        }

        private Integer[] getSubRow(int rowIndex) {
            if (rowIndex ==0) {
                return new Integer[]{new Integer(1)};
            }
            if (rowIndex ==1) {
                return new Integer[]{new Integer(1),new Integer(1)};
            }

            Integer[] preRowData = getSubRow(rowIndex - 1);
            Integer[] curRowData = new Integer[rowIndex +1];
            curRowData[0] =1;
            curRowData[rowIndex] = 1;
            for (int i = 1; i < rowIndex ; i++) {
                curRowData[i] = preRowData[i-1] + preRowData[i];
            }
            return curRowData;
        }

        private void getSubRow1(int rowIndex, List<Integer> list) {
            if (rowIndex ==0) {
                list.add(new Integer(1));
                return;
            }
            if (rowIndex ==1) {
                list.add(new Integer(1));
                list.add(new Integer(1));
                return;
            }

            getSubRow1(rowIndex - 1, list);
            int m =1 ,n;
            for (int i = 1; i < rowIndex ; i++) {
                n = list.get(i);
                list.set(i, m + n);
                m = n;
            }
            list.add(1);
        }



        private void getSubRow2(int rowIndex, int [] arry) {
            if (rowIndex ==0) {
                arry[0] = 1;
                return;
            }
            if (rowIndex ==1) {
                arry[0] = 1;
                arry[1] = 1;
                return;
            }

            getSubRow2(rowIndex - 1, arry);
            int m =1 ,n;
            for (int i = 1; i < rowIndex ; i++) {
                n = arry[i];
                arry[i] = m + n;
                m = n;
            }
            arry[rowIndex] = 1;
        }


    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().getRow2(7));
    }

}
