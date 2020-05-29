package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * Created by apple on 2019/9/21.
 *
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

 nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

 示例 1:

 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 输出: [-1,3,-1]
 解释:
 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 示例 2:

 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 输出: [3,-1]
 解释:
     对于num1中的数字2，第二个数组中的下一个较大数字是3。
 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 注意:

 nums1和nums2中所有元素是唯一的。
 nums1和nums2 的数组大小都不超过1000。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/next-greater-element-i
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution496 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution496.class);

    static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] retNums = new int[nums1.length];
            Stack<Integer> nums2Stack = new Stack();


            for (int i = 0; i < nums1.length; i++) {
                nums2Stack.clear();

                for (int i1 = nums2.length - 1; i1 >= 0; i1--) {
                    nums2Stack.push(nums2[i1]);
                }

                retNums[i] = -1;
                while (nums2Stack.pop() != nums1[i]) {
                }

                if (nums2Stack.isEmpty()) {
                    retNums[i] = -1;
                } else {
                    Integer pop;
                    while (!nums2Stack.isEmpty()) {
                        pop = nums2Stack.pop();
                        if (pop > nums1[i]) {
                            retNums[i] = pop;
                            break;
                        }
                    }
                }
            }
            return retNums;
        }
    }

    public static void main(String[] args) {

        int[] ints = new Solution().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        logger.info("{}");
    }
}
