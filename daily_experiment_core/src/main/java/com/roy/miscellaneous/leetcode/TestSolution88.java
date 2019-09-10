package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/6.
 *
 *给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 用了两种方法， merge是常规的从前往后， merge1是从后往前
 思路很重要，从后往前才是正解O(m+n)， 从前往后把问题复杂化了，复杂度还高！,不过复杂化的能解决也是可以的。
 还有更偷懒的借助工具，合并数组，再调用api排序
 */
public class TestSolution88 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution88.class);

    /**
     *
     * nums1 = [1,2,3,0,0,0], m = 3
     nums2 = [2,5,6],       n = 3
     */
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {

            int i = 0;
            boolean inserted;
            for (int j = 0; j < n; j++) {
                inserted = false;
                for (; i < m + j; ) {

                    if (nums2[j] >= nums1[i]) {
                        i ++;
                    } else {//找到小于的，移动后面的元素让出位置
                        for (int k = m   +j; k > i; k--) {
                            nums1[k] = nums1[k-1];
                        }
                        nums1[i] = nums2[j];
                        i++;
                        inserted = true;
                        break;
                    }
                }
                if (!inserted) {//比所有都大
                    nums1[i] = nums2[j];
                }

            }



        }

        /**
         *
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         *
         * nums1 = [1,2,3,0,0,0], m = 3
           nums2 = [2,5,6],       n = 3
         */
        public void merge1(int[] nums1, int m, int[] nums2, int n) {
            int p = m-1;
            int r = n-1;
            int x = m +n-1;

            while (p >=0 && r >= 0) {
                if (nums2[r] > nums1[p]) {
                    nums1[x] = nums2[r];
                    r--;
                } else {
                    nums1[x] = nums1[p];
                    p--;
                }
                x--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

//        new Solution().merge(nums1, 3, nums2, 3);
        new Solution().merge1(nums1, 3, nums2, 3);
        int i=0;
    }

}
