package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/6.
 *
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-element
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 给定 nums = [3,2,2,3], val = 3,

 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

 你不需要考虑数组中超出新长度后面的元素。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-element
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution27 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution27.class);

    /**
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     内存消耗 :36.1 MB, 在所有 java 提交中击败了84.18%的用户
     */
    static class Solution {
        public int removeElement(int[] nums, int val) {
            int i = 0;
            for (int j=0; j < nums.length ; j++) {
                if (nums[j] != val) {
                    nums[i++] = nums[j];
                }
            }
            return i;
        }
    }

    public static void main(String[] args) {
        int[] nums; int val;
        nums = new int[]{0,1,2,2,3,0,4,2};
        val = 2;
        int len = new Solution().removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            logger.info("{}", nums[i]);
        }
    }

}
