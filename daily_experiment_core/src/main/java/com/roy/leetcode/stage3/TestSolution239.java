package com.roy.leetcode.stage3;

import java.util.ArrayDeque;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/28
 *
 *
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 *
 */
public class TestSolution239 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution239.class);


    static class Solution {

        /**
         *
         * 单调队列，参考了题解
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 14 ms, 在所有 Java 提交中击败了64.82%的用户
         * 内存消耗：
         * 53.8 MB, 在所有 Java 提交中击败了6.67%的用户
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (k == 0) {
                return new int[]{};
            }

            int numsLen = nums.length;
            int slideWinLen = numsLen - (k -1);
            int[] ret =  new int[slideWinLen];
            ArrayDeque<Integer> deque = new ArrayDeque<>();

            //窗口形成前
            int i = 0;
            int idxVal;
            for (i = 0; i < k; i++) {
                idxVal =  nums[i];
                if (deque.isEmpty()) {
                    deque.add(idxVal);
                    continue;
                }
                //小于当前的全部出队
                while (!deque.isEmpty() && idxVal > deque.peekLast() ) {
                    deque.removeLast();
                }
                deque.addLast(idxVal);
            }

            int retIdx = 0;
            ret[retIdx ++] = deque.peekFirst();

            //窗口形成后
            for (; i < nums.length; i++) {
                idxVal =  nums[i];
                //窗口去头
                if (deque.peekFirst() == nums[i - k]) {
                    deque.pop();
                }
                //小于当前的全部出队
                while (!deque.isEmpty() && idxVal > deque.peekLast() ) {
                    deque.removeLast();
                }
                deque.addLast(idxVal);
                ret[retIdx ++] = deque.peekFirst();
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxSlidingWindow(
                new int[]{1,3,1,2,0,5}, 3));//3 3 2 5

        logger.info("{}", new Solution().maxSlidingWindow(
                new int[]{1,3,-1,-3,2,3,6,7}, 3));//3, 3, 2, 3, 6, 7

        logger.info("{}", new Solution().maxSlidingWindow(
                new int[]{1,3,-1,-3,5,3,6,7}, 3));//3, 3, 5, 5, 6, 7


        int k =0;
    }
}
