package com.guo.roy.research.misc.cryptography;

import org.slf4j.LoggerFactory;

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
            doQuickSort1(0, srcArray.length-1, srcArray);
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


        /**
         * 练习20210726
         * @param starIdx
         * @param endIdx
         * @param srcArray
         */
        private void doQuickSort1(int starIdx, int endIdx, int[] srcArray) {
            //只有一个元素，直接return
            if (endIdx == starIdx) {
                return;
            }
            //只有两个元素，直接排序
            if (endIdx - starIdx == 1) {
                if (srcArray[starIdx] > srcArray[endIdx]) {
                    int temp = srcArray[starIdx];
                    srcArray[starIdx] = srcArray[endIdx];
                    srcArray[endIdx] = temp;
                    return;
                }
            }


            int baseVal = srcArray[starIdx];
            int low = starIdx;
            int high = endIdx;
            while (true) {
                //从后往前，找到一个小于base的元素
                while (srcArray[high] >= baseVal && low != high) {
                    high --;
                }
                if (low == high) {
                    break;
                }
                srcArray[low] = srcArray[high];

                //从前往后，找到一个大于base的元素
                while (srcArray[low] <= baseVal && low != high) {
                    low ++;
                }
                if (low == high) {
                    break;
                }
                srcArray[high] = srcArray[low];

            }
            srcArray[high] = baseVal;
            //左边（能拆）
            if (high != starIdx) {
                doQuickSort1(starIdx ,high -1, srcArray);
            }
            //右边（能拆）
            if (high != endIdx) {
                doQuickSort1(high +1 ,endIdx, srcArray);
            }
        }

        public void print(int[] array) {
            for (int anInt : array) {
                System.out.print(anInt);
                System.out.print(" ");
            }
        }

    }

    public static void main(String[] args) {
        int[] ints = {49, 38, 65, 97, 76, 13,27,49};
//        int[] ints = {49, 48, 47, 46, 45, 44,43,42};
//        int[] ints = {42,43,44,45,46,47,48,49};
        Solution solution = new Solution();
        solution.print(ints);
        solution.testQuickSort(ints);
        System.out.println();
        solution.print(ints);
    }
}
