package com.roy.miscellaneous.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 * 300. 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *  
 *
 * 进阶：
 *
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution300 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution300.class);


    static class Solution {

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         *
         * 执行用时：3 ms, 在所有 Java 提交中击败了94.58%的用户
         * 内存消耗：38.2 MB, 在所有 Java 提交中击败了32.83%的用户
         *
         * @param nums
         * @return
         */
        public int lengthOfLIS(int[] nums) {
            int[] processArray = new int[2501];
            processArray[0] = - 10001;//给一个最小初始值
            int result = 1;
            int len = nums.length;

            for (int i = 0; i < len; i++) {
                int iVal = nums[i];
                int j = result - 1;
                //找到第一个小于给定值的下标，这里可以优化成二分查找
                for (; j >= 0; j--) {
                    if (processArray[j] < iVal) {
                        break;
                    }
                }
                //如果是最后一个，扩容
                if (j == result -1) {
                    result ++;
                } else {}
                processArray[j + 1] = iVal;
            }
            return result - 1;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));//4
        logger.info("{}", new Solution().lengthOfLIS(new int[]{0,1,0,3,2,3}));//4
        logger.info("{}", new Solution().lengthOfLIS(new int[]{7,7,7,7,7,7,7}));//1
    }
}
