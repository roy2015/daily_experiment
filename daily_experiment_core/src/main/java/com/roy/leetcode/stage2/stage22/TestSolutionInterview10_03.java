package com.roy.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/18
 *
 * 面试题 10.03. 搜索旋转数组
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。
 * 若有多个相同元素，返回索引值最小的一个。
 *
 * 示例1:
 *
 *  输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 *  输出: 8（元素5在该数组中的索引）
 * 示例2:
 *
 *  输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 *  输出：-1 （没有找到）
 * 提示:
 *
 * arr 长度范围在[1, 1000000]之间
 *
 */
public class TestSolutionInterview10_03 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview10_03.class);



    static class Solution {
        /**
         *
         *
         *
         * 典型的二分查找，虽说是二分查找，但有诸多细节要考虑， 自己写出来了
         *
         * 分割成两个递增数组（也可能只有一个）后两个二分查找
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：41 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param arr
         * @param target
         * @return
         */
        public int search(int[] arr, int target) {
            int length = arr.length;
            if (length == 1) {
                if (target == arr[0]) {
                    return 0;
                } else {
                    return -1;
                }
            }

            int seg1Start;
            int seg1End;
            int seg2Start ;
            int seg2End;

            int seg1StartVal;
            int seg1EndVal;
            int seg2StartVal;
            int seg2EndVal;

            seg1Start = 0;
            seg2Start =-1;
            //找两个segment的分界点，即"突降点"，没有表示没有旋转全部递增
            for (int i = seg1Start + 1; i < length ; i++) {
                if (arr[i] < arr[i -1]) {
                    seg2Start = i;
                    break;
                }
            }
            seg1StartVal = arr[0];
            if (seg2Start == -1) {//只有一个区间，直接一个二分查找
                seg1EndVal = arr[length -1];
                seg1End = length -1;

                if (target >= seg1StartVal && target <= seg1EndVal) {
                    return binarySearch(arr, seg1Start, seg1End, length, target);
                } else  return -1;
            } else {//两段二分查找
                seg2StartVal = arr[seg2Start];
                seg1End = seg2Start -1;
                seg1EndVal = arr[seg1End];
                seg2End = length -1;
                seg2EndVal = arr[seg2End];

                if (target >= seg1StartVal && target <= seg1EndVal) {//第一个区间里
                    return binarySearch(arr, seg1Start, seg1End, length, target);
                } else if (target >= seg2StartVal && target <= seg2EndVal) {//第二个区间里
                    return binarySearch(arr, seg2Start, seg2End, length, target);
                } else  return -1;
            }
        }

        /**
         *
         * 二分查找（增强），找第一个相等的值
         *
         * @param arr
         * @param start
         * @param end
         * @param len
         * @param target
         * @return
         */
        public int binarySearch(int[] arr, int start, int end, int len ,  int target) {
            int low = start; int high = end ;
            while (low <= high) {
                int mid = (low + high) /2;
                int midVal = arr[mid];
                if (midVal == target) {
                    //相同的值找最小index的
                    int i = mid;
                    while ((i - 1 >= start) &&
                            (arr[i-1] == target)) {
                        i --;
                    }
                    return i;
                } else if (target > midVal) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            //not found
            return -1;
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().search(new int[]
                {1, -2}, -2));//1

        logger.info("{}", new Solution().search(new int[]
                {1, 4, 4, 5, 5, 12, 17, 17, 20, 20, 21, 22, 22, 24, 24, 27, 29, 30, 32, 41, 41, 45, 45, 46, 47, 49, 53, 57, 57, 63, 63, -63, -63, -62,
                        -56, -52, -48, -47, -44, -43, -43, -42, -41, -39, -39, -37, -34, -33, -32, -32, -29, -26, -25, -23, -16, -13, -11, -8, -7, -7,
                        -6, -4, -2, -2}, -23));//53

        logger.info("{}", new Solution().search(new int[]
                {5,5,5,1,2,3,4,5}, 5));//0

        logger.info("{}", new Solution().search(new int[]
        {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));//8

        logger.info("{}", new Solution().search(new int[]
                {13,15,1,12,12}, 12));//3

    }
}
