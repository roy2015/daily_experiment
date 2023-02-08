package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/23.
 *
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/move-zeroes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution283 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution283.class);

    /**
     * 用双指针法，非0的位去替换0的位 ，O(n) ，如果用冒泡法的话肯定性能差好多 O(n^2)
     *
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     内存消耗 :37.7 MB, 在所有 java 提交中击败了95.42%的用户
     *
     */
    static class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null) {
                return;
            }
            int p1, p2;
            p1 = p2 = -1;
            for (int i =0; i< nums.length; i++) {
                if (nums[i] == 0) {
                    p1 = i;
                    break;
                }
            }
            if (p1 ==-1) {
                return;
            }
            p2 = p1 +1;
            while (p2 < nums.length) {
                if (nums[p2] != 0) {
                    nums[p1 ++] = nums[p2];
                    nums[p2 ++] = 0;
                } else {
                    p2 ++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(ints);
        logger.info("{}");
    }

}
