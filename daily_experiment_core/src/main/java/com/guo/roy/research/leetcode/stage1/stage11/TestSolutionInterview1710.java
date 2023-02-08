package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/3/23 15:26
 *
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 *
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 *
 *
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 *
 */
public class TestSolutionInterview1710 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview1710.class);


    static class Solution {
        /**
         *
         * 此题不同于169.多数元素 ,不保证一定有众数，增加了难度
         *
         * 摩尔投票(找过半的投票)：  每次删除两个不同的元素，知道最后剩下一个元素或者多个相同的元素，剩下的即为过半的元素
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 41.6 MB
         * , 在所有 Java 提交中击败了
         * 70.53%
         * 的用户
         *
         * @param nums
         * @return
         */
        public int majorityElement(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }

            int majorityEl = nums[0], count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == majorityEl) {
                    count ++;
                } else if (count == 0) {
                    majorityEl = nums[i];
                    count = 1;
                } else {
                    count --;
                }
            }

            //也可能不是众数，可能是坐收渔利的第三者
            count = 0;
            for (int num : nums) {
                if (num == majorityEl) {
                    count ++;
                }
            }
            if (count > length /2) {
                return majorityEl;
            } else return -1;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().majorityElement(new int[]{47,47,72,47,72,47,79,47,12,92,13,47,47,83,33,15,18,47,47,47,47,64,47,65,47,47,47,47,70,
                47,47,55,47,15,60,47,47,47,47,47,46,30,58,59,47,47,47,47,47,90,64,37,20,47,100,
                84,47,47,47,47,47,89,47,36,47,60,47,18,47,34,47,47,47,47,47,22,47,54,30,11,47,
                47,86,47,55,40,49,34,19,67,16,47,36,47,41,19,80,47,47,27}));//47
        logger.info("{}", new Solution().majorityElement(new int[]{1}));//1
        logger.info("{}", new Solution().majorityElement(new int[]{1,2,5,9,5,9,5,5,5}));//5
        logger.info("{}", new Solution().majorityElement(new int[]{3,2}));//-1
        logger.info("{}", new Solution().majorityElement(new int[]{2,2,1,1,1,2,2}));//2
        logger.info("{}", new Solution().majorityElement(new int[]{1,2,3}));//-1


    }
}
