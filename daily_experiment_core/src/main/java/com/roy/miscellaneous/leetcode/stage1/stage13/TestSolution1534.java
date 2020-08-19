package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/18
 *
 *
 * 1534. 统计好三元组
 * 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
 *
 * 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 *
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * 其中 |x| 表示 x 的绝对值。
 *
 * 返回 好三元组的数量 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * 输出：4
 * 解释：一共有 4 个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] 。
 * 示例 2：
 *
 * 输入：arr = [1,1,2,2,3], a = 0, b = 0, c = 1
 * 输出：0
 * 解释：不存在满足所有条件的三元组。
 *
 *
 * 提示：
 *
 * 3 <= arr.length <= 100
 * 0 <= arr[i] <= 1000
 * 0 <= a, b, c <= 1000
 *
 *
 *
 *
 */
public class TestSolution1534 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1534.class);


    static class Solution {

        /**
         *
         * 借鉴了官方思路二 牛X的思路，没有采用O(n^3)暴力破解
         * 关键点： 记录走过的元素出现的频次以备用
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 13 ms
         * , 在所有 Java 提交中击败了
         * 96.23%
         * 的用户
         * 内存消耗：
         * 37.9 MB
         * , 在所有 Java 提交中击败了
         * 5.14%
         * 的用户
         *
         *
         * @param arr
         * @param a
         * @param b
         * @param c
         * @return
         */
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int[] numFrequencyArrays = new int[1001];
            int ret = 0;
            int len = arr.length;
            int jVal,j;
            for (j = 0; j < len -1; j++) {
                jVal = arr[j];
                for (int k = j + 1; k < len; k++) {
                    int kVal = arr[k];
                    if (Math.abs(jVal - kVal) <= b) {
                        int lj = Math.max(0, jVal - a);
                        int rj = Math.min(1000, jVal + a);
                        int lk = Math.max(0, kVal - c);
                        int rk = Math.min(1000, kVal + c);
                        int l = Math.max(lj, lk);
                        int r = Math.min(rj, rk);
                        if (l <= r) {
                            if (l == r) {
                                ret += numFrequencyArrays[l];
                            } else {
                                for (int i = l; i <= r ; i++) {
                                    ret += numFrequencyArrays[i];
                                }
                            }
                        } else {//区间不正确
                            //do nothing
                        }
                    }
                }
                numFrequencyArrays[jVal] ++;
            }
            return ret;
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().countGoodTriplets(
                new int[]{1,1,2,2,3}, 0,0,1
        ));//0

        logger.info("{}", new Solution().countGoodTriplets(
                new int[]{3,0,1,1,9,7}, 7,2,3
                ));//4
    }
}
