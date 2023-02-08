package com.roy.leetcode.stage1.stage13;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/2
 *
 * 1346. 检查整数及其两倍数是否存在
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 *
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 *
 * 示例 1：
 *
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * 示例 2：
 *
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * 示例 3：
 *
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 *
 *
 * 提示：
 *
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 */
public class TestSolution1346 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1346.class);


    static class Solution {

        /**
         * 也是有个坑 0的处理，2*0还是0，一个0还是false，两个0就是true,不能用查找（处理不了重复元素），
         * 必须用map缓存使用过的元素，
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 2 ms, 在所有 Java 提交中击败了84.44%的用户
         * 内存消耗：
         * 39.2 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         *
         * @param arr
         * @return
         */
        public boolean checkIfExist(int[] arr) {
            Set<Integer> map =  new HashSet();
            for(int i = 0; i < arr.length; i++) {
                int iVal = arr[i];
                int iVal_2 = 2 * arr[i];

                if (map.contains(iVal_2)) {
                    return true;
                }


                if ((iVal & 1) == 0) {//偶数，看他的二分之一在不在
                    int iVal_12 = iVal /2;
                    if (map.contains(iVal_12)) {
                        return true;
                    }
                }
                map.add(iVal);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().checkIfExist(new int[]{0,0,5,3}));
        logger.info("{}", new Solution().checkIfExist(new int[]{10,2,5,3}));
    }
}
