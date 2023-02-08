package com.roy.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/18
 *
 *
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 *
 */
public class TestSolution33 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution33.class);


    static class Solution {

        /**
         *
         * 参考了官方的思路（https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/），
         * 旋转数组分隔成两部分之后，至少有一个是有序数组，可以走二分查找
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 39.7 MB
         * , 在所有 Java 提交中击败了
         * 11.55%
         * 的用户
         *
         * @param nums
         * @param target
         * @return
         */
        public int search(int[] nums, int target) {
            int l = 0;
            int h = nums.length - 1;

            while (l <= h) {
                int mid = (l + h) / 2;
                if (nums[mid] == target) {
                    return mid;
                }

                //以mid为界分成两个区间 [l, mid] [mid+1, h] 至少有一个递增区间
                /*前半部分为递增区间*/
                if ((nums[l] <= nums[mid])) {
                    if (target >= nums[l] && target <= nums[mid]) {
                        h = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {//后半部分为递增区间
                    if (target >= nums[mid + 1] && target <= nums[h]) {
                        l = mid + 1;
                    } else {
                        h = mid - 1;
                    }

                }


            }
            return -1;
        }

    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().search(new int[] {4,5,6,7,0,1,2}, 3));//-1

        logger.info("{}", new Solution().search(new int[] {2,3,4,5,6,7,8,9,1}, 9));//7

        logger.info("{}", new Solution().search(
                new int[]{2,4}, 4
        ));//1


        logger.info("{}", new Solution().search(
                new int[]{4,5,6,7,8,0,1,2}, 0
                ));//5
    }
}
