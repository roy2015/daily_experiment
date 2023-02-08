package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/25
 *
 * 189. 旋转数组
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 *
 */
public class TestSolution189 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution189.class);


    static class Solution {

        /**
         *
         * 算法时间复杂度  O(n + k), 空间复杂度 O(k),  如果循环移动的话，时间复杂度是 O(3n)
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :40.7 MB, 在所有 Java 提交中击败了7.14%的用户
         *
         * @param nums
         * @param k
         */
        public void rotate(int[] nums, int k) {
            int[] reserve = new int[k];
            int len = nums.length;
            k = k % len;
            //尾部挪走
            for (int i = 0; i < k ; i++) {
                reserve[k -1 - i] = nums[len - 1 - i];
            }

            //占据尾部
            for (int i = len -1 - k; i >= 0 ; i--) {
                nums[i + k] = nums[i];
            }
            //补充头部
            for (int i = 0; i < k ; i++) {
                nums[i] = reserve[i] ;
            }
        }

    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5,6,7};
        new Solution().rotate(ints , 3);
        int k =0;
    }
}
