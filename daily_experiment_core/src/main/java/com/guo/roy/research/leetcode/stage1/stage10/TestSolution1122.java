package com.guo.roy.research.leetcode.stage1.stage10;

import java.util.Arrays;
import java.util.BitSet;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/11/06
 *
 *
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 */
public class TestSolution1122 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1122.class);


    static class Solution {

        /**
         *
         * 二分查找 + 排序， 2ms可以考虑再优化一下
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：2 ms, 在所有 Java 提交中击败了46.65%的用户
         * 内存消耗：38.5 MB, 在所有 Java 提交中击败了51.71%的用户
         *
         *
         * @param arr1
         * @param arr2
         * @return
         */
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int arr1Len = arr1.length;
            int arr2Len = arr2.length;
            if (arr1Len == 0) {
                return arr1;
            }
            Arrays.sort(arr1);
            int[] retInts = new int[arr1Len];
            int k = 0;

            BitSet dic = new BitSet();
            for (int i = 0; i < arr2Len; i++) {
                int arr2Val = arr2[i];
                dic.set(arr2Val);
                int idx = Arrays.binarySearch(arr1, arr2Val);
                int p = idx -1 , q = idx +1;
                retInts[k ++] = arr2Val;

                while (p >=0 && arr1[p] == arr2Val) {
                    retInts[k ++] = arr2Val;
                    p --;
                }
                while ( q < arr1Len  && arr1[q] == arr2Val ) {
                    retInts[k ++] = arr2Val;
                    q ++;
                }
            }
            for (int i = 0; i < arr1Len; i++) {
                int arr1Val = arr1[i];
                if (dic.get(arr1Val) == false) {
                    retInts[k ++] = arr1Val;
                }
            }
            return retInts;
        }
    }
    public static void main(String[] args) {
        logger.info("{}", new Solution().relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},
                new int[]{2,1,4,3,9,6}));//2,2,2,1,4,3,3,9,6,7,19

        logger.info("{}", new Solution().relativeSortArray(new int[]{},
                new int[]{2,1,4,3,9,6}));//[]

        logger.info("{}", new Solution().relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},
                new int[]{}));//1, 2, 2, 2, 3, 3, 4, 6, 7, 9, 19

    }
}
