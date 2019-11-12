package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by apple on 2019/10/21.
 *给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在众数。

 示例 1:

 输入: [3,2,3]
 输出: 3
 示例 2:

 输入: [2,2,1,1,1,2,2]
 输出: 2

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/majority-element
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution169 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution169.class);

    /**
     *
     *
     * 执行用时 :2 ms, 在所有 java 提交中击败了97.18%的用户
     * 内存消耗 :41.5 MB, 在所有 java 提交中击败了84.05%的用户
     */
    static class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length /2];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().majorityElement(new  int[]{3,2,3}));
    }

}
