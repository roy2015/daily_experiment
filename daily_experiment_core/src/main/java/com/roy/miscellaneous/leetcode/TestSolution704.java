package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

/**
 * Created by apple on 2019/9/1.
 *
 *给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。


 示例 1:

 输入: nums = [-1,0,3,5,9,12], target = 9
 输出: 4
 解释: 9 出现在 nums 中并且下标为 4
 示例 2:

 输入: nums = [-1,0,3,5,9,12], target = 2
 输出: -1
 解释: 2 不存在 nums 中因此返回 -1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-search
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 二分查找
 */
public class TestSolution704 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution704.class);

    static class Solution {
        public int search(int[] nums, int target) {
            int k = nums[nums.length /2];
            if (target > k ) {
                for (int i = nums.length /2; i < nums.length; i++) {
                    if (nums[i] == target) {
                        return i;
                    }
                }
                return -1;

            } else if (target < k) {
                for (int i = nums.length /2; i >= 0; i--) {
                    if (nums[i] == target) {
                        return i;
                    }
                }
                return -1;

            } else return nums.length /2;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().search(new int[]{-1,0,3,5,9,12}, 2));

    }
}
