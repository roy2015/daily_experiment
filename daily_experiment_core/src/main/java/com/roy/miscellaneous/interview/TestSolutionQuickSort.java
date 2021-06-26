package com.roy.miscellaneous.interview;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 *
 * 快速排序
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolutionQuickSort {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionQuickSort.class);


    static class Solution {

        public void testQuickSort(int [] srcArray) {
            doQuickSort(0, srcArray.length-1, srcArray);
        }

        /**
         *
         * @param starIdx  开始区间
         * @param endIdx  结束区间
         * @param srcArray
         */
        private void doQuickSort(int starIdx, int endIdx, int[] srcArray) {
            if (starIdx  >= endIdx) {
                return;
            }

            int low = starIdx;
            int high = endIdx;
            int base = low;
            int baseVal = srcArray[base];

            while (true) {
                //找到第一个比low小的
                while (high > low && srcArray[high] >= baseVal) {
                    high --;
                }
                if (high == low) {
                    break;
                }
                srcArray[low] = srcArray[high];

                low ++;
                while (high > low && srcArray[low] <= baseVal) {
                    low ++;
                }
                if (high == low) {
                    break;
                }

                srcArray[high] = srcArray[low];
                high --;
            }

            srcArray[low] = baseVal;

            //向左， 向右
            doQuickSort(starIdx, low-1, srcArray);
            doQuickSort(low +1, endIdx, srcArray);
        }

        public void print(int[] array) {
            for (int anInt : array) {
                System.out.print(anInt);
                System.out.print(" ");
            }
        }

    }

    public static void main(String[] args) {
//        int[] ints = {49, 38, 65, 97, 76, 13,27,49};
        int[] ints = {49, 48, 47, 46, 45, 44,43,42};
        Solution solution = new Solution();
        solution.print(ints);
        solution.testQuickSort(ints);
        System.out.println();
        solution.print(ints);
    }
}
