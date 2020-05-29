package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/6.
 *
 *给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 示例 1:

 给定数组 nums = [1,1,2],

 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

 你不需要考虑数组中超出新长度后面的元素。
 示例 2:

 给定 nums = [0,0,1,1,1,2,2,3,3,4],

 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution26 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution26.class);

    /**
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :41.5 MB, 在所有 java 提交中击败了89.73%的用户
     */
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int i =0;
            if (nums.length ==1) {
                return 1;
            }
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    i++;
                    nums[i] = nums[j];
                }
            }

            return i + 1;
        }
    }

    public static void main(String[] args) {
//        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] ints = {1,1,2};
        int i = new Solution().removeDuplicates(ints);
        logger.info("{}", i);

    }

}
